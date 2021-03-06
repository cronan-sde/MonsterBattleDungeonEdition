package com.objectivemonsters.player;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    Player player = new Player();

    @Test
    public void shardGenShouldReturn10Shards() {
        assertEquals(10,player.gameShardsGen().size());
    }

    @Test
    public void pShardsSizeShouldBeZeroByDefault(){
        assertEquals(0, player.getpShards().size());
    }

    @Test
    public void pShardsShouldHaveOneElement() {
        player.gameShardsGen();
        player.dropShard();
        assertEquals(1,player.getpShards().size());
    }

    @Test
    public void gameShardsListShouldHaveNineElement() {
        player.gameShardsGen();
        player.dropShard();
        assertEquals(9,player.getgameShardsList().size());
    }

    @Test
    public void playerShouldGetAKey(){
        player.gameShardsGen();
        for (String shard: player.getgameShardsList()) {
            player.getpShards().add(shard);
        }
        assertEquals(1,player.setKey(player.getpShards()));
    }
}