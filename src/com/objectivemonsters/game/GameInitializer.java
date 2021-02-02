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
    Item item;
    Room room;
    List<Room> roomList = new ArrayList<>();
    NodeList roomsNodeList;
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

        // monster in room, one per room.
        Monster monsterZoya; // fix here
        Monster monsterHoppy;

        monsterZoya = new Monster("Shady Spook", false, 90, Elemental.AIR, 190, 40, 50, "Mysterious, shrieking shady figure."); // TODO: should move to monsterAssignment().
        monsterHoppy = new Monster("Drowsy Dragon", true, 100, Elemental.WATER, 200, 40, 50, "Green blob"); // TODO: should move to monsterAssignment().
        Item recoverPotion = new Item("recover potion", "drink", 10);
        List<Item> roomItem = Arrays.asList(recoverPotion);


        // assign total numbers of rooms to numOfRooms

        int numOfRooms = roomsNodeList.getLength();
        Element eElement;
        String adjacentRoom;
        int len;
        String roomDescription;
        String roomName;
        Node node;

        // iterate and instantiate all rooms
        for ( int i = 0; i < numOfRooms; i++ ){
            node =  roomsNodeList.item(i); // return XML for a single room at index 'i'.
            List<String> roomLeadTo = new ArrayList<>(); // provide a new list each iteration.
            if (node.getNodeType() == Node.ELEMENT_NODE){
                eElement = (Element) node;
                roomName = eElement.getElementsByTagName("roomName").item(0).getTextContent();
                roomDescription = eElement.getElementsByTagName("roomFeature").item(0).getTextContent();
                len = eElement.getElementsByTagName("roomleadTo").getLength();
                for (int x = 0; x < len; x++) {
                    adjacentRoom = eElement.getElementsByTagName("roomleadTo").item(x).getTextContent();
                    roomLeadTo.add(x, adjacentRoom);
                }
                // instantiate room and populate room to roomList.
                // roomList.add(i, new Room((i+1), roomName, roomDescription, roomLeadTo));
                if (roomName.equals("humanoidbones")) {
                    roomList.add(i, new Room((i+1), roomName, roomDescription, roomLeadTo, monsterHoppy, roomItem));

                } else {
                    roomList.add(i, new Room((i+1), roomName, roomDescription, roomLeadTo, monsterZoya, roomItem));
                }

            }
        }
        return roomList;
    }


    // TODO: random assign item to each room


    public Dungeon dungeonInit() {
        List<Monster> mList = new ArrayList<>();
        List<Item> iList = new ArrayList<>();

        // instantiate dungeon
        dungeon = new Dungeon(roomsInit(), mList, iList, false,0 );
        return dungeon;
    }
}
