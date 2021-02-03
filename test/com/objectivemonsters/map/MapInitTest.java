package com.objectivemonsters.map;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class MapInitTest {
    MapInit dungeonMap = new MapInit();
    List<Room> allTheRooms = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testToReturnAllTheRooms() {
        allTheRooms = dungeonMap.roomsInit();
        for (Room room : allTheRooms) {
            System.out.println(room + "\n");
        }
        assertEquals(allTheRooms.size(),11);
    }
}
