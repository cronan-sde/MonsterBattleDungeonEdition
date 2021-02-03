package com.objectivemonsters.game;

import com.objectivemonsters.dungeon.Dungeon;
import com.objectivemonsters.monsters.Monster;
import com.objectivemonsters.monsters.MonsterGenerator;
import com.objectivemonsters.player.Player;
import com.objectivemonsters.scenes.BattleScene;
import com.objectivemonsters.scenes.MainScene;
import com.objectivemonsters.scenes.StartScene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/*
 * GameGUI is the GUI for the game, it will display a start screen to welcome user to game along with
 * helpful hints on how to play. When user presses [enter] the GUI will change to the main game.
 * GameGUI will update its components as the state of the game changes
 * TODO: Tie classes needed into GameGUI to be able to update interface, and pass data to and from game controller
 *  TODO: NEED A BATTLE SCENE TO BE DISPLAYED
 *   TODO: NEED TO COLOR TEXT
 *    TODO: NEED TO REFACTOR
 *     TODO: Find a way to move scenes elsewhere to clean up code
 */
public class GameGUI extends JFrame implements KeyListener {
    //width and height for frame
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;

    //game fonts
    private static final String GAME_FONT = "Times New Roman";


    //boolean to track if user is on start screen or main game screen
    private boolean isStartScreen = true;
    private boolean isMainScreen = false;
    private boolean isBattleScreen = false;

    //Game pieces
    private Player player;
    private Dungeon dungeon;
    private GameController controller;

    //testing scenes
    private StartScene startScene;
    private MainScene mainScene;
    private BattleScene battleScene;


