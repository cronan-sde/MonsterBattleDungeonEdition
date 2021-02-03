package com.objectivemonsters.map;

import com.objectivemonsters.consumables.Item;
import com.objectivemonsters.monsters.Monster;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoomTest extends TestCase {

    // a single room initialization
    //a List of route(s) the room lead to.
    List<String> roomLeadTo = new ArrayList<>();
    String roomName;
    String roomDescription;
    int roomId;
    // an instance of Room.
    Room room1;
    MapInit map = new MapInit();
    @Before
    public void setUp() throws Exception {
        super.setUp();
        // initialize a single room
        roomId = 1;
        roomName = "dungeon playground";
        roomDescription = "a lovely playground for people who lost their way, many monsters are waiting to be friends with you.";
        roomLeadTo = Arrays.asList("humanoid bones","torn chamber");
    }

    @Test
    public void testToString() {
        // initialize a Room instance 'testRoom'
        room1 = new Room(roomId, roomName, roomDescription, roomLeadTo);
        System.out.println(room1);
    }
}