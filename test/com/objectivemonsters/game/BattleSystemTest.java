package com.objectivemonsters.game;

import com.objectivemonsters.monsters.Elemental;
import com.objectivemonsters.monsters.Monster;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BattleSystemTest {
    private BattleSystem battle;

    @Before
    public void setUp() {
        battle = new BattleSystem();
    }

    @Test
    public void testAttackDamage_shouldReturnRandomValueWithinMinAndMaxDmgRange() {
        int lowestStrength = 1;
        int min = 1;
        int max = 10;

        for (int i = 0; i < 50; i++) {
            int damage = battle.attackDamage(lowestStrength);
            assertTrue(damage >= min && damage <= max);
        }
    }

    @Test
    public void testGenerateMinAndMaxDmg_ShouldReturnDefaultMinAndMaxDamageRangeValues_whenPassedStrengthValue20OrLess() {
        int lowestStrength = 1;
        int expectedMin = 1;
        int expectedMax = 10;

        int[] minAndMax = battle.generateMinAndMaxDmg(lowestStrength);
        assertEquals(expectedMin, minAndMax[0]);
        assertEquals(expectedMax, minAndMax[1]);

        int defaultEdgeStrength = 20;
        minAndMax = battle.generateMinAndMaxDmg(defaultEdgeStrength);
        assertEquals(expectedMin, minAndMax[0]);
        assertEquals(expectedMax, minAndMax[1]);
    }

    @Test
    public void testGenerateMinAndMaxDmg_shouldReturnCorrectMinAndMaxRangeValues_whenPassedUpperBoundsStrengthLevels() {
        int lowerBoundsUpperStrength = 191;
        int expectedMin = 11;
        int expectedMax = 50;

        int[] minAndMax = battle.generateMinAndMaxDmg(lowerBoundsUpperStrength);
        assertEquals(expectedMin, minAndMax[0]);
        assertEquals(expectedMax, minAndMax[1]);

        int strengthCap = 200;
        minAndMax = battle.generateMinAndMaxDmg(strengthCap);
        assertEquals(expectedMin, minAndMax[0]);
        assertEquals(expectedMax, minAndMax[1]);
    }

    @Test
    public void testGenerateMinAndMaxDmg_shouldReturnCorrectMinAndMaxRangeValues_whenPassedLowerUpperBoundStrength() {
        int lowerUpperBoundStrength = 100;
        int expectedMin = 1;
        int expectedMax = 50;

        int[] minAndMax = battle.generateMinAndMaxDmg(lowerUpperBoundStrength);
        assertEquals(expectedMin, minAndMax[0]);
        assertEquals(expectedMax, minAndMax[1]);

        int upperLowerBoundStrength = 101;
        int expectedUpperLowerMin = 2;
        minAndMax = battle.generateMinAndMaxDmg(upperLowerBoundStrength);
        assertEquals(expectedUpperLowerMin, minAndMax[0]);
        assertEquals(expectedMax, minAndMax[1]);
    }

    @Test
    public void testBattle_shouldReturnTheMonsterThatWinsTheBattle_whenPassedTwoMonsters() {
//        Monster m1 = new Monster("Charmander", 100, Elemental.AIR, 120, 3,3,"cool guy", true);
//        Monster m2 = new Monster("Mewto", 100, Elemental.FIRE, 99, 5, 5, "bad man", false);
//
//        Monster winner = battle.battle(m1,m2);
//        assertTrue(winner.getHP() > 0);
    }
}