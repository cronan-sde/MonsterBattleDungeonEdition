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
        allTheRooms = dungeonMap.roomsInit();
    }

    @Test
    public void testToReturnAllTheRooms() {

        for (Room room : allTheRooms) {
            System.out.println(room + "\n");
        }
        assertEquals(allTheRooms.size(),11);
    }

    @Test
    public void testShouldReturnOnlyOneRandomIntegerNumber(){
        System.out.println(dungeonMap.getRandomNumber(1,12));
    }

    @Test
    public void testExitDoorIsAssigned(){
        dungeonMap.assignExitDoor();

        int roomHasExit = 0;
        for (Room room : allTheRooms) {
            if (room.isHasExitDoor() == true ){
                System.out.println("Room " + room.getName() + " has the exit of dungeon.\n");
                roomHasExit = 1;
                System.out.println(room + "\n");
            }
        }
        System.out.println(roomHasExit);
        //assertEquals(1,roomHasExit);
    }
}
