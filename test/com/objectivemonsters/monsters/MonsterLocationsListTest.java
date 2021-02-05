package com.objectivemonsters.monsters;

import org.junit.Test;

import static org.junit.Assert.*;

public class MonsterLocationsListTest {

    MonsterLocationsList mll = new MonsterLocationsList();

    @Test
    public void setFriendlyMonsterLocations() {
        mll.friendlyLocations();
        assertNotNull(mll.friendlyMonsterLocations);

    }

    @Test
    public void setAngryMonsterLocations() {
        mll.angryLocations();
        assertNotNull(mll.angryMonsterLocations);
    }
}