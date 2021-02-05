package com.objectivemonsters.monsters;

import java.util.ArrayList;
import java.util.List;

/*
METHODS AVAILABLE -
ALL: FRIENDLY MONSTERS, ANGRY MONSTERS
ONE random: MONSTER, FRIENDLY MONSTER, ANGRY MONSTERS

 */
public class MonsterGenerator {
    MonsterList ml = new MonsterList();

    private Monster monty;
    private List<Monster> monLocalFriendly = new ArrayList<>();
    private List<Monster> monLocalAngry = new ArrayList<>();


    // Generate a list of Angry Monsters
    public List<Monster> angryMonstersAll() {

        // iterate through list of all monsters and return only angry monsters
        for (Monster mon : ml.allMonsters()) {
            if (mon.isFriendly() == false) {
                monLocalAngry.add(mon);
            }
        }
        return monLocalAngry;
    }

    // iterate through list of all monsters and return only friendly monsters
    // TODO: combine and send in whether wanting a f or a
    public List<Monster> friendlyMonstersAll() {
        List<Monster> friendlyMonsters = new ArrayList<>();
        for (Monster mon : ml.allMonsters()) {
            if (mon.isFriendly() == true) {
                monLocalFriendly.add(mon);
            }
        }
        return monLocalFriendly;
    }


    // Return one Random Monster
    public Monster randomMonster() {

        int random = randomNumber(ml.allMonsters());
        monty = ml.allMonsters().get(random);

        return monty;
    }

    // Return one Random Angry Monster
    public Monster randoAngryMon() {

        int random = randomNumber(monLocalAngry);
        monty = ml.allMonsters().get(random);

        return monty;
    }

    // Return one Random Friendly Monster
    public Monster randoFriendlyMon() {

        int random = randomNumber(monLocalFriendly);
        monty = ml.allMonsters().get(random);

        return monty;
    }


    // REUSABLE RANDOM NUMBER GENERATOR BASED ON LIST LENGTH
    public int randomNumber(List<Monster> local) {
        return (int)(Math.random() * local.size());
    }

    // TODO: Morph a dead Angry monster to a Friendly monster - not yet implemented & may never be, but maybe


    public List<Monster> getMonLocalFriendly() {
        return monLocalFriendly;
    }

    private void setMonLocalFriendly(List<Monster> monLocalFriendly) {
        this.monLocalFriendly = friendlyMonstersAll();
    }

    public List<Monster> getMonLocalAngry() {
        return monLocalAngry;
    }

    private void setMonLocalAngry(List<Monster> monLocalAngry) {
        this.monLocalAngry = angryMonstersAll();
    }
}