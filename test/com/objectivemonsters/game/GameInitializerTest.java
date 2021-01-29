package com.objectivemonsters.game;

import com.objectivemonsters.dungeon.Room;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GameInitializerTest {
    GameInitializer initializer = new GameInitializer();
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void roomsInit() {
        List<Room> allRooms = initializer.roomsInit();
        for (int i = 0; i < allRooms.size(); i ++ ) {
            System.out.println(allRooms.get(i));
        }
    }
}