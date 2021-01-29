package com.objectivemonsters.player;

import com.objectivemonsters.consumables.Item;
import com.objectivemonsters.monsters.Monster;

import java.util.List;

public class Player {
    // advanced editions allow player to pick name and some details
    // for now basic
    private String name; // more advanced version
    private List<Item> pItems;
    private List<Monster> pMonsters;

    // CONSTRUCTOR
    public Player(String name, List<Item> pItems, List<Monster> pMonsters) {
        this.name = name;
        this.pItems = pItems;
        this.pMonsters = pMonsters;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getpItems() {
        return pItems;
    }

    public void setpItems(List<Item> pItems) {
        this.pItems = pItems;
    }

    public List<Monster> getpMonsters() {
        return pMonsters;
    }

    public void setpMonsters(List<Monster> pMonsters) {
        this.pMonsters = pMonsters;
    }


    // tailored toString

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", pItems=" + pItems +
                ", pMonsters=" + pMonsters +
                '}';
    }
}