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

    //list of acceptable verbs
    List<String> gameVerbs = List.of("GO", "LOOK", "TAKE", "FIGHT");
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
    //current monster
    private Monster currentMonster;
    //testing prompter and user name entry
    private String playerName;

    // generate monsters
    MonsterGenerator monGeny = new MonsterGenerator();

    // generate battleText
    BattleTextGenerator btg = new BattleTextGenerator();

    // generate storyText
    StoryLineGenerator slg = new StoryLineGenerator();


    public GameController(Dungeon dungeon, List<Monster> gammons, Player player) {
        //Later version create setters, and pass to setters to validate
        this.prompter = new Prompter(new Scanner(System.in));
        this.battleSystem = new BattleSystem();
        this.dungeon = dungeon;
        this.gameMonsters = gammons;
        this.player = player;

        startRoom = dungeon.getDungeonRooms().get(0);
        currentRoom = startRoom;


    }



    //start game
    public void startGame() {
        //welcome user and give hints
//        welcome();
        //show user the room they are in
//        startRoom = dungeon.getDungeonRooms().get(0);
//        currentRoom = startRoom;
//        displayRoomScene(startRoom);

//        //begin game loop
//        boolean gameOver = false;
//        while (!gameOver) {
//
//            boolean stillPlaying = playerAction();
//
//            if (!stillPlaying) {
//                gameOver = true;
//            }
//        }
    }

    //welcome
    public void welcome() {
        List<Monster> locaMons = monGeny.aMonsters(gameMonsters);

        for (Monster mons : locaMons
             ) {
            System.out.println(mons.getName());
        }

        List<Monster> locMons = monGeny.fMonsters(gameMonsters);
        for (Monster monsters : locMons
        ) {
            System.out.println(monsters.getName());
        }

        Monster newMon = new Monster();
        newMon = monGeny.randoMon(gameMonsters);
        System.out.println(newMon);

        System.out.println(monGeny.randoMon(gameMonsters));
        System.out.println(btg.oneMiss());
        storyBits = slg.getStoryTxt();


        System.out.println(storyBits.get("welcome") + " Zelda"); // change Zelda to player name
        System.out.println(storyBits.get("opening"));
        System.out.println(storyBits.get("moreInfo"));
        System.out.println(storyBits.get("friendlyGesture"));
        System.out.println(storyBits.get("hint"));


        System.out.println();

        System.out.println("---------------------------------------");
        System.out.println("WELCOME TO MONSTER BATTLES: DUNGEON EDITION");
        System.out.println("---------------------------------------");
        playerName = prompter.prompt("What is your name? >");
        System.out.println("Welcome " + playerName);
        System.out.println("You awake in a dungeon full of monsters, some are willing to help you escape, others wish to consume you!\n" +
                "Escaping this dungeon requires you to defeat the evil monsters, but you are nowhere near powerful enough to defeat them on your own!\n" +
                "Perhaps you can find monsters that are willing to help you in your quest.\n");
        String getHint = prompter.prompt("Would you like hints on how to play the game? type y/n >");
        if (getHint.equals("y")) {
            hints();
        }
    }

    //control hints
    public void hints() {
        System.out.println("In order to traverse the dungeon, you will be provided with options on what to do.\n" +
                "You must type a recognized action, followed by a noun, in order to move and interact.\n" +
                "Example: If you would like to move into an available room, you would type GO ROOMNAME. If you would like to inspect your surroundings, you would type LOOK AROUND\n" +
                "List of recognized actions - " + gameVerbs);
    }

    //Display the scene of the room
    public String displayRoomScene() {
        StringBuilder sb = new StringBuilder();
        currentMonster = monGeny.randoMon(gameMonsters);

        sb.append(player.getName()).append(", you are currently in the ").append(currentRoom.getName());
        sb.append(". You scan the room to see ").append(currentRoom.getDescription());
        sb.append(". You also notice there appears to be exits into other rooms ").append(currentRoom.getExits());
//        if (currentRoom.getRoomMonster() != null) {
            sb.append(". As you are looking around you notice a creature in the corner by the name of ").append(currentMonster.getName());
            String friendOrFoe = currentMonster.isFriendly()? " This monster appears to be friendly" : " Be careful this creature is no friend to you";
            sb.append(friendOrFoe);
//        }
        return sb.toString();
    }

    //action user wishes to take
    //TODO: more work needed, this is very basic for sprint 1
    public String playerAction(String playerAction) {
//        boolean isGameStillGoing = true;
        String message = "";
//        String[] action = prompter.prompt("What would you like to do? ", gameVerbs, "I'm sorry I don't recognize those commands, please try again").split(" ");
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
            System.out.println("Monster added to your inventory");
        }
        else if (verb.equals("fight") && !roomMonster.isFriendly() && player.getpMonsters().size() > 0) {
            //battle monsters
            message = battleSystem.battle(player.getpMonsters().get(0), roomMonster);
//            if (battleWinner.getName().equals(roomMonster.getName())) {
////                isGameStillGoing = false;
//                message = "Your monster has perished in battle, and now " + roomMonster.getName() + " has turned its attention towards you!\n" +
//                        "You have been devoured in the dungeon! GAME OVER!";
//            }
//            else {
////                isGameStillGoing = false;
//                message = "Your monster is triumphant, the evil " + roomMonster.getName() + " has been slayed.\n" +
//                        playerName + " you have defeated all the monsters in this dungeon, you are truly a great adventurer";
//            }
        }
        return message;
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


