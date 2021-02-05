package com.objectivemonsters.game;

import com.objectivemonsters.map.Dungeon;
import com.objectivemonsters.map.Room;
import com.objectivemonsters.monsters.Monster;
import com.objectivemonsters.monsters.MonsterGenerator;
import com.objectivemonsters.player.Player;
import com.objectivemonsters.storylines.BattleTextGenerator;
import com.objectivemonsters.storylines.StoryLineGenerator;
import com.objectivemonsters.util.Prompter;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GameController {
    //XP BOOSTS
    private static final int STRENGTH_XP_BOOST = 10;

    //list of acceptable verbs
    List<String> gameVerbs = List.of("GO", "LOOK", "TAKE", "FIGHT"); // eventually these will come from xml
    //combat system
    private BattleSystem battleSystem;
    //allow user to interact
    private Prompter prompter;
    //need dungeon
    private Dungeon dungeon;
    //need monsters
    private List<Monster> gameMonsters;
    //battle text hits
    private HashMap<String, String> storyBits = new HashMap<>();
    //need player
    private Player player;
    //start room
    private Room startRoom;
    //current room
    private Room currentRoom;
    // starter monster
    private Monster startMonster;
    //current monster
    private Monster currentMonster;
    //testing prompter and user name entry
    private String playerName;
    //TODO: Track Player monster


    // class holding the random monsters and angry, friendly lists -- all monsters are in the monsterlist class
    MonsterGenerator monGeny = new MonsterGenerator();

    // generate battleText - can access the methods to retrieve random battle lines for hits and misses
    BattleTextGenerator btg = new BattleTextGenerator();

    // generate storyText slg w/ story bits will yield, well story bits
    StoryLineGenerator slg = new StoryLineGenerator();


    public GameController(Dungeon dungeon, List<Monster> gammons, Player player) {
        //Later version create setters, and pass to setters to validate
        this.prompter = new Prompter(new Scanner(System.in));
        this.battleSystem = new BattleSystem();
        this.dungeon = dungeon;
        this.gameMonsters = gammons;
        this.player = player;

        startRoom = dungeon.getDungeonRooms().get(0);
        gameMonsters = dungeon.getDungeonMonsters();
        startMonster = monGeny.randoFriendlyMon();
        currentMonster = startMonster;
        currentRoom = startRoom;
    }

    //TODO: Put xml storylines for main game and gameover text


    //Display the scene of the room
    public String displayRoomScene() {
        StringBuilder sb = new StringBuilder();
        currentMonster = monGeny.randomMonster();
        //System.out.println(currentMonster);

        sb.append(player.getName()).append(", you are currently in the ").append(currentRoom.getName());
        sb.append(". You scan the room to see ").append(currentRoom.getDescription());
        sb.append(". You also notice there appears to be exits into other rooms ").append(currentRoom.getExits());

        sb.append(". As you are looking around you notice a creature in the corner by the name of ").append(currentMonster.getName());
        String friendOrFoe = currentMonster.isFriendly()? " This monster appears to be friendly" : " Be careful this creature is no friend to you";
        sb.append(friendOrFoe);

        if (currentRoom.isHasExitDoor()){ // description for the dungeon door if its in current room.
         String dungeonExitDesc = "\n" + " Wait a minute, you saw light shine in from a giant stone door, That must be the exit of the dungeon";
         sb.append(dungeonExitDesc);
        }
        return sb.toString();
    }

    //action user wishes to take
    //TODO: more work needed, this is very basic for sprint 1
    public String playerAction(String playerAction) {
        String message = "";
        String[] action = playerAction.split(" ");
        String verb = action[0];
        String noun = action[1];
        Monster roomMonster = currentMonster;

        if (verb.equals("look") && noun.equals("around")) {
            message = displayRoomScene();
        }
        else if (verb.equals("go") && isWordAnExit(noun)) {
            //set new room to current room
            setCurrentRoom(getNextRoomName(noun));
            //move player to new room
            message = displayRoomScene();
        }
        else if (verb.equals("take") && roomMonster.isFriendly()) {
            //add monster to users monster collection
            player.getpMonsters().add(roomMonster);
        }
        else if (verb.equals("fight") && !roomMonster.isFriendly() && player.getpMonsters().size() > 0) {
            Monster playerMonster = player.getpMonsters().get(0);
            //battle monsters
            message = battleSystem.battle(playerMonster, roomMonster);
            if (playerMonster.getHP() <= 0) {
               //player monster loses
                message = userMonsterLoses(playerMonster);
            } else if  (currentMonster.getHP() <= 0) {
                // if enemy killed call function for winning
                message = killedAngryMonster();

            }
            }

        return message;
    }

    public String killedAngryMonster() {
        Monster playerMonster = player.getpMonsters().get(0);
        playerMonster.setHP(100);
        int currStrength = playerMonster.getStrength();
        playerMonster.setStrength((currStrength + STRENGTH_XP_BOOST));
        player.dropShard();
        System.out.println(player.getpShards().size());
        String htmlMess = "<h2 class='text'><span class='user'>" + playerMonster.getName() + "</span> " +
                "has defeated <span class='enemy'> " + currentMonster.getName() + "</span><br><span class='user'> " + playerMonster.getName() + "</span> " +
                "has grown in experience regaining full HP and a strength boost from <span class='damage'> " + currStrength + " Strength - " + playerMonster.getStrength() +
                " Strength</span><br>You also pick up a <span class='shard'>"+ player.getpShards().get(player.getpShards().size() - 1)+"</span> that has fallen from the defeated creature</h2>";
        return htmlMess;
    }

    public String userMonsterLoses(Monster losingUserMonster) {
        player.getpMonsters().remove(losingUserMonster);

        String htmlMess = "<h2 class='text'><span class='user'>" + losingUserMonster.getName() + "</span> has died in battle to <span class='enemy'> "
                + currentMonster.getName() + "</span></h2>";

        return htmlMess;
    }

    //check is user is out of monsters or if player has the key and there are a exit door in the currentRoom.
    public boolean isGameOver() {
        boolean isOver = false;
        if (player.getpMonsters().size() == 0 || (player.getKey() && currentRoom.isHasExitDoor())) {
            isOver = true;
        }
        return isOver;
    }



    //check if noun typed is an actual available exit
    public boolean isWordAnExit(String word) {
        boolean result = false;

        for (String room : currentRoom.getExits()) {
            if (room.equals(word)) {
                result = true;
                break;
            }
        }

        return result;
    }

    // Base on input direction e.g. east return the next room name.
    public String getNextRoomName(String word){
        String nextRoomName;
        int index = currentRoom.getExits().indexOf(word);
        nextRoomName = currentRoom.getRoomLeadTo().get(index);
        return nextRoomName;
    }

    //set the current room
    public void setCurrentRoom(String roomName) {
        for (Room room : dungeon.getDungeonRooms()) {
            if (roomName.equals(room.getName())) {
                currentRoom = room;
                break;
            }
        }
    }

    public Monster getCurrentMonster() {
        return currentMonster;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}