package com.objectivemonsters.client;
import asciiPanel.AsciiPanel;

import com.objectivemonsters.dungeon.Dungeon;
import com.objectivemonsters.game.GameController;
import com.objectivemonsters.game.GameInitializer;
import com.objectivemonsters.monsters.Monster;
import com.objectivemonsters.monsters.MonsterGenerator;
import com.objectivemonsters.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GameInitializer initializer = new GameInitializer();
        Dungeon dungeon = initializer.dungeonInit();
        MonsterGenerator mongen = new MonsterGenerator();
        List<Monster> monster = mongen.allMonsters();
        Player player = new Player("player1", new ArrayList<>(), new ArrayList<>());
        GameController controller = new GameController(dungeon, monster, player);
        controller.startGame();
    }
}
