package com.objectivemonsters.scenes;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import java.awt.*;

public class BattleScene extends JPanel {
    private JLabel userMonsterHP, evilMonsterHP;
    private JTextPane battleTextArea;
    private JTextArea stayOrFlee;
    private HTMLEditorKit htmlEditorKit;

    public BattleScene(int width, int height, String fontName) {
        setSize(width, height);
        setBackground(Color.BLACK);
        setLayout(null);
        setFocusable(true);

        //set labels up
        userMonsterHP = new JLabel("User Monster: 100 HP");
        userMonsterHP.setBounds(20, 15, 300, 80);
        userMonsterHP.setFont(new Font(fontName, Font.PLAIN, 20));
        userMonsterHP.setForeground(Color.GREEN);
        add(userMonsterHP);

        evilMonsterHP = new JLabel("Bad Monster: 100 HP");
        evilMonsterHP.setBounds(580, 15, 300, 80);
        evilMonsterHP.setFont(new Font(fontName, Font.PLAIN, 20));
        evilMonsterHP.setForeground(Color.RED);
        add(evilMonsterHP);

        battleTextArea = new JTextPane();
        battleTextArea.setBounds(50, 150, 700, 250);
        battleTextArea.setBackground(Color.BLACK);
        battleTextArea.setForeground(Color.WHITE);
        battleTextArea.setFont(new Font(fontName, Font.BOLD, 22));
        battleTextArea.setEditable(false);
        setUpToReadHTMLAndSetCSSRules();
        add(battleTextArea);

        stayOrFlee = new JTextArea();
        stayOrFlee.setBounds(125,500,600,100);
        stayOrFlee.setFont(new Font(fontName, Font.BOLD, 20));
        stayOrFlee.setBackground(Color.BLACK);
        stayOrFlee.setForeground(Color.CYAN);
        stayOrFlee.setEditable(false);
        stayOrFlee.setText("-- press [space-bar] to continue fighting or [escape] to flee --");
        add(stayOrFlee);

        setVisible(true);
    }

    /*
     * Sets up the JTextPane to be able to read in html
     */
    private void setUpToReadHTMLAndSetCSSRules() {
        //setup battle text to take in html string
        battleTextArea.setContentType("text/html");
        htmlEditorKit = new HTMLEditorKit();
        battleTextArea.setEditorKit(htmlEditorKit);

        //create css rules that can be applied inline
        StyleSheet css = htmlEditorKit.getStyleSheet();
        css.addRule(".user {color: green;}");
        css.addRule(".enemy {color: red;}");
        css.addRule(".attack {color: orange;}");
        css.addRule(".damage {color: yellow;}");
        css.addRule(".text {color: white;}");

        Document doc = htmlEditorKit.createDefaultDocument();
        battleTextArea.setDocument(doc);
    }

    public JLabel getUserMonsterHP() {
        return userMonsterHP;
    }

    public JLabel getEvilMonsterHP() {
        return evilMonsterHP;
    }

    public JTextPane getBattleTextArea() {
        return battleTextArea;
    }

    /*
     * Method to take in an html formatted string and set the contents of battle text area
     * to its html format
     */
    public void setHTMLString(String html) {
        battleTextArea.setText(html);
    }
}