package com.objectivemonsters.map;

import com.objectivemonsters.consumables.Item;
import com.objectivemonsters.monsters.Monster;

import java.util.List;

// room description and objects and exits
public class Room {

    // room id
    private int roomId;
    // room name
    private String name;
    // describe the room
    private String description;
    //  from rooms are called roomLeadTo
    private List<String> roomLeadTo;
    // exits from rooms are called exits
    private List<String> exits;
    // monster in room, one per room, could expand and change to array list later
    private Monster roomMonster;
    // Item in room
    private List<Item> item;
    // determine if a room has the exits of the dungeon.
    private boolean hasExitDoor;

    // constructors
    public Room(){
        // empty ctor
    }

    public Room(int roomId, String name, String description, List<String> roomLeadTo, List<String> exits) {
        this.roomId = roomId;
        this.name = name;
        this.description = description;
        this.roomLeadTo = roomLeadTo;
        this.exits = exits;
        this.hasExitDoor = false;
    }

    public Room(int roomId, String name, String description, List<String> roomLeadTo) {
        this.roomId = roomId;
        this.name = name;
        this.description = description;
        this.roomLeadTo = roomLeadTo;
        this.hasExitDoor = false;
    }

    public Room(int roomId, String name, String description, List<String> roomLeadTo, Monster roomMonster, List<Item> item) {
        this.roomId = roomId;
        this.name = name;
        this.description = description;
        this.roomLeadTo = roomLeadTo;
        this.roomMonster = roomMonster;
        this.item = item;
        this.hasExitDoor = false;
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

    public List<String> getRoomLeadTo() {
        return roomLeadTo;
    }

    public List<String> getExits() {
        return exits;
    }

    public Monster getRoomMonster() {
        return roomMonster;
    }

    public List<Item> getItem() {
        return item;
    }

    public boolean isHasExitDoor() {
        return hasExitDoor;
    }

    public void setHasExitDoor(boolean hasExitDoor) {
        this.hasExitDoor = hasExitDoor;
    }

    // Tailored toString
    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", roomLeadTo=" + roomLeadTo +
                ", exits=" + exits +
                ", dungeon exits=" + hasExitDoor +
                '}';
    }
}