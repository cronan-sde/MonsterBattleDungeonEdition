package com.objectivemonsters.storylines;

import java.util.List;

public class BattleTextGenerator {
    BattleTextList btt;
    String local;

    public String hitLine(){

        // get hit lines iterate through return a random one
        int random = randomNumber(btt.getBattleHits());
        for (int i = 0; i <= btt.getBattleHits().size(); i++) {
            if ( i == random) {
                local = btt.getBattleHits().get(i);
            }
        }
        return local;
    }

    public String missLine(){

        // git miss lines iterate through return a random one
        int random = randomNumber(btt.getBattleMiss());
        for (int i = 0; i <= btt.battleTextMiss().size(); i++) {
            if ( i == random) {
                local = btt.getBattleMiss().get(i);
            }
        }
        return local;
    }

    // REUSABLE RANDOM NUMBER GENERATOR BASED ON LIST LENGTH
    public int randomNumber(List<String> local) {
        return (int)(Math.random() * local.size());
    }

}
