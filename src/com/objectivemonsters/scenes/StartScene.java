package com.objectivemonsters.scenes;

import com.objectivemonsters.storylines.StoryLineGenerator;

import javax.swing.*;
import java.awt.*;

public class StartScene extends JPanel {
    private JTextArea welcomeText;
    private JTextArea hintText;
    private JTextArea playGameText;

    // bring in text
    StoryLineGenerator slg = new StoryLineGenerator();

    public StartScene(int width, int height, String fontName) {
        setSize(width, height);
        setBackground(Color.BLACK);
        setLayout(null);
        setFocusable(true);

        //create text areas
        welcomeText = new JTextArea();
        welcomeText.setBounds(100, 15, 600, 100);
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
     * hard coding start screen dialogues
     * TODO: generate hint text from XML?
     */
    public void setStartDialogue() {
        welcomeText.setText("Welcome to MONSTER BATTLES: DUNGEON EDITION");
//        welcomeText.setText((String) slg.getStoryTxt().get("welcome") + "\n" + "\n" + slg.getStoryTxt().get("opening") + "\n" + slg.getStoryTxt().get("moreInfo") + "\n" +
//                slg.getStoryTxt().get("friendlyGesture") + "\n" + "\n" + slg.getStoryTxt().get("hint"));
//        welcomeText.setText((String) slg.getStoryTxt().get("opening"));
//        welcomeText.setText((String) slg.getStoryTxt().get("moreInfo"));
//        welcomeText.setText((String) slg.getStoryTxt().get("friendlyGesture"));
//        welcomeText.setText((String) slg.getStoryTxt().get("hint"));

        // also availalbe in the StoryTxt xml - directions, directionsMore, wordList

        hintText.setText("In order to traverse the dungeon, you will be provided with options on what to do." +
                " You must type a recognized action, followed by a noun, in order to move and interact.\n" +
                "Example: If you would like to move into an available room, you would type GO ROOMNAME.\n" +
                "If you would like to inspect your surroundings, you would type LOOK AROUND\n" + "If you find a friendly monster you can recruit them to fight for you" +
                " by typing TAKE MONSTER\n" +
                "List of recognized actions - [GO, LOOK, TAKE, FIGHT]");
        playGameText.setText("-- press [enter] to start your journey --");
    }

    public JTextArea getHintText() {
        return hintText;
    }
}