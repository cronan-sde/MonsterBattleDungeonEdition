package com.objectivemonsters.monsters;

import java.util.List;

public class MonsterLocationGenerator {
    MonsterLocationsList monloclis = new MonsterLocationsList();
    List<String> angryloco = monloclis.angryMonsterLocations;
    List<String> friendloco = monloclis.friendlyMonsterLocations;

    // METHODS RETURN ONE LOCATION FOR FRIENDLY OR ANGRY MONSTERS AS CALLED

    public String friendMonLocal(){
        String local;
        // get friendly monster locations and iterate through them
        int random = randomNumber(friendloco.size());

        local = monloclis.getAngryMonsterLocations().get(random);
        return local;
    }

//    public String angryMonLocal(){
//        String local2;
//        // get friendly monster locations and iterate through them
//        int random = randomNumber(angryloco.size());
//        local2 = monloclis.getFriendlyMonsterLocations().get(random);
//        return local2;
//    }

    // REUSABLE RANDOM NUMBER GENERATOR BASED ON LIST LENGTH
    public int randomNumber(int local)
    {
        return (int)(Math.random() * local);
    }

}
