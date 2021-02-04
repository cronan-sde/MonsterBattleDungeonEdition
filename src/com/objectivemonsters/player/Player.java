package com.objectivemonsters.player;

import com.objectivemonsters.consumables.Item;
import com.objectivemonsters.monsters.Monster;

import java.util.ArrayList;
import java.util.List;

public class Player {
    // advanced editions allow player to pick name and some details
    // for now basic
    private String name; // more advanced version
    private List<Item> pItems;
    private List<Monster> pMonsters;
    private List<String> shardsList = new ArrayList<>();

    // CONSTRUCTOR
    public Player(){
        //empty
    }

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

    // Methods

    /**
     * <p>
     * Generate 10 shards and populate into an arraylist named shardsList.
     * </p>
     * <pre>
     * <code>
     *     Player.shardGen();
     * </code>
     * </pre>
     *
     * @param none
     * @return an arraylist named shardList contain 10 element of type String. e.g. shard1, shard2...
     */
    public List<String> shardGen(){
            for (int i = 1; i <= 10; i++ ){
                shardsList.add("shard" + i);
            }
        return shardsList;
    }

    /**
     * <p>
     * Generate 10 shards and populate into an arraylist named shardsList.
     * </p>
     * <pre>
     * <code>
     *     Player.shardGen();
     * </code>
     * </pre>
     *
     * @param shardsList the shards list.
     * @return drop the last element in the shardsList and return the shardsList.
     */
    public List<String> dropShard(List<String> shardsList){
        int index = shardsList.size() - 1;
        shardsList.remove(index);
        return shardsList;
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