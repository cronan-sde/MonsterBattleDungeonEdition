package com.objectivemonsters.game;

import com.objectivemonsters.monsters.Monster;

import java.util.Random;

public class BattleSystem {
    private Random rand;
    //tracks minimum base damage increase when strength over 100
    private static final int MIN_DAMAGE_INCREMENTS = 1;
    //tracks maximum base damage increase when strength under 101
    private static final int MAX_DAMAGE_INCREMENTS = 5;
    //tracks the strength point jumps that lead to damage increases
    private static final int STRENGTH_RANGE_JUMPS = 10;


    public BattleSystem() {
        rand = new Random();
    }
/*
    Version 1:
    take only Strength attribute into play and monsters attack each other until only one is alive
 */

/*
    Combat engine rules:
    Strength cap 200?
    base dmg - <= 20 Strength = 1-10 dmg range: Damage increases +5 every 10 Strength points
    base dmg - 21-30 = 1-15 dmg
    base dmg - 31-40 = 1-20 dmg
    base dmg - 41-50 = 1-25 dmg
    base dmg - 51-60 = 1-30 dmg
    base dmg - 61-70 = 1-35 dmg
    base dmg - 71-80 = 1-40 dmg
    base dmg - 81-90 = 1-45 dmg
    base dmg - 91-100 = 1-50 dmg
    base dmg - > 100-110 = 2-50 dmg range: Minimum base dmg increases +1 every 10 Strength points for Strength > 100
    base dmg - 111-120 = 3-50 dmg
    base dmg - 121-130 = 4-50 dmg
    base dmg - 131-140 = 5-50 dmg
    base dmg - 141-150 = 6-50 dmg
    base dmg - 151-160 = 7-50 dmg
    base dmg - 161-170 = 8-50 dmg
    base dmg - 171-180 = 9-50 dmg
    base dmg - 181-190 = 10-50 dmg
    base dmg - 191-200 = 11-50 dmg

 */

/*
 * Currently very simplistic automated turn based system
 * Monster m1 attacks, damage removed from m2 hp, new hp set for m2
 * Monster m2 attacks, damage removed from m1 hp, new hp set for m1
 * Just getting all mechanics working before making more usable
 */
    public Monster battle(Monster m1, Monster m2) {
        //battle logic here
        while (m1.getHP() > 0 && m2.getHP() > 0) {
            //m1 takes turn
            int m1AtckDmg = attackDamage(m1.getStrength());
            int m2DmgHp = m2.getHP() - m1AtckDmg;
            m2.setHP(m2DmgHp);
            if (m2.getHP() <= 0) {
                break;
            }
            //m2 takes turn
            int m2AtckDmg = attackDamage(m2.getStrength());
            int m1DmgHp = m1.getHP() - m2AtckDmg;
            m1.setHP(m1DmgHp);
        }

        return m1.getHP() > 0 ? m1 : m2; //return the monster that won the battle
    }

    /*
     * Gets the valid dmg range based on the strengthLevel of the monster provided.
     * uses the generateMinAndMaxDmg() utility method to get the min and max values to be used
     * with the random number generator.
     * returns a random number within that range that represents the total attack damage done
     */
    public int attackDamage(int strengthLevel) {
        int[] minAndMaxRange = generateMinAndMaxDmg(strengthLevel);
        int minDmg = minAndMaxRange[0];
        int maxDmg = minAndMaxRange[1];

        return rand.nextInt(maxDmg) + minDmg;
    }

    /*
     * Utility method to get the min and max damage range of a monster
     * based on their strengthLevel. Returns the min and max values as an int[]
     * index 0 - min, index 1 - max
     */
    public int[] generateMinAndMaxDmg(int strengthLevel) {
        int[] minAndMax = new int[2];
        int minDmg = 1;
        int maxDmg = 10;

        if (strengthLevel > 20) {
            //formula to find damage range
            double totalJumps = (double) strengthLevel/STRENGTH_RANGE_JUMPS;
            int rangeJumps = (int) Math.ceil(totalJumps);

            if (rangeJumps - STRENGTH_RANGE_JUMPS <= 0) {
                maxDmg = rangeJumps * MAX_DAMAGE_INCREMENTS;
            }
            else {
                maxDmg = 50;
                minDmg = (rangeJumps - STRENGTH_RANGE_JUMPS) + MIN_DAMAGE_INCREMENTS;
            }
        }

        minAndMax[0] = minDmg;
        minAndMax[1] = maxDmg;

        return minAndMax;
    }
}