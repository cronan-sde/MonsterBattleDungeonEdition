package com.objectivemonsters.monsters;

import java.util.List;

public class MonsterLocationGenerator {
    MonsterLocationsList mll;
    String local;

    // METHODS RETURN ONE LOCATION FOR FRIENDLY OR ANGRY MONSTERS AS CALLED

    public String friendMonLocal(){
        // get friendly monster locations and iterate through them
        int random = randomNumber(mll.getFriendlyMonsterLocations());
        for (int i = 0; i <= mll.getFriendlyMonsterLocations().size(); i++) {
            if ( i == random) {
                local = mll.getFriendlyMonsterLocations().get(i);
            }
        }
        return local;
    }

    public String angryMonLocal(){
        // get friendly monster locations and iterate through them
        int random = randomNumber(mll.getAngryMonsterLocations());
        for (int i = 0; i <= mll.getAngryMonsterLocations().size(); i++) {
            if ( i == random) {
                local = mll.getAngryMonsterLocations().get(i);
            }
        }
        return local;
    }

    // REUSABLE RANDOM NUMBER GENERATOR BASED ON LIST LENGTH
    public int randomNumber(List<String> local) {
        return (int)(Math.random() * local.size());
    }

}
