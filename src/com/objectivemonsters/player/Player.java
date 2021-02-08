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
    private List<String> gameShardsList = new ArrayList<>(); // list keep tracking all shards for the game.
    private List<String> pShards = new ArrayList<>(); // list keep tracking the player's shard inventory.
    private int key = 0;
    //tracks how many shards to win
    private int shardsToWin = 10;

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

    public List<String> getpShards() {
        return pShards;
    }

    public List<String> getgameShardsList() {
        return gameShardsList;
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
     * @param
     * @return an arraylist named gameShardList contain 10 element of type String. e.g. shard1, shard2...
     */
    public List<String> gameShardsGen(){
            for (int i = 1; i <= 10; i++ ){
                gameShardsList.add("shard" + i);
            }
        return gameShardsList;
    }

    /**
     * <p>
     * remove 1 element off gameShardsList and populate that element onto pShards list.
     * </p>
     * <pre>
     * <code>
     *     Player.dropShard();
     * </code>
     * </pre>
     *
     * @param
     * @return
     */
    public void dropShard(){
        // add 1 shard to pShards list.
        pShards.add(gameShardsList.get(0));
        // remove 1 element off
        gameShardsList.remove(0);
    }

    /**
     * <p>
     * once player gathered 10 shards the key will be set to int 1 which means got a Key.
     * </p>
     * <pre>
     * <code>
     *     Player.dropShard();
     * </code>
     * </pre>
     *
     * @param pShards the list of current shards the player possessed.
     * @return 1 when 10 shards are collected or 0.
     */
    public int setKey(List<String> pShards){
        if (pShards.size() == shardsToWin) {
            key = 1;
            pShards.clear(); // reset player shards list
        }
        return key;
    }

    /**
     * <p>
     * return true if player get a key.
     * </p>
     * <pre>
     * <code>
     *     Player.getKey();
     * </code>
     * </pre>
     *
     * @param
     * @return current key value
     */
    public boolean getKey(){
        if(this.key == 1) {
            return true;
        }
        return false;
    }

    public int getShardsToWin() {
        return shardsToWin;
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