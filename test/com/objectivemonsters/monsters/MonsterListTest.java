package com.objectivemonsters.monsters;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MonsterListTest {
    MonsterList ml = new MonsterList();
    List<Monster> monList = ml.allMonsters();

    // check field of monster List
    @Test
    public void allMonstersCheckName() {
        ml.allMonsters();
        String name = "Wacky Rabbit";
        assertEquals(name, ml.allMonsters().get(0).getName());
        assertEquals(13, ml.allMonsters().size());
    }

    // testing method call in class
    @Test
    public void allMonstersCheckSize() {
//        assertEquals(13, monList.size());
        String name = "Sam Salmon";
        assertEquals(name, monList.get(1).getName() );
    }


}