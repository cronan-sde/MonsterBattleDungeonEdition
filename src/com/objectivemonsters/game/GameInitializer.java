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
    NodeList roomsNodeList;
    NodeList monstersNodeList;
    private String dungeonXMLPath = "resources/dungeon.xml" ;


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
                roomList.add(i, new Room((i+1), roomName, roomDescription, roomLeadTo));
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

    public Dungeon dungeonInit() {
        List<Monster> mList = new ArrayList<>();
        List<Item> iList = new ArrayList<>();

        // instantiate dungeon
        dungeon = new Dungeon(roomsInit(), mList, iList, false,0 );
        return dungeon;
    }
}
