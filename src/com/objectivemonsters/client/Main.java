package com.objectivemonsters.client;

import com.objectivemonsters.game.GameController;
import com.objectivemonsters.game.GameInitializer;

public class Main {

    public static void main(String[] args) {
        GameInitializer initializer = new GameInitializer();
        GameController controller = new GameController();
        controller.startGame();
    }
}
