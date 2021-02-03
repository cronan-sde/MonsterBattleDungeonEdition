package com.objectivemonsters.client;
import com.objectivemonsters.map.Dungeon;
import com.objectivemonsters.game.GameController;
import com.objectivemonsters.map.MapInit;
import com.objectivemonsters.monsters.Monster;
import com.objectivemonsters.monsters.MonsterGenerator;
import com.objectivemonsters.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MapInit initializer = new MapInit();
        MonsterGenerator mongen = new MonsterGenerator();
        List<Monster> monster = mongen.allMonsters();
        Dungeon dungeon = initializer.dungeonInit(monster);
        Player player = new Player("player1", new ArrayList<>(), new ArrayList<>());
        GameController controller = new GameController(dungeon, monster, player);
        controller.startGame();
    }
}
