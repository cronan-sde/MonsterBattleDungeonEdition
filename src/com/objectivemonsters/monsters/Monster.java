package com.objectivemonsters.monsters;

public class Monster {
    String name;
    // Health points
    boolean isFriendly;
    int HP;
    // the type called Elemental and an enum
    Elemental elm;
    // strength used in battle engine to determine attack damage to HP
    int strength;
    // intellect used in battle engine to determine avoiding attack
    int intellect;
    // agility used in battle engine to determine chance of striking more than once in an attack
    int agility;
    // add dimension to story with description of monster color, size, scariness all text-based
    String desc;

    // Constructors
    // TODO: no-arg or tailored constructor


    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFriendly() {
        return isFriendly;
    }

    public void setFriendly(boolean friendly) {
        isFriendly = friendly;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public Elemental getElm() {
        return elm;
    }

    public void setElm(Elemental elm) {
        this.elm = elm;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    // TODO: tailored toString


}