package com.objectivemonsters.game;

import com.objectivemonsters.consumables.Item;
import com.objectivemonsters.dungeon.Room;
import com.objectivemonsters.monsters.Elemental;
import com.objectivemonsters.monsters.Monster;
import com.objectivemonsters.util.TextParser;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameInitializer {
    // Pseudocode
    // step 1: random and instantiate item
    // step 2: random and instantiate Monster
    // step 3: load XML
    // step 4: slice parsed xml to instantiate all rooms via iteration

    // Fields
    TextParser parser = new TextParser();
    Monster monster;
    Item item;
    Room room;
    List<Room> roomList = new ArrayList<>();
    NodeList roomsNodeList;
    NodeList monstersNodeList;
    String dungeonXMLPath = "resources/dungeon.xml" ;
    String monsterXMLPath = "resources/monster.xml" ;

    // Methods
    public void initialize() {
        roomsInit(); // DONE: 1st get all the rooms object created
        // monsterAssignment(); //TODO: traverse list of room returned by roomsInit() assign monster.
        // itemAssignment(); //TODO: traverse list of room returned by roomsInit() assign item if any.
        // dungeonInit(); //TODO: initialize dungeon.
    }

    public List<Room> roomsInit() {

        // return a Nodelist object (roomsList) of room from XMl.
        roomsNodeList = parser.readXMLFiles(dungeonXMLPath, "room");
        // assign total numbers of rooms to numOfRooms
        int numOfRooms = roomsNodeList.getLength();

        //a List of route(s) the room lead to.
        List<String> roomLeadTo = new ArrayList<>();
        // a List contains item(s) in the room
        List<Item> roomItem = new ArrayList<>();
        // monster in room, one per room.
        Monster monsterZoya;
        // an instance of Item class, a item in the room.
        Item recoverPotion;

        //roomLeadTo = Arrays.asList("humanoid bones","torn chamber"); //TODO: alter XML or figure out how to parse multiple tag with same tag name.
        //  dungeon monster is the default monster.
        monsterZoya = new Monster("dungeon monster", 100, Elemental.AIR, 50,22,15,"paranoid",false);// TODO: should move to monsterAssignment().
        recoverPotion = new Item("recover potion", "drink",10);// TODO: should move to itemAssignment().
        //roomItem = Arrays.asList(recoverPotion); // TODO: should move to itemAssignment().

        // iterate and instantiate all rooms
        for ( int i = 0; i < numOfRooms; i++ ){
            Node node =  roomsNodeList.item(i); // return XML for a single room at index 'i'.
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) node;

                String roomName = eElement.getElementsByTagName("roomName").item(0).getTextContent(); // e.g. "dungeon playground";
                String roomDescription = eElement.getElementsByTagName("roomFeature").item(0).getTextContent();
                roomList.add(i,new Room((i+1), roomName, roomDescription, roomLeadTo, monsterZoya, roomItem));
            }
        }
        return roomList;
    }

    // method to yield a random number between 1 and range.
    public int getRandomNum(int range){
        int result = 0;
        result = (int) ((Math.random() * range) + 1);
        return result;
    }

    // TODO: random assign monster to each room
    public void monsterAssignment() {
    }

    // TODO: random assign item to each room
    public void itemAssignment() {

    }

    public void dungeonInit() {
        // instantiate dungeon
        //TODO: in spring 1
    }



}
