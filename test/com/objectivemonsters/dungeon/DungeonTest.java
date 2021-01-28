package com.objectivemonsters.dungeon;

import com.objectivemonsters.consumables.Item;
import com.objectivemonsters.monsters.Monster;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DungeonTest extends TestCase {
    @Before
    public void setUp() throws Exception {
        super.setUp();
        List<Room> dungeonRooms ;
        // collection of monsters in this level of dungeon
        List<Monster> dungeonMonsters;
        // items available in this level of dungeon
        List<Item> dungeonItems;
        // when escape is true, generate new dungeon level, this is true when player uses shard created key to open door
        Boolean escape;
        // Dungeon level for advanced dungeons
        int level;

    }
    @Test
    public void testTestToString() {
    }
}