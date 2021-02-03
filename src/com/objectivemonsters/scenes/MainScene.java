package com.objectivemonsters.scenes;

import javax.swing.*;
import java.awt.*;

public class MainScene extends JPanel {
    private JPanel inventoryPanel, mainTextPanel, inputPanel;
    private JLabel userMonsterLabel, userInventoryLabel, userShardLabel, userKeyLabel;
    private JTextArea mainTextArea;
    private JLabel inputLabel;
    private JTextField inputText;

    private final String fontName;

    public MainScene(int width, int height, String fontName) {
        this.fontName = fontName;
        setSize(width, height);
        setBackground(Color.BLACK);
        setLayout(null);
        setFocusable(true);

        //set inventory panel
        setInventoryPanel();
        add(getInventoryPanel());

        //set main text panel
        setMainTextPanel();
        add(mainTextPanel);

        //set input text panel
        setInputPanel();
        add(inputPanel);

        setVisible(true);
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
        userMonsterLabel.setFont(new Font(fontName, Font.PLAIN, 20));
        userMonsterLabel.setForeground(Color.CYAN);
        inventoryPan.add(userMonsterLabel);

        //setting user inventory label
        userInventoryLabel = new JLabel("Inventory:");
        userInventoryLabel.setFont(new Font(fontName, Font.PLAIN, 20));
        userInventoryLabel.setForeground(Color.CYAN);
        inventoryPan.add(userInventoryLabel);

        //setting user shard label
        userShardLabel = new JLabel("Shards:");
        userShardLabel.setFont(new Font(fontName, Font.PLAIN, 20));
        userShardLabel.setForeground(Color.CYAN);
        inventoryPan.add(userShardLabel);

        //setting user key label
        userKeyLabel = new JLabel("Keys:");
        userKeyLabel.setFont(new Font(fontName, Font.PLAIN, 20));
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
        mainTextArea.setFont(new Font(fontName, Font.ITALIC, 22));
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
        inputTextLabel.setFont(new Font(fontName, Font.ITALIC, 22));
        inputTextLabel.setForeground(Color.WHITE);
        inputPan.add(inputTextLabel);

        inputText = new JTextField(10);
        inputText.setFont(new Font(fontName, Font.BOLD, 22));
        inputText.setBackground(Color.BLACK);
        inputText.setForeground(Color.WHITE);
        inputText.setBorder(null);
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
}