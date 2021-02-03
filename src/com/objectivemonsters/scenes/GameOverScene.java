package com.objectivemonsters.scenes;

import javax.swing.*;
import java.awt.*;

public class GameOverScene extends JPanel {
    private JTextArea gameOverText;
    private JTextArea winLoseText;
    private JTextArea playAgainText;

    public GameOverScene(int width, int height, String fontName) {
        setSize(width, height);
        setBackground(Color.BLACK);
        setLayout(null);
        setFocusable(true);

        //create text areas
        gameOverText = new JTextArea();
        gameOverText.setBounds(150, 15, 600, 100);
        gameOverText.setBackground(Color.BLACK);
        gameOverText.setForeground(Color.RED);
        gameOverText.setFont(new Font(fontName, Font.PLAIN, 30));
        gameOverText.setLineWrap(true);
        gameOverText.setEditable(false);
        add(gameOverText);

        //set hint text area
        winLoseText = new JTextArea();
        winLoseText.setBounds(50, 150, 650, 300);
        winLoseText.setBackground(Color.BLACK);
        winLoseText.setForeground(Color.CYAN);
        winLoseText.setFont(new Font(fontName, Font.PLAIN, 20));
        winLoseText.setLineWrap(true);
        winLoseText.setEditable(false);
        add(winLoseText);

        //set play game text area
        playAgainText = new JTextArea();
        playAgainText.setBounds(210,500,600,100);
        playAgainText.setFont(new Font(fontName, Font.BOLD, 20));
        playAgainText.setBackground(Color.BLACK);
        playAgainText.setForeground(Color.GREEN);
        playAgainText.setEditable(false);
        add(playAgainText);

        setStartDialogue();
        setVisible(true);
    }

    /*
     * hard coding start screen dialogues
     * TODO: generate hint text from XML?
     */
    public void setStartDialogue() {
        gameOverText.setText("GAME OVER");
        winLoseText.setText("This will be the text that will congratulate the player if win\n" +
                "Or tell them they have lost the game");
        playAgainText.setText("-- press [enter] to play again --");
    }

    public JTextArea getWinLoseText() {
        return winLoseText;
    }
}