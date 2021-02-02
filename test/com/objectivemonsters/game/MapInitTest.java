package com.objectivemonsters.game;

import com.objectivemonsters.map.MapInit;
import com.objectivemonsters.map.Room;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MapInitTest {
    MapInit initializer = new MapInit();
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