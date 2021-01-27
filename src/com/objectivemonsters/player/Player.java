package com.objectivemonsters.player;

import com.objectivemonsters.consumables.Item;
import com.objectivemonsters.monsters.Monster;

import java.util.List;

public class Player {
    // advanced editions allow player to pick name and some details
    // for now basic
    String name; // more advanced version
    List<Item> pItems;
    List<Monster> pMonsters;

    // TODO: CONSTRUCTOR

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


    // TODO: tailored toString

}