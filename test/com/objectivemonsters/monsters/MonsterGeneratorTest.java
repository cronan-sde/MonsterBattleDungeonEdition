package com.objectivemonsters.monsters;

import org.junit.Test;

import static org.junit.Assert.*;

public class MonsterGeneratorTest {
    MonsterGenerator mg = new MonsterGenerator();

    @Test
    public void angryMonstersAll() {
        assertNotNull(mg.angryMonstersAll());
    }

    @Test
    public void friendlyMonstersAll() {
        assertNotNull(mg.friendlyMonstersAll());
    }

    @Test
    public void randomTest() {
        assertNotNull(mg.randomMonster());
        assertNotNull(mg.randoFriendlyMon());
        assertNotNull(mg.randoAngryMon());
    }
}