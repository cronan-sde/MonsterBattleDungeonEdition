package com.objectivemonsters.game;

import com.objectivemonsters.dungeon.Room;
import org.junit.Test;
import org.w3c.dom.NodeList;

import java.util.List;

import static org.junit.Assert.*;

public class GameControllerTest {
    GameController controller = new GameController();
    @Test
    public void initialize() {
        List<Room> allRooms = controller.roomsInit();
        for (int i = 0; i < allRooms.size(); i ++ ) {
            System.out.println(allRooms.get(i));
        }
    }

    @Test
    public void monsterAssignment() {
    }

    @Test
    public void itemAssignment() {
    }

    @Test
    public void roomsInit() {

    }

    @Test
    public void dungeonInit() {
    }

    @Test
    public void getRandomNum() {
    }
}