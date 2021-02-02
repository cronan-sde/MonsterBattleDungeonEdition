package com.objectivemonsters.game;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameGUI extends JFrame {
    //width and height for frame
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;

    //game fonts
    private static final String GAME_FONT = "Times New Roman";

    //list of acceptable verbs
    java.util.List<String> gameVerbs = List.of("GO", "LOOK", "TAKE", "FIGHT");

    //JPanels needed for Frame for the start game screen
    private JPanel welcomePanel, hintPanel, playPanel;
    private JTextArea welcomeText, hintText, playText;

    //JPanels needed for Frame for the main game screen
    private JPanel inventoryPanel, mainTextPanel, inputPanel;
    //labels for inventoryPanel
    private JLabel userMonsterLabel, userInventoryLabel, userShardLabel, userKeyLabel, inputTextLabel;
    //text area for mainTextPanel
    private JTextArea mainTextArea;
    //text field for user input
    private JTextField inputText;


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
        //Once enter is pressed display main game screen

        //set then add inventory panel to frame
//        setInventoryPanel();
//        add(getInventoryPanel());
//
//        //set then add main text panel to frame
//        setMainTextPanel();
//        add(getMainTextPanel());
//
//        //set then add input panel to frame
//        setInputPanel();
//        add(getInputPanel());
//
//        //update inventory panel
//        updateInventory();
//
//        //start location
//        dungeonStart();
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
        welcomePanel.add(welcomeText);

        //set hint panel up
        hintPanel = new JPanel();
        hintPanel.setBounds(50, 150, 650, 300);
        hintPanel.setBackground(Color.BLACK);

        //set and add hint text to hint panel
        hintText = new JTextArea();
        hintText.setBounds(50, 150, 650, 300);
        hintText.setBackground(Color.BLACK);
        hintText.setForeground(Color.CYAN);
        hintText.setFont(new Font(GAME_FONT, Font.PLAIN, 22));
        hintText.setLineWrap(true);
        hintText.setEditable(false);
        hintPanel.add(hintText);

        //set up playPanel
        playPanel = new JPanel();
        playPanel.setBounds(90,500,600,100);
        playPanel.setBackground(Color.BLACK);

        //set up play text and add to playpanel
        playText = new JTextArea();
        playText.setFont(new Font(GAME_FONT, Font.BOLD, 20));
        playText.setBackground(Color.BLACK);
        playText.setForeground(Color.GREEN);
        playText.setEditable(false);
        playPanel.add(playText);
    }

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

    public JPanel getWelcomePanel() {
        return welcomePanel;
    }

    public JPanel getHintPanel() {
        return hintPanel;
    }

    public JPanel getPlayPanel() {
        return playPanel;
    }

    public void updateInventory() {
        JLabel userMonsters = getUserMonsterLabel();
        JLabel userInventory = getUserInventoryLabel();
        JLabel userShards = getUserShardLabel();
        JLabel userKeys = getUserKeyLabel();

        userMonsters.setText("MONSTERS: Drowsy Dragon");
        userInventory.setText("Inventory: HP Potion");
        userShards.setText("Shards: 0/10");
        userKeys.setText("Keys: 0/1");
    }

    public void dungeonStart() {
        String roomDesc = "You are currently in the humanoid bones room. It is dark and damp, and filled with creepy crawlers." +
                " Lots of other creepy scary stuff going on and look a monster";

        JTextArea mainText = getMainTextArea();
        mainText.setText(roomDesc);
    }


    /*
     * Getters and Setters for panels and components
     */
    public JPanel getInventoryPanel() {
        return inventoryPanel;
    }

    public void setInventoryPanel() {
        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(20, 15, 600, 80);
        inventoryPanel.setBackground(Color.BLACK);
        inventoryPanel.setLayout(new GridLayout(4, 1));

        setInventoryLabels();
    }

    public void setInventoryLabels() {
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

    public JPanel getMainTextPanel() {
        return mainTextPanel;
    }

    public void setMainTextPanel() {
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 150, 600, 250);
        mainTextPanel.setBackground(Color.BLACK);

        setMainTextArea();
    }

    public void setMainTextArea() {
        JPanel mainTextPan = getMainTextPanel();
        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100, 150, 600, 250);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(new Font(GAME_FONT, Font.PLAIN, 28));
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);

        mainTextPan.add(mainTextArea);
    }

    public JPanel getInputPanel() {
        return inputPanel;
    }

    public void setInputPanel() {
        inputPanel = new JPanel();
        inputPanel.setBounds(20, 450, 300, 50);
        inputPanel.setBackground(Color.BLACK);

        setInputLabelAndText();
    }

    public void setInputLabelAndText() {
        JPanel inputPan = getInputPanel();
        inputTextLabel = new JLabel(">");
        inputTextLabel.setFont(new Font(GAME_FONT, Font.ITALIC, 22));
        inputTextLabel.setForeground(Color.WHITE);
        inputPan.add(inputTextLabel);

        inputText = new JTextField(10);
        inputText.setFont(new Font(GAME_FONT, Font.BOLD, 22));
        inputText.setBackground(Color.BLACK);
        inputText.setForeground(Color.WHITE);
        inputText.setBorder(null);
        inputPan.add(inputText);
    }

    // getters for user inventory labels
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
     * MAIN METHOD ONLY FOR TESTING PURPOSES, WILL BE REMOVED IN FINAL VERSION
     */
    public static void main(String[] args) {
        new GameGUI();
    }
}