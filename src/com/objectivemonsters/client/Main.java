package com.objectivemonsters.client;

import com.objectivemonsters.game.GameController;
import com.objectivemonsters.util.Prompter;
import com.objectivemonsters.util.TextParser;

public class Main {

    public static void main(String[] args) {
        //TextParser tp = new TextParser();
        //tp.createMons();
        GameController controller = new GameController();
        controller.initialize();
    }
}
