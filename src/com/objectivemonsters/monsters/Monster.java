package com.objectivemonsters.monsters;

public class Monster {
    // consider later allowing players to name monsters and adding species enum
    // i.e. purple dragons, winged green dragons, slime blob
    // i.e. percy the purple dragon, peggy the purple dragon, etc...
    private String name;
   // Friendly or Angry monster
    private boolean isFriendly;
    // Health points
    private int HP;
    // the type called Elemental and an enum
    private Elemental elm;
    // strength used in battle engine to determine attack damage to HP
    private int strength;
    // intellect used in battle engine to determine avoiding attack
    private int intellect;
    // agility used in battle engine to determine chance of striking more than once in an attack
    private int agility;
    // add dimension to story with description of monster color, size, scariness all text-based
    private String desc;
    // determine if a monster is friend or foe.

    // Constructors
    // no-arg
    public Monster() {
    }

    // all args
    public Monster(String name, boolean isFriendly, int HP, Elemental elm, int strength, int intellect, int agility, String desc) {
        this.name = name;
        this.isFriendly = isFriendly;
        this.HP = HP;
        this.elm = elm;
        this.strength = strength;
        this.intellect = intellect;
        this.agility = agility;
        this.desc = desc;
    }



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
    // current is ugly given toString


    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", isFriendly=" + isFriendly +
                ", HP=" + HP +
                ", elm=" + elm +
                ", strength=" + strength +
                ", intellect=" + intellect +
                ", agility=" + agility +
                ", desc='" + desc + '\'' +
                '}';
    }
}