package com.objectivemonsters.dungeon;

import com.objectivemonsters.consumables.Item;
import com.objectivemonsters.monsters.Elemental;
import com.objectivemonsters.monsters.Monster;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoomTest extends TestCase {

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testTestToString() {

        String name = "dungeon playground";
        String description = "a lovely playground for people who lost their way, many monsters are waiting to be friends with you.";
        // exits from rooms are called archways
        List<String> archways = new ArrayList<>();
        // monster in room, one per room, could expand and change to array list later
        Monster roomMonster;
        // items in room
        List<Item> item = new ArrayList<>();
        Item recoverPotion;

        archways = Arrays.asList("humanoid bones","torn chamber");
        roomMonster = new Monster("zoyja", 100, Elemental.AIR, 50,22,15,"paranoid",false);
        recoverPotion = new Item("recover potion", "drink",10);
        item = Arrays.asList(recoverPotion);
        Room testRoom = new Room(1,"dungeon playground"
                ,"a lovely playground for people who lost their way, many monsters are waiting to be friends with you."
                ,archways,roomMonster,item);
        System.out.println(testRoom);
    }
}