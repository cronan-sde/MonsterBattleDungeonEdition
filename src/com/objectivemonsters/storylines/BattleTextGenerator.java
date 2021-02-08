package com.objectivemonsters.storylines;

import java.util.List;

public class BattleTextGenerator {
    BattleTextList btt = new BattleTextList();


    public String hitLine(){
        String local;
        // get hit lines iterate through return a random one
        int random = randomNumber(btt.battleTextHit());
        local = btt.battleTextHit().get(random);

        return local;
    }

    public String missLine(){
        String local2;
        // git miss lines iterate through return a random one
        int random = randomNumber(btt.battleTextMiss());
        local2 = btt.battleTextMiss().get(random);

        return local2;
    }

    // REUSABLE RANDOM NUMBER GENERATOR BASED ON LIST LENGTH
    public int randomNumber(List<String> local) {
        return (int)(Math.random() * local.size());
    }

}
