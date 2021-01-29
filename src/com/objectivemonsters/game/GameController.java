package com.objectivemonsters.game;

import com.objectivemonsters.dungeon.Dungeon;
import com.objectivemonsters.dungeon.Room;
import com.objectivemonsters.monsters.Monster;
import com.objectivemonsters.player.Player;
import com.objectivemonsters.util.Prompter;

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
    //need player
    private Player player;
    //start room
    private Room startRoom;
    //current room
    private Room currentRoom;
    //testing prompter and user name entry
    private String playerName;

    //ctor
    public GameController() {
        this.prompter = new Prompter(new Scanner(System.in));
        this.battleSystem = new BattleSystem();
    }

    public GameController(Dungeon dungeon, Player player) {
        //Later version create setters, and pass to setters to validate
        this.prompter = new Prompter(new Scanner(System.in));
        this.battleSystem = new BattleSystem();
        this.dungeon = dungeon;
        this.player = player;
    }

    //start game
    public void startGame() {
        //welcome user and give hints
        welcome();
        //show user the room they are in
        startRoom = dungeon.getDungeonRooms().get(0);
        currentRoom = startRoom;
//        displayRoomScene(startRoom);

        //begin game loop
        boolean gameOver = false;
        while (!gameOver) {

            boolean stillPlaying = playerAction();

            if (!stillPlaying) {
                gameOver = true;
            }
        }
    }

    //welcome
    public void welcome() {
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
    public void displayRoomScene(Room currentRoom) {
        System.out.println(playerName + ", you are currently in the " + currentRoom.getName());

        System.out.println("You scan the room to see " + currentRoom.getDescription());
        System.out.println("You also notice there appears to be exits into other rooms " + currentRoom.getroomLeadTo());
        if (currentRoom.getRoomMonster() != null) {
            System.out.println("As you are looking around you notice a creature in the corner by the name of " + currentRoom.getRoomMonster().getName());
            String friendOrFoe = currentRoom.getRoomMonster().isFriendly() ? "This monster appears to be friendly" : "Be careful this creature is no friend to you";
            System.out.println(friendOrFoe);
        }
    }

    //action user wishes to take
    //TODO: more work needed, this is very basic for sprint 1
    public boolean playerAction() {
        boolean isGameStillGoing = true;
        String[] action = prompter.prompt("What would you like to do? ", gameVerbs, "I'm sorry I don't recognize those commands, please try again").split(" ");
        String verb = action[0];
        String noun = action[1];
        Monster roomMonster = currentRoom.getRoomMonster();

        if (verb.equals("look") && noun.equals("around")) {
            displayRoomScene(currentRoom);
        }
        else if (verb.equals("go") && isWordAnExit(noun)) {
            //set new room to current room
            setCurrentRoom(noun);
            //move player to new room
            displayRoomScene(currentRoom);
        }
        else if (verb.equals("take") && roomMonster.isFriendly()) {
            //add monster to users monster collection
            player.getpMonsters().add(roomMonster);
        }
        else if (verb.equals("fight") && !roomMonster.isFriendly() && player.getpMonsters().size() > 0) {
            //battle monsters
            Monster battleWinner = battleSystem.battle(player.getpMonsters().get(0), roomMonster);
            if (battleWinner.getName().equals(roomMonster.getName())) {
                isGameStillGoing = false;
                System.out.println("Your monster has perished in battle, and now " + roomMonster.getName() + " has turned its attention towards you!\n" +
                        "You have been devoured in the dungeon! GAME OVER!");
            }
            else {
                isGameStillGoing = false;
                System.out.println("Your monster is triumphant, the evil " + roomMonster.getName() + " has been slayed.\n" +
                        playerName + " you have defeated all the monsters in this dungeon, you are truly a great adventurer");
            }
        }
        return isGameStillGoing;
    }

    //check if noun typed is an actual available exit
    public boolean isWordAnExit(String word) {
        boolean result = false;

        for (String room : currentRoom.getroomLeadTo()) {
            if (room.equals(word)) {
                result = true;
                break;
            }
        }

        return result;
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
}