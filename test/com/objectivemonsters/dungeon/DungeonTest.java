//package com.objectivemonsters.dungeon;
//
//import com.objectivemonsters.consumables.Item;
//import com.objectivemonsters.monsters.Elemental;
//import com.objectivemonsters.monsters.Monster;
//import junit.framework.TestCase;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class DungeonTest extends TestCase {
//
//    List<Room> dungeonRooms = new ArrayList<>();
//    // collection of monsters in this level of dungeon
//    List<Monster> dungeonMonsters = new ArrayList<>();
//    // Item available in this level of dungeon
//    List<Item> dungeonItem = new ArrayList<>();
//
//    // when escape is true, generate new dungeon level, this is true when player uses shard created key to open door
//    Boolean escape;
//    // Dungeon level for advanced dungeons
//    int level;
//
//    // a single room initialization
//    //a List of route(s) the room lead to.
//    List<String> roomLeadTo = new ArrayList<>();
//    // a List contains item(s) in the room
//    List<Item> roomItem = new ArrayList<>();
//    String roomName;
//    String roomDescription;
//    int roomId;
//    // monster in room, one per room.
//    Monster monsterZoya;
//    // an instance of Item class, a item in the room.
//    Item recoverPotion;
//    // an instance of Room.
//    Room room1;
//
//    @Before
//    public void setUp() throws Exception {
//        super.setUp();
//
//        // initialize a single room
//        roomId = 1;
//        roomName = "dungeon playground";
//        roomDescription = "a lovely playground for people who lost their way, many monsters are waiting to be friends with you.";
//        roomLeadTo = Arrays.asList("humanoid bones","torn chamber");
//        monsterZoya = new Monster("zoya", 100, Elemental.AIR, 50,22,15,"paranoid",false);
//        recoverPotion = new Item("recover potion", "drink",10);
//        roomItem = Arrays.asList(recoverPotion);
//        room1 = new Room(roomId, roomName, roomDescription, roomLeadTo, monsterZoya, roomItem);
//
//        // all the Item, rooms and monsters within this dungeon.
//        dungeonItem.addAll(roomItem);
//        dungeonRooms = Arrays.asList(room1);
//        dungeonMonsters = Arrays.asList(monsterZoya);
//
//    }
//
//    @Test
//    public void testToString() {
//        Dungeon tunnelOfLost = new Dungeon(dungeonRooms,dungeonMonsters,dungeonItem,escape,0);
//        System.out.println(tunnelOfLost);
//    }
//}