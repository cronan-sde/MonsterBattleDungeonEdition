package com.objectivemonsters.map;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapInitTest {
    MapInit dungeonMap = new MapInit();
    List<Room> allTheRooms = new ArrayList<>();
    //Map<String, String> routesMap = new HashMap();
    //List<Map> routesMap;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void roomsInit() {

    }

    @Test
    public void dungeonInit() {

    }

    @Test
    public void testToReturnAllTheRooms() {
        allTheRooms = dungeonMap.roomsInit();
        for (Room room : allTheRooms) {
            System.out.println(room + "\n");
        }
//        assertEquals(allTheRooms.size(),11);
    }

    @Test
    public void testToReturnTheMapOfDirectionAndRoomName() {
        //routesMap = dungeonMap.mapRoutes();
        //System.out.println(routesMap);
        //routesMap.forEach(room -> System.out.println(room.entrySet()));
    }
}
