package com.objectivemonsters.game;

import com.objectivemonsters.dungeon.Dungeon;
import com.objectivemonsters.player.Player;
import com.objectivemonsters.util.Prompter;

import java.util.List;
import java.util.Scanner;

public class GameController {

    //list of acceptable verbs
    List<String> gameVerbs = List.of("GO", "LOOK", "TAKE", "FIGHT");
    //allow user to interact
    private Prompter prompter;
    //need dungeon
    private Dungeon dungeon;
    //need player
    private Player player;

    //ctors
    public GameController() {
        this.prompter = new Prompter(new Scanner(System.in));
    }

    public GameController(Dungeon dungeon, Player player) {
        //Later version create setters, and pass to setters to validate
        this.prompter = new Prompter(new Scanner(System.in));
        this.dungeon = dungeon;
        this.player = player;
    }

    //start game
    public void startGame() {
        //welcome user and give hints
        welcome();
    }

    //welcome
    public void welcome() {
        System.out.println("---------------------------------------");
        System.out.println("WELCOME TO MONSTER BATTLES: DUNGEON EDITION");
        System.out.println("---------------------------------------");
        String userName = prompter.prompt("What is your name? >");
        System.out.println("Welcome " + userName);
        System.out.println("You awake in a dungeon full of monsters, some are willing to help you escape, others wish to consume you!\n" +
                "Escaping this dungeon requires you to defeat the evil monsters, but you are nowhere near powerful enough to defeat them on your own!\n" +
                "Perhaps you can find monsters that are willing to help you in your quest.\n");
        String getHint = prompter.prompt("Would you like hints on how to play the game? type y/n >");
        if (getHint.equals("y")) {
            hints();
        }
        //run game
    }

    //control hints
    public void hints() {
        System.out.println("In order to traverse the dungeon, you will be provided with options on what to do.\n" +
                "You must type a recognized action, followed by a noun, in order to move and interact.\n" +
                "Example: If you would like to move into an available room, you would type GO ROOMNAME. If you would like to inspect your surroundings, you would type LOOK AROUND\n" +
                "List of recognized actions - " + gameVerbs);
    }
}