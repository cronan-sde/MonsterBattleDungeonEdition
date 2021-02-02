package com.objectivemonsters.game;

import com.objectivemonsters.dungeon.Dungeon;
import com.objectivemonsters.monsters.Monster;
import com.objectivemonsters.monsters.MonsterGenerator;
import com.objectivemonsters.player.Player;

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

    //list of acceptable verbs - hard coded currently - TODO: get game verbs from somewhere else, XML?
    java.util.List<String> gameVerbs = List.of("GO", "LOOK", "TAKE", "FIGHT");

    //JPanels needed for Frame for the start game screen
    private JPanel welcomePanel, hintPanel, playPanel;
    private JTextArea welcomeText, hintText, playText;

    //boolean to track if user is on start screen or main game screen
    private boolean isStartScreen = true;

    //JPanels needed for Frame for the main game screen
    private JPanel inventoryPanel, mainTextPanel, inputPanel;
    //labels for inventoryPanel
    private JLabel userMonsterLabel;
    private JLabel userInventoryLabel;
    private JLabel userShardLabel;
    private JLabel userKeyLabel;
    //text area for mainTextPanel
    private JTextArea mainTextArea;
    //text field for user input
    private JTextField inputText;

    //Game pieces
    private Player player;
    private Dungeon dungeon;
    private GameController controller;


    //ctor to create GUI
    public GameGUI() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT); //set frame size
        setDefaultCloseOperation(EXIT_ON_CLOSE); //ensure program exits when window is closed
        getContentPane().setBackground(Color.BLACK); //set frame background color to black
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null); //opens window in center of screen
        setTitle("Monster Battles: Dungeon Edition");
        //Add initial start screen with hints and text to tell user to press enter to continue
        setStartScreen();
        add(getWelcomePanel());
        add(getHintPanel());
        add(getPlayPanel());
        setStartDialogue();

        //add keyListener to all components
        addKeyListener(this);

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
        welcomePanel.setVisible(false);
        hintPanel.setVisible(false);
        playPanel.setVisible(false);

        //start game
        startGame();
    }

    /*
     * MAIN GAME SCREEN
     */

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
        controller = new GameController(dungeon, monster, player);

        //initialize main game screen
        showMainGame();
    }

    public void showMainGame() {
        //initialize main gui components
        setInventoryPanel();
        setMainTextPanel();
        setInputPanel();
        //add to frame
        add(getInventoryPanel());
        add(getMainTextPanel());
        add(getInputPanel());
        //set inventory and desc text for main room
        updateInventory();
        dungeonStart();
    }

    /*
     * Updates the user inventory labels to reflect Players current state
     * TODO: ensure working, call after every player turn? or somehow track when items and monsters are picked up then call
     */
    public void updateInventory() {
        JLabel userMonsters = getUserMonsterLabel();
        JLabel userInventory = getUserInventoryLabel();
        JLabel userShards = getUserShardLabel();
        JLabel userKeys = getUserKeyLabel();

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
     * TODO: currently gets first room in dungeon list, need to get this information and dynamically change roomDesc
     */
    public void dungeonStart() {
        String roomName = controller.getCurrentRoom().getName();
        String roomDesc = controller.getCurrentRoom().getDescription();

        JTextArea mainText = getMainTextArea();
        mainText.setText("You have entered the " + roomName + " room. " + roomDesc);
    }

    /*
     * Sets up the starting scene with a welcome message, hints on how to play the game, and a prompt on starting the game on a keypress
     */
    public void setStartScreen() {
        //set welcome panel up
        welcomePanel = new JPanel();
        welcomePanel.setBounds(150, 15, 600, 100);
        welcomePanel.setBackground(Color.BLACK);

        //set and add welcome text to welcome panel
        welcomeText = new JTextArea();
        welcomeText.setBounds(20, 15, 600, 100);
        welcomeText.setBackground(Color.BLACK);
        welcomeText.setForeground(Color.RED);
        welcomeText.setFont(new Font(GAME_FONT, Font.PLAIN, 20));
        welcomeText.setLineWrap(true);
        welcomeText.setEditable(false);
        welcomeText.addKeyListener(this);
        welcomePanel.add(welcomeText);

        //set hint panel up
        hintPanel = new JPanel();
        hintPanel.setBounds(50, 150, 650, 300);
        hintPanel.setBackground(Color.BLACK);
        hintPanel.addKeyListener(this);

        //set and add hint text to hint panel
        hintText = new JTextArea();
        hintText.setBounds(50, 150, 650, 300);
        hintText.setBackground(Color.BLACK);
        hintText.setForeground(Color.CYAN);
        hintText.setFont(new Font(GAME_FONT, Font.PLAIN, 20));
        hintText.setLineWrap(true);
        hintText.setEditable(false);
        hintText.addKeyListener(this);
        hintPanel.add(hintText);

        //set up playPanel
        playPanel = new JPanel();
        playPanel.setBounds(90,500,600,100);
        playPanel.setBackground(Color.BLACK);
        playPanel.addKeyListener(this);

        //set up play text and add to playpanel
        playText = new JTextArea();
        playText.setFont(new Font(GAME_FONT, Font.BOLD, 20));
        playText.setBackground(Color.BLACK);
        playText.setForeground(Color.GREEN);
        playText.setEditable(false);
        playText.addKeyListener(this);
        playPanel.add(playText);
    }

    /*
     * hard coding start screen dialogues
     * TODO: generate hint text from XML?
     */
    public void setStartDialogue() {
        welcomeText.setText("Welcome to MONSTER BATTLES: DUNGEON EDITION");
        hintText.setText("In order to traverse the dungeon, you will be provided with options on what to do." +
                " You must type a recognized action, followed by a noun, in order to move and interact.\n" +
                "Example: If you would like to move into an available room, you would type GO ROOMNAME.\n" +
                "If you would like to inspect your surroundings, you would type LOOK AROUND\n" + "If you find a friendly monster you can recruit them to fight for you" +
                " by typing TAKE MONSTER\n" +
                "List of recognized actions - " + gameVerbs);
        playText.setText("-- press [enter] to start your journey --");
    }

    /*
     * getters for start screen panels
     */
    public JPanel getWelcomePanel() {
        return welcomePanel;
    }

    public JPanel getHintPanel() {
        return hintPanel;
    }

    public JPanel getPlayPanel() {
        return playPanel;
    }


    /*
     * Getters and Setters for main game panels and components
     */

    //returns player inventory panel
    public JPanel getInventoryPanel() {
        return inventoryPanel;
    }

    //creates inventory panel
    private void setInventoryPanel() {
        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(20, 15, 600, 80);
        inventoryPanel.setBackground(Color.BLACK);
        inventoryPanel.setLayout(new GridLayout(4, 1));

        setInventoryLabels();
    }

    //sets inventory panel labels and adds them to the inventory panel
    private void setInventoryLabels() {
        JPanel inventoryPan = getInventoryPanel();
        //setting monster label
        userMonsterLabel = new JLabel("MONSTERS:");
        userMonsterLabel.setFont(new Font(GAME_FONT, Font.PLAIN, 20));
        userMonsterLabel.setForeground(Color.CYAN);
        inventoryPan.add(userMonsterLabel);

        //setting user inventory label
        userInventoryLabel = new JLabel("Inventory:");
        userInventoryLabel.setFont(new Font(GAME_FONT, Font.PLAIN, 20));
        userInventoryLabel.setForeground(Color.CYAN);
        inventoryPan.add(userInventoryLabel);

        //setting user shard label
        userShardLabel = new JLabel("Shards:");
        userShardLabel.setFont(new Font(GAME_FONT, Font.PLAIN, 20));
        userShardLabel.setForeground(Color.CYAN);
        inventoryPan.add(userShardLabel);

        //setting user key label
        userKeyLabel = new JLabel("Keys:");
        userKeyLabel.setFont(new Font(GAME_FONT, Font.PLAIN, 20));
        userKeyLabel.setForeground(Color.CYAN);
        inventoryPan.add(userKeyLabel);
    }

    //returns main game text panel
    public JPanel getMainTextPanel() {
        return mainTextPanel;
    }

    //sets the main game text panel
    private void setMainTextPanel() {
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 150, 600, 250);
        mainTextPanel.setBackground(Color.BLACK);

        setMainTextArea();
    }

    //sets the main game text area and adds it to the main game panel
    private void setMainTextArea() {
        JPanel mainTextPan = getMainTextPanel();
        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100, 150, 600, 250);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(new Font(GAME_FONT, Font.ITALIC, 25));
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);

        mainTextPan.add(mainTextArea);
    }

    //returns input panel
    public JPanel getInputPanel() {
        return inputPanel;
    }

    //sets input panel
    private void setInputPanel() {
        inputPanel = new JPanel();
        inputPanel.setBounds(20, 450, 300, 50);
        inputPanel.setBackground(Color.BLACK);

        setInputLabelAndText();
    }

    //returns the input panels text field, this is where user inputs commands and the game can access user input
    public JTextField getInputText() {
        return inputText;
    }

    //sets the input text label and text field, then adds to the input panel
    private void setInputLabelAndText() {
        JPanel inputPan = getInputPanel();
        JLabel inputTextLabel = new JLabel(">");
        inputTextLabel.setFont(new Font(GAME_FONT, Font.ITALIC, 22));
        inputTextLabel.setForeground(Color.WHITE);
        inputPan.add(inputTextLabel);

        inputText = new JTextField(10);
        inputText.setFont(new Font(GAME_FONT, Font.BOLD, 22));
        inputText.setBackground(Color.BLACK);
        inputText.setForeground(Color.WHITE);
        inputText.setBorder(null);
        inputText.addKeyListener(this);
        inputPan.add(inputText);
    }

    /*
     * Getters for user inventory labels
     */
    public JLabel getUserMonsterLabel() {
        return userMonsterLabel;
    }

    public JLabel getUserInventoryLabel() {
        return userInventoryLabel;
    }

    public JLabel getUserShardLabel() {
        return userShardLabel;
    }

    public JLabel getUserKeyLabel() {
        return userKeyLabel;
    }

    //getter for main text area
    public JTextArea getMainTextArea() {
        return mainTextArea;
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
            hideStartScreen();
        }
        else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String userInput = getInputText().getText();
            String description = controller.playerAction(userInput);
           if (description.length() != 0) {
               getMainTextArea().setText(description);
           }
           getInputText().setText("");
           updateInventory();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /*
     * MAIN METHOD ONLY FOR TESTING PURPOSES, WILL BE REMOVED IN FINAL VERSION
     */
    public static void main(String[] args) {
        new GameGUI();
    }
}