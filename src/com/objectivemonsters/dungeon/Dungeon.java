package com.objectivemonsters.dungeon;

import com.objectivemonsters.consumables.Item;
import com.objectivemonsters.monsters.Monster;

import java.util.List;

// the dungeon containing all game items and objects
public class Dungeon {

    // collection of rooms in this level of dungeon
    List<Room> dungeonRooms;
    // collection of monsters in this level of dungeon
    List<Monster> dungeonMonsters;
    // items available in this level of dungeon
    List<Item> dungeonItems;
    // when escape is true, generate new dungeon level, this is true when player uses shard created key to open door
    Boolean escape;
    // Dungeon level for advanced dungeons
    int level;

    //constructors

    public Dungeon(List<Room> dungeonRooms, List<Monster> dungeonMonsters, List<Item> dungeonItems, Boolean escape, int level) {
        this.dungeonRooms = dungeonRooms;
        this.dungeonMonsters = dungeonMonsters;
        this.dungeonItems = dungeonItems;
        this.escape = escape;
        this.level = level;
    }


    // Getters and  Setters

    public List<Room> getDungeonRooms() {
        return dungeonRooms;
    }

    public void setDungeonRooms(List<Room> dungeonRooms) {
        this.dungeonRooms = dungeonRooms;
    }

    public List<Monster> getDungeonMonsters() {
        return dungeonMonsters;
    }

    public void setDungeonMonsters(List<Monster> dungeonMonsters) {
        this.dungeonMonsters = dungeonMonsters;
    }

    public List<Item> getDungeonItems() {
        return dungeonItems;
    }

    public void setDungeonItems(List<Item> dungeonItems) {
        this.dungeonItems = dungeonItems;
    }

    public Boolean getEscape() {
        return escape;
    }

    public void setEscape(Boolean escape) {
        this.escape = escape;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    // tailored toString

    @Override
    public String toString() {
        return "Dungeon{" +
                "dungeonRooms=" + dungeonRooms +
                ", dungeonMonsters=" + dungeonMonsters +
                ", dungeonItems=" + dungeonItems +
                ", escape=" + escape +
                ", level=" + level +
                '}';
    }
}
