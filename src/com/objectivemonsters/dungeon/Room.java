package com.objectivemonsters.dungeon;

import com.objectivemonsters.consumables.Item;
import com.objectivemonsters.monsters.Monster;

import java.util.ArrayList;
import java.util.List;

// room description and objects and exits
public class Room {
    // room id
    private int roomId;
    // room name
    private String name;
    // describe the room
    private String description;
    // exits from rooms are called roomLeadTo
    private List<String> roomLeadTo;
    // monster in room, one per room, could expand and change to array list later
    private Monster roomMonster;
    // Item in room
    private List<Item> item;

    // constructors
    public Room(int roomId, String name, String description, List<String> roomLeadTo) {
        this.roomId = roomId;
        this.name = name;
        this.description = description;
        this.roomLeadTo = roomLeadTo;
    }

    public Room(int roomId, String name, String description, List<String> roomLeadTo, Monster roomMonster, List<Item> item) {
        this.roomId = roomId;
        this.name = name;
        this.description = description;
        this.roomLeadTo = roomLeadTo;
        this.roomMonster = roomMonster;
        this.item = item;
    }

    // Getters and Setters
    public int getRoomId() {
        return roomId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getroomLeadTo() {
        return roomLeadTo;
    }

    public Monster getRoomMonster() {
        return roomMonster;
    }

    public List<Item> getItem() {
        return item;
    }

    // Tailored toString
    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", roomLeadTo=" + roomLeadTo +
                '}';
    }
}