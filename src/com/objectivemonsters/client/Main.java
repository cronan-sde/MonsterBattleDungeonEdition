package com.objectivemonsters.client;

import com.objectivemonsters.dungeon.Dungeon;
import com.objectivemonsters.game.GameController;
import com.objectivemonsters.game.GameInitializer;
import com.objectivemonsters.player.Player;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        GameInitializer initializer = new GameInitializer();
        Dungeon dungeon = initializer.dungeonInit();
        Player player = new Player("player1", new ArrayList<>(), new ArrayList<>());
        GameController controller = new GameController(dungeon, player);
        controller.startGame();
    }
}