    //ctor to create GUI
    public GameGUI() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT); //set frame size
        setDefaultCloseOperation(EXIT_ON_CLOSE); //ensure program exits when window is closed
        getContentPane().setBackground(Color.BLACK); //set frame background color to black
        setLayout(null);
        setLocationRelativeTo(null); //opens window in center of screen
        setTitle("Monster Battles: Dungeon Edition");

        //Add initial start screen with hints and text to tell user to press enter to continue
        startScene = new StartScene(FRAME_WIDTH, FRAME_HEIGHT, GAME_FONT);
        startScene.getHintText().addKeyListener(this);
        startScene.addKeyListener(this);
        add(startScene);

        setVisible(true);
    }

    /*
     * Method will set main game screen with current inventory and current room description
     * game loop will be in this method
     */
    public void startGame() {
        //initialize game pieces
        GameInitializer initializer = new GameInitializer();
        dungeon = initializer.dungeonInit();
        MonsterGenerator mongen = new MonsterGenerator();
        List<Monster> monster = mongen.allMonsters();
        player = new Player("player1", new ArrayList<>(), new ArrayList<>());
        player.setName("Cool Dude");
        controller = new GameController(dungeon, monster, player);

        //initialize main game screen
        showMainGameScene();
    }

    //Initializes the main game scene
    public void showMainGameScene() {
        mainScene = new MainScene(FRAME_WIDTH, FRAME_HEIGHT, GAME_FONT);
        mainScene.getInputText().addKeyListener(this);
        add(mainScene);
        //set inventory and desc text for main room
        updateInventory();
        dungeonStart();
    }

    /*
     * Display the battle scene
     */
    public void showBattleScene() {
        isBattleScreen = true;
        battleScene = new BattleScene(FRAME_WIDTH, FRAME_HEIGHT, GAME_FONT);
        battleScene.getBattleTextArea().addKeyListener(this);
        battleScene.addKeyListener(this);
        add(battleScene);

        //hardcoded dummy text to show potential
        String htmlBattle = "<h2 class='text'>" +
                "<span class='user'>Drowsy Dragon</span> charges out and <span class='attack'>slashes </span><span class='enemy'>Bad Guy</span> across the " +
                "face causing <span class='damage'>25 dmg.</span>" +
                "</h2>";
        battleScene.setHTMLString(htmlBattle);
        battleScene.getEvilMonsterHP().setText("Bad Monster: 75 HP");
    }

    /*
     * Updates the user inventory labels to reflect Players current state
     * TODO: ensure working, call after every player turn? or somehow track when items and monsters are picked up then call
     */
    public void updateInventory() {
        JLabel userMonsters = mainScene.getUserMonsterLabel();
        JLabel userInventory = mainScene.getUserInventoryLabel();
        JLabel userShards = mainScene.getUserShardLabel();
        JLabel userKeys = mainScene.getUserKeyLabel();

        userMonsters.setText("MONSTERS:" + playerMonstersLabel());
        userInventory.setText("Inventory:" + player.getpItems());
        userShards.setText("Shards: 0/10"); //TODO: figure out shards, total shards will be # of bad monsters in dungeon
        userKeys.setText("Keys: 0/1"); //TODO: figure out key, currently only 1 key per level, shards morph into key
    }

    //create player monster label string
    private String playerMonstersLabel() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (Monster monster : player.getpMonsters()) {
            if (monster.getName().equals(player.getpMonsters().get(player.getpMonsters().size() - 1).getName())) {
                sb.append(monster.getName());
            }
            else {
                sb.append(monster.getName()).append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    /*
     * Sets the main text area to the description of current room
     * Done: currently gets first room in dungeon list, need to get this information and dynamically change roomDesc
     */
    public void dungeonStart() {
        String roomName = controller.getCurrentRoom().getName();
        String roomDesc = controller.getCurrentRoom().getDescription();

        JTextArea mainText = mainScene.getMainTextArea();
        mainText.setText("You have entered the " + roomName + " room. " + roomDesc);
    }

    /*
     * Generating the main GUI for the game
     * hides the start screen panels
     * initializes the main games panels and components
     * adds main game panels to the frame
     * calls updateInventory() and dungeonStart()
     */
    public void hideStartScreen() {
        //hide start screen
        startScene.setVisible(false);

        //start game
        startGame();
    }

    public void hideMainScreen() {
        //hide main screen
        mainScene.setVisible(false);

        //call show battle
        showBattleScene();
    }

    public void hideBattleScreen() {
        battleScene.setVisible(false);

        //show game over
//        showGameOver();
    }


    /*
     * Implementing abstract methods from the KeyListener class
     */

    /*
     * When enter is pressed and user is currently on start screen, the main
     * game screen will be presented to user to begin the game
     * When enter is pressed and user is in main game, the input text they typed will
     * be grabbed to continue flow of game
     * TODO: Determine what to do with the user input, validate in game controller?
     *  add an error box popup if not valid input?
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (isStartScreen && e.getKeyCode() == KeyEvent.VK_ENTER) {
            isStartScreen = false;
            isMainScreen = true;
            hideStartScreen();
        }
        else if (isMainScreen && e.getKeyCode() == KeyEvent.VK_ENTER) {
            String userInput = mainScene.getInputText().getText();
            if (userInput.toLowerCase().equals("fight monster")) {
                isBattleScreen = true;
                mainScene.getInputText().setText("");
                hideMainScreen();
            }
            else {
                String description = controller.playerAction(userInput);
                if (description.length() != 0) {
                    mainScene.getMainTextArea().setText(description);
                }
                mainScene.getInputText().setText("");
                updateInventory();
            }
        }
        else if (isBattleScreen && e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("IN CONTINUE BATTLE");
            //check if game is over
            //get 1 round of battle info to display
            //update hp labels
        }
        else if (isBattleScreen && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.out.println("IN BATTLE ESCAPE");
            isBattleScreen = false;
            battleScene.setVisible(false);
            mainScene.setVisible(true);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /*
     * TODO: MAIN METHOD ONLY FOR TESTING PURPOSES, WILL BE REMOVED IN FINAL VERSION AND CALLED FROM MAIN CLIENT
     */
    public static void main(String[] args) {
        new GameGUI();
    }
}