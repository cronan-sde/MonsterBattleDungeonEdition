package com.objectivemonsters.dungeon;

import com.objectivemonsters.consumables.Item;
import com.objectivemonsters.monsters.Monster;

import java.util.List;

public class Room {
    // room id
    int roomId;
    // room name
    String name;
    // describe the room
    String description;
    // exits from rooms are called archways
    List<String> archways;
    // monster in room, one per room, could expand and change to array list later
    Monster roomMonster;
    // items in room
    List<Item> item;

    // Constructor

    public Room(int roomId, String name, String description, List<String> archways, Monster roomMonster, List<Item> item) {
        this.roomId = roomId;
        this.name = name;
        this.description = description;
        this.archways = archways;
        this.roomMonster = roomMonster;
        this.item = item;
    }


    // Getters and Setters

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getArchways() {
        return archways;
    }

    public void setArchways(List<String> archways) {
        this.archways = archways;
    }

    public Monster getRoomMonster() {
        return roomMonster;
    }

    public void setRoomMonster(Monster roomMonster) {
        this.roomMonster = roomMonster;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    // Tailored toString

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", archways=" + archways +
                ", roomMonster=" + roomMonster +
                ", item=" + item +
                '}';
    }
}