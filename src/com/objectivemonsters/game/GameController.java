package com.objectivemonsters.game;

public class GameController {
    // TODO: initialize game
    public void initialize() {
        monsterAssignment();
        itemAssignment();
        roomsInit();
        dungeonInit();
    }

    // random assign monster to each room
    public void monsterAssignment() {
        // Pseudocode
    }

    // random assign item to each room
    public void itemAssignment() {

    }

    public void roomsInit() {
        // step 1: random and instantiate item
        // step 2: random and instantiate Monster
        // step 3: load XML
        // step 4: slice parsed xml to instantiate all rooms via iteration
    }

    public void dungeonInit() {
        // instantiate dungeon
    }

    // method to yield a random number within provided range, maybe can moved to util package later.
    public int randNum(int range){
        int result = 0;
        // TODO: generate random number between 0 and range
        return result;
    }

    // TODO: control game flow here

}