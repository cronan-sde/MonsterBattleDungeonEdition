package com.objectivemonsters.map;

import com.objectivemonsters.consumables.Item;
import com.objectivemonsters.monsters.Monster;
import com.objectivemonsters.storylines.BattleTextList;

import java.util.List;

// the dungeon containing all game Item and objects
public class Dungeon {

    // collection of rooms in this level of dungeon
    private List<Room> dungeonRooms;
    // collection of monsters in this level of dungeon
    private List<Monster> dungeonMonsters;
    // Item available in this level of dungeon
    private List<Item> dungeonItem;
    // lines of batle text hits
    private List<String> battleHitsLines;
    // lines of battle text miss
    private List<String> getBattleMissLines;
    // when escape is true, generate new dungeon level, this is true when player uses shard created key to open door
    private Boolean escape;
    // Dungeon level for advanced dungeons
    private int level;

    //constructors
    // no-arg
    public Dungeon() {
    }

    public Dungeon(List<Room> dungeonRooms, List<Monster> dungeonMonsters,boolean escape, int level) {
        this.dungeonRooms = dungeonRooms;
        this.dungeonMonsters = dungeonMonsters;
        this.escape = escape;
        this.level = level;
    }

    public Dungeon(List<Room> dungeonRooms, List<Monster> dungeonMonsters, List<Item> dungeonItem, Boolean escape, int level) {
        this.dungeonRooms = dungeonRooms;
        this.dungeonMonsters = dungeonMonsters;
        this.dungeonItem = dungeonItem;
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

    public List<Item> getDungeonItem() {
        return dungeonItem;
    }

    public void setDungeonItem(List<Item> dungeonItem) {
        this.dungeonItem = dungeonItem;
    }

    public List<String> getBattleHitsLines() { return battleHitsLines; }

    public void setBattleHitsLines(List<String> battleHitsLines) { this.battleHitsLines = battleHitsLines; }

    public List<String> getGetBattleMissLines() { return getBattleMissLines; }

    public void setGetBattleMissLines(List<String> getBattleMissLines) { this.getBattleMissLines = getBattleMissLines; }

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
                ", escape=" + escape +
                ", level=" + level +
                '}';
    }
}