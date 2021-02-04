package com.objectivemonsters.storylines;

import java.util.List;

public class BattleTextList {
    BattleTextGenerator bt;
    String local;

    public String hitLine(){

        // get hit lines iterate through return a random one
        int random = randomNumber(bt.getBattleHits());
        for (int i = 0; i <= bt.getBattleHits().size(); i++) {
            if ( i == random) {
                local = bt.getBattleHits().get(i);
            }
        }
        return local;
    }

    public String missLine(){

        // git miss lines iterate through return a random one
        int random = randomNumber(bt.getBattleMiss());
        for (int i = 0; i <= bt.battleTextMiss().size(); i++) {
            if ( i == random) {
                local = bt.getBattleMiss().get(i);
            }
        }
        return local;
    }

    // REUSABLE RANDOM NUMBER GENERATOR BASED ON LIST LENGTH
    public int randomNumber(List<String> local) {
        return (int)(Math.random() * local.size());
    }

}
