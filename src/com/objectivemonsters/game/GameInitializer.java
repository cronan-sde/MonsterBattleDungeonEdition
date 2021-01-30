package com.objectivemonsters.game;

import com.objectivemonsters.consumables.Item;
import com.objectivemonsters.dungeon.Dungeon;
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
    // Fields
    TextParser parser = new TextParser();
    Dungeon dungeon;
    Monster monster;
    Item item;
    Room room;
    List<Room> roomList = new ArrayList<>();
    List<Monster> monsList = new ArrayList<>();
    NodeList roomsNodeList;
    NodeList monstersNodeList;
    private String dungeonXMLPath = "resources/dungeon.xml" ;


    // Methods
    public void initialize() {
        roomsInit(); // DONE: 1st get all the rooms object created
         //  monsterAssignment(); //TODO: traverse list of room returned by roomsInit() assign monster.
        // itemAssignment(); //TODO: traverse list of room returned by roomsInit() assign item if any.
        // dungeonInit(); //TODO: initialize dungeon.
    }

    public List<Room> roomsInit() {
        // return a Nodelist object (roomsList) of room from XMl.
        roomsNodeList = parser.readXMLFiles(dungeonXMLPath, "room");
<<<<<<< HEAD
        // assign total numbers of rooms to numOfRooms
        int numOfRooms = roomsNodeList.getLength();
        //a List of route(s) the room lead to.
<<<<<<< HEAD
        List<String> roomLeadTo = new ArrayList<>();

        // a List contains item(s) in the room
        List<Item> roomItem = new ArrayList<>();
=======
>>>>>>> 9f95af31b5ffe7ee5e7a1d6a7779140964861a39

        // monster in room, one per room.
        Monster monsterZoya; // fix here
        Monster monsterHoppy;

        monsterZoya = new Monster("Shady Spook", false, 90, Elemental.AIR, 190, 40, 50, "Mysterious, shrieking shady figure."); // TODO: should move to monsterAssignment().
        monsterHoppy = new Monster("Drowsy Dragon", true, 100, Elemental.WATER, 200, 40, 50, "Green blob"); // TODO: should move to monsterAssignment().
        Item recoverPotion = new Item("recover potion", "drink", 10);
        List<Item> roomItem = Arrays.asList(recoverPotion);


<<<<<<< HEAD
//        recoverPotion = new Item("recover potion", "drink",10);// TODO: should move to itemAssignment().
        //roomItem = Arrays.asList(recoverPotion); // TODO: should move to itemAssignment().
=======

=======
        // assign total numbers of rooms to numOfRooms

        int numOfRooms = roomsNodeList.getLength();
>>>>>>> 9f95af31b5ffe7ee5e7a1d6a7779140964861a39
        Element eElement;
        String adjacentRoom;
        int len;
        String roomDescription;
        String roomName;
        Node node;
<<<<<<< HEAD

=======
>>>>>>> 9f95af31b5ffe7ee5e7a1d6a7779140964861a39

        // iterate and instantiate all rooms
        for ( int i = 0; i < numOfRooms; i++ ){
            node =  roomsNodeList.item(i); // return XML for a single room at index 'i'.
            List<String> roomLeadTo = new ArrayList<>(); // provide a new list each iteration.
            if (node.getNodeType() == Node.ELEMENT_NODE){
<<<<<<< HEAD
<<<<<<< HEAD
                Element eElement = (Element) node;

                String roomName = eElement.getElementsByTagName("roomName").item(0).getTextContent(); // e.g. "dungeon playground";
                String roomDescription = eElement.getElementsByTagName("roomFeature").item(0).getTextContent();
                if (roomName.equals("humanoid bones")) {
                roomList.add(i,new Room((i+1), roomName, roomDescription, roomLeadTo, monsterHoppy, roomItem));
            } else {
                    roomList.add(i,new Room((i+1), roomName, roomDescription, roomLeadTo, monsterZoya, roomItem);
                }
=======
=======
>>>>>>> 9f95af31b5ffe7ee5e7a1d6a7779140964861a39
                eElement = (Element) node;
                roomName = eElement.getElementsByTagName("roomName").item(0).getTextContent();
                roomDescription = eElement.getElementsByTagName("roomFeature").item(0).getTextContent();
                len = eElement.getElementsByTagName("roomleadTo").getLength();
                for (int x = 0; x < len; x++) {
                    adjacentRoom = eElement.getElementsByTagName("roomleadTo").item(x).getTextContent();
                    roomLeadTo.add(x, adjacentRoom);
                }
                // instantiate room and populate room to roomList.
<<<<<<< HEAD
                roomList.add(i, new Room((i+1), roomName, roomDescription, roomLeadTo));
            }
>>>>>>> feb018e2c681dae8138334609d75d6553eac087f
=======
                // roomList.add(i, new Room((i+1), roomName, roomDescription, roomLeadTo));
                if (roomName.equals("humanoid bones")) {
                    roomList.add(i, new Room((i+1), roomName, roomDescription, roomLeadTo, monsterHoppy, roomItem));

                } else {
                    roomList.add(i, new Room((i+1), roomName, roomDescription, roomLeadTo, monsterZoya, roomItem));
                }

            }
>>>>>>> 9f95af31b5ffe7ee5e7a1d6a7779140964861a39
        }
        return roomList;
    }


    // TODO: random assign monster to each room
//    public void monsterAssignment() {
//        monstersNodeList = parser.readXMLFiles("resources/monster.xml", "monster");
//
//        int numberMons = monstersNodeList.getLength();
//
//        // iterate through Node List from XML and add all to Monster arraylist
//        for (int i = 0; i < numberMons; i++) {
//            Node node = monstersNodeList.item(i);
//            if (node.getNodeType() == Node.ELEMENT_NODE) {
//                Element eElement = (Element) node;
//
//                String name = eElement.getElementsByTagName("name").item(0).getTextContent();
//                Boolean isFriendly = true;
//                String friendly = eElement.getElementsByTagName("friendly").item(0).getTextContent();
//                if (friendly.equals("true")) {
//                    isFriendly = true;
//                } else {
//                    isFriendly = false;
//                }
//                int HP = eElement.getAttribute("HP");
//                int Strength;
//                int intellect;
//                int agility;
//                String desc = eElement.getElementsByTagName("description").item(0).getTextContent();
//
//
////
//
//                monty.setStrength(eElement.getElementsByTagName("strength").item(0).getTextContent());
//                monty.setIntellect(eElement.getElementsByTagName("intellect").item(0).getTextContent());
//                monty.setAgility(eElement.getElementsByTagName("agility").item(0).getTextContent());
//
//
//
//
//                monsList.add(i,new Monster
//
//            }
//        }

//        int rando = (int) ((Math.random() * numberMons) +1);
//
//
//    }

    // TODO: random assign item to each room
//

    public Dungeon dungeonInit() {
        List<Monster> mList = new ArrayList<>();
        List<Item> iList = new ArrayList<>();

        // instantiate dungeon
        dungeon = new Dungeon(roomsInit(), mList, iList, false,0 );
        return dungeon;
    }
}

