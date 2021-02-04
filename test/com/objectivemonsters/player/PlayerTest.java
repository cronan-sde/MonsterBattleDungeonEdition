package com.objectivemonsters.player;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    Player player = new Player();

    @Test
    public void shardGenShouldReturn10Shards() {
        assertEquals(10,player.shardGen().size());
    }

    @Test
    public void dropShard() {
        assertEquals(9,player.dropShard(player.shardGen()).size());
    }
}