package com.objectivemonsters.game;

import com.objectivemonsters.map.Dungeon;
import com.objectivemonsters.map.Room;
import com.objectivemonsters.monsters.Monster;
import com.objectivemonsters.monsters.MonsterGenerator;
import com.objectivemonsters.monsters.MonsterLocationGenerator;
import com.objectivemonsters.player.Player;
import com.objectivemonsters.storylines.BattleTextGenerator;
import com.objectivemonsters.storylines.BattleTextList;
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
    //DONE: Track Player monster
    private Monster curPlayerMonst;


    // class holding the random monsters and angry, friendly lists -- all monsters are in the monsterlist class
    MonsterGenerator monGeny = new MonsterGenerator();

    // monster location generator
    MonsterLocationGenerator monLocGen = new MonsterLocationGenerator();

    // generate battleText - can access the methods to retrieve random battle lines for hits and misses
    BattleTextGenerator btg = new BattleTextGenerator();
    BattleTextList btl = new BattleTextList();

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
        sb.append(" room. \n").append(currentRoom.getDescription());

        // TODO: append a random generated location based on friendly or angry - maybe screen maybe full enough of info
        if (currentRoom.isHasExitDoor()){ // description for the dungeon door if its in current room.
            String dungeonExitDesc = "\n" + "Wait a minute, you saw light shine in from a giant stone door, That must be the exit of the dungeon.";
            sb.append(dungeonExitDesc);
        }
        sb.append(". \n\nExits appear:  ").append(currentRoom.getExits());
        sb.append(".\nYou notice a creature in the corner. It's ").append(currentMonster.getName()).append(".");
        sb.append("\nHP : ").append(currentMonster.getHP()).append("  Strength: ").append(currentMonster.getStrength()).append("  Agility: ").append(currentMonster.getAgility()).append("  Intellect: ").append(currentMonster.getIntellect());
//        sb.append("\n").append(currentMonster.getDesc());  only include if shortened to one line, probably too much info already
        String friendOrFoe = currentMonster.isFriendly()? "\nThis monster appears to be friendly." : "\nThis monster looks Angry.";
        sb.append(friendOrFoe);

        return sb.toString();
    }

    //action user wishes to take
    //DONE: more work needed, this is very basic for sprint 1
    public String playerAction(String playerAction) {
        String message = "";
        String[] action = validateUserInput(playerAction);
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
            message = getCurrentRoom().getDescription();
        }
        else if (verb.equals("take") && noun.equals("monster") && roomMonster.isFriendly()) {
            //DONE: only allow to take 3 monsters and no duplicates
            if (player.getpMonsters().size() < 3 && monsterNotDuplicate()) {
                //add monster to users monster collection
                player.getpMonsters().add(roomMonster);
            }
            //current player monster will be assigned when monster added, currently will always be 1st monster
            curPlayerMonst = player.getpMonsters().get(0);
        }
        else if ((verb.equals("fight") && noun.equals("monster")) && (!roomMonster.isFriendly() && player.getpMonsters().size() > 0)) {
            //battle monsters
            message = battleSystem.battle(curPlayerMonst, roomMonster);
            if (curPlayerMonst.getHP() <= 0) {
               //player monster loses
                message += userMonsterLoses(curPlayerMonst);
            } else if  (currentMonster.getHP() <= 0) {
                // if enemy killed call function for winning
                message += killedAngryMonster();

            }
        }
        return message;
    }

    /*
     * validates the user input and sends back a String[] to be used by the playerAction method
     * ensures the program doesn't blow up with invalid inputs
     * also allows the user the choice to type monster or a monsters name to take and fight
     */
    public String[] validateUserInput(String userInput) {
        String[] actionToTake = null;
        String[] input = userInput.trim().split(" ");
        if (input.length == 2) {
            actionToTake = input;
        }
        else if (input.length == 3 || input.length == 4) {
            String verb = input[0];
            if (verb.toLowerCase().equals("take") || verb.toLowerCase().equals("fight")) {
                String monsterName = input.length == 4 ? String.join(" ", input[1], input[2], input[3]) : String.join(" ", input[1], input[2]);

                if (monsterName.toLowerCase().equals(currentMonster.getName().toLowerCase())) {
                    actionToTake = new String[]{verb, "monster"};
                }
            }
        }
        else if (input.length == 1) {
            String verb = input[0];
            String noun = "";
            actionToTake = new String[]{verb, noun};
        }

        return actionToTake;
    }

    public String dungeonWinText() {
        return "You have unlocked the dungeon door with the shard key\n" +
                "Congratulations you have escaped the monster dungeon!\nand set all your monsters free!\n" +
                "You truly are an amazing adventurer!";
    }

    public String dungeonLoseText() {
        return "You're monsters have all been slain and without their help you cannot kill the angry monsters." +
                "\n" +
                getCurrentMonster().getName() + " has consumed you!";
    }

    public String killedAngryMonster() {
        Monster playerMonster = player.getpMonsters().get(0);
        playerMonster.setHP(100);
        int currStrength = playerMonster.getStrength();
        playerMonster.setStrength((currStrength + STRENGTH_XP_BOOST));
        player.dropShard();

        String htmlMess = "<h2 class='text'><span class='user'>" + playerMonster.getName() + "</span> " +
                "has defeated <span class='enemy'> " + currentMonster.getName() + "</span><br><br><span class='user'> " + playerMonster.getName() + "</span> " +
                "has regained full HP and a strength boost from <span class='damage'> " + currStrength + " to " + playerMonster.getStrength() +
                " Strength</span><br><br>You also pick up a <span class='shard'>"+ player.getpShards().get(player.getpShards().size() - 1)+"</span> that has fallen from the defeated creature</h2>";
        return htmlMess;
    }

    public String userMonsterLoses(Monster losingUserMonster) {
        player.getpMonsters().remove(losingUserMonster);

        String htmlMess = "<h2 class='text'><span class='user'>" + losingUserMonster.getName() + "</span> has died in battle to <span class='enemy'> "
                + currentMonster.getName() + "</span></h2>";

        return htmlMess;
    }

    //check to make sure monster being added to player is not already there
    //helps avoid adding duplicate monsters to player list
    private boolean monsterNotDuplicate() {
        boolean isNotDuplicate = true;

        for (Monster monster : player.getpMonsters()) {
            if (monster.getName().equals(getCurrentMonster().getName())) {
                isNotDuplicate = false;
                break;
            }
        }

        return isNotDuplicate;
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

    public Monster getCurPlayerMonst() {
        return curPlayerMonst;
    }

    /*
     * allows the cur player monster to be set
     * when user monster dies, needs to be called
     */
    public void setCurPlayerMonst() {
        if (player.getpMonsters().size() > 0) {
            curPlayerMonst = player.getpMonsters().get(0);
        }
    }
}