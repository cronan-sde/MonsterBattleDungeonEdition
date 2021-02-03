package com.objectivemonsters.scenes;

import javax.swing.*;
import java.awt.*;

public class StartScene extends JPanel {
    private JTextArea welcomeText;
    private JTextArea hintText;
    private JTextArea playGameText;

    public StartScene(int width, int height, String fontName) {
        setSize(width, height);
        setBackground(Color.BLACK);
        setLayout(null);
        setFocusable(true);

        //create text areas
        welcomeText = new JTextArea();
        welcomeText.setBounds(150, 15, 600, 100);
        welcomeText.setBackground(Color.BLACK);
        welcomeText.setForeground(Color.RED);
        welcomeText.setFont(new Font(fontName, Font.PLAIN, 20));
        welcomeText.setLineWrap(true);
        welcomeText.setEditable(false);
        add(welcomeText);

        //set hint text area
        hintText = new JTextArea();
        hintText.setBounds(50, 150, 650, 300);
        hintText.setBackground(Color.BLACK);
        hintText.setForeground(Color.CYAN);
        hintText.setFont(new Font(fontName, Font.PLAIN, 20));
        hintText.setLineWrap(true);
        hintText.setEditable(false);
        add(hintText);

        //set play game text area
        playGameText = new JTextArea();
        playGameText.setBounds(210,500,600,100);
        playGameText.setFont(new Font(fontName, Font.BOLD, 20));
        playGameText.setBackground(Color.BLACK);
        playGameText.setForeground(Color.GREEN);
        playGameText.setEditable(false);
        add(playGameText);

        setStartDialogue();
        setVisible(true);
    }
    /*
     * Sets up the starting scene with a welcome message, hints on how to play the game, and a prompt on starting the game on a keypress
     */
//    public void setStartScreen() {
//        //set welcome panel up
//        welcomePanel = new JPanel();
//        welcomePanel.setBounds(150, 15, 600, 100);
//        welcomePanel.setBackground(Color.BLACK);
//
//        //set and add welcome text to welcome panel
//        welcomeText = new JTextArea();
//        welcomeText.setBounds(20, 15, 600, 100);
//        welcomeText.setBackground(Color.BLACK);
//        welcomeText.setForeground(Color.RED);
//        welcomeText.setFont(new Font(GAME_FONT, Font.PLAIN, 20));
//        welcomeText.setLineWrap(true);
//        welcomeText.setEditable(false);
//        welcomeText.addKeyListener(this);
//        welcomePanel.add(welcomeText);
//
//        //set hint panel up
//        hintPanel = new JPanel();
//        hintPanel.setBounds(50, 150, 650, 300);
//        hintPanel.setBackground(Color.BLACK);
//        hintPanel.addKeyListener(this);
//
//        //set and add hint text to hint panel
//        hintText = new JTextArea();
//        hintText.setBounds(50, 150, 650, 300);
//        hintText.setBackground(Color.BLACK);
//        hintText.setForeground(Color.CYAN);
//        hintText.setFont(new Font(GAME_FONT, Font.PLAIN, 20));
//        hintText.setLineWrap(true);
//        hintText.setEditable(false);
//        hintText.addKeyListener(this);
//        hintPanel.add(hintText);
//
//        //set up playPanel
//        playPanel = new JPanel();
//        playPanel.setBounds(90,500,600,100);
//        playPanel.setBackground(Color.BLACK);
//        playPanel.addKeyListener(this);
//
//        //set up play text and add to playpanel
//        playText = new JTextArea();
//        playText.setFont(new Font(GAME_FONT, Font.BOLD, 20));
//        playText.setBackground(Color.BLACK);
//        playText.setForeground(Color.GREEN);
//        playText.setEditable(false);
//        playText.addKeyListener(this);
//        playPanel.add(playText);
//    }
//
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
                "List of recognized actions - [GO, LOOK, TAKE, FIGHT]");
        playGameText.setText("-- press [enter] to start your journey --");
    }
}