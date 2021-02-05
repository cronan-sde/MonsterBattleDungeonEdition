package com.objectivemonsters.map;

import com.objectivemonsters.monsters.Monster;
import com.objectivemonsters.util.TextParser;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.*;

public class MapInit {

    //private fields.
    TextParser parser = new TextParser();
    private Dungeon dungeon;
    private List<Room> roomList = new ArrayList<>();
    private NodeList roomsNodeList;
    private String dungeonXMLPath = "resources/dungeon.xml" ;
    // Methods.

    public List<Room> roomsInit() {
        // return a List (roomsList) of room from XMl.
        roomsNodeList = parser.readXMLFiles(dungeonXMLPath, "room");
        // Block level Fields.
        int numOfRooms = roomsNodeList.getLength();
        Element eElement;
        String adjacentRoom;
        int len;
        String roomDescription;
        String roomName;
        String direction;
        Node node;
        List<String> roomLeadTo;
        List<String> roomExits;

        // iterate and instantiate all rooms
        for ( int i = 0; i < numOfRooms; i++ ){
            node =  roomsNodeList.item(i); // return XML for a single room at index 'i'.
                roomExits = new ArrayList<>();
                roomLeadTo = new ArrayList<>();
            if (node.getNodeType() == Node.ELEMENT_NODE){
                eElement = (Element) node;
                roomName = eElement.getElementsByTagName("roomName").item(0).getTextContent();
                roomDescription = eElement.getElementsByTagName("roomFeature").item(0).getTextContent();
                len = eElement.getElementsByTagName("roomleadTo").getLength();
                for (int x = 0; x < len; x++) {
                    adjacentRoom = eElement.getElementsByTagName("roomleadTo").item(x).getTextContent();
                    roomLeadTo.add(x, adjacentRoom);
                    direction = eElement.getElementsByTagName("exit").item(x).getTextContent();
                    roomExits.add(x, direction);
                }
                roomList.add(i, new Room((i+1), roomName, roomDescription, roomLeadTo, roomExits));
            }
        }
        return roomList;
    }

    public void assignExitDoor(){
       //TODO:
    }

    public Dungeon dungeonInit(List<Monster> monsters) {
        // instantiate dungeon
        dungeon = new Dungeon(roomsInit(),monsters,false,1);
        return dungeon;
    }

}
