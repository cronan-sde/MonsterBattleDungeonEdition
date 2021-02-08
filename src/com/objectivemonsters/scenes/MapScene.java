package com.objectivemonsters.scenes;

import javax.swing.*;
import java.awt.*;

public class MapScene extends JPanel {
    private JLabel imageLabel = new JLabel(new ImageIcon("resources/map.png"));
    private JTextArea exitSceneText;
    private final String fontName;

    public MapScene(int width, int height, String fontName) {
        this.fontName = fontName;
        setSize(width, height);
        setBackground(Color.BLACK);
        setLayout(null);
        setFocusable(true);


        imageLabel.setBounds(50, 50, 700, 400);
        add(imageLabel);

        //set exit text
        exitSceneText = new JTextArea();
        exitSceneText.setFont(new Font(fontName, Font.BOLD, 20));
        exitSceneText.setBounds(210,500,600,100);
        exitSceneText.setBackground(Color.BLACK);
        exitSceneText.setForeground(Color.GREEN);
        exitSceneText.setEditable(false);
        exitSceneText.setText("-- press [escape] to exit map view --");
        exitSceneText.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        exitSceneText.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
        add(exitSceneText);
    }

    public JLabel getImageLabel() {
        return imageLabel;
    }

    public JTextArea getExitSceneText() {
        return exitSceneText;
    }
}