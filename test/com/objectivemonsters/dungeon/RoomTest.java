package com.objectivemonsters.dungeon;

import com.objectivemonsters.consumables.Item;
import com.objectivemonsters.monsters.Monster;
import com.objectivemonsters.monsters.Elemental;
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
    // a List contains item(s) in the room
    List<Item> roomItem = new ArrayList<>();
    String roomName;
    String roomDescription;
    int roomId;
    // monster in room, one per room.
    Monster monsterZoya;
    // an instance of Item class, a item in the room.
    Item recoverPotion;
    // an instance of Room.
    Room room1;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        // initialize a single room
        roomId = 1;
        roomName = "dungeon playground";
        roomDescription = "a lovely playground for people who lost their way, many monsters are waiting to be friends with you.";
        roomLeadTo = Arrays.asList("humanoid bones","torn chamber");
        monsterZoya = new Monster("zoya", 100, Elemental.AIR, 50,22,15,"paranoid",false);
        recoverPotion = new Item("recover potion", "drink",10);
        roomItem = Arrays.asList(recoverPotion);

    }

    @Test
    public void testToString() {
        // initialize a Room instance 'testRoom'
        room1 = new Room(roomId, roomName, roomDescription, roomLeadTo, monsterZoya, roomItem);

        System.out.println(room1);
    }
}