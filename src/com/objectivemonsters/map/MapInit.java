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
    //private String dungeonXMLPath = "resources/dungeon.xml" ;
    private String dungeonXMLPath = "resources/dungeon2.xml" ;
    // Methods.

    /**
     * <p>
     * </p>
     * <pre>
     * <code>
     *     GameInitializer.roomsInit();
     * </code>
     * </pre>
     * @return a list of dungeon room objects.
     */
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
                roomExits = new ArrayList<>(); // provide a new list for exits each iteration.
                roomLeadTo = new ArrayList<>(); // provide a new list each iteration.
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
                //roomList.add(i, new Room((i+1), roomName, roomDescription, roomLeadTo));
                roomList.add(i, new Room((i+1), roomName, roomDescription, roomLeadTo, roomExits));
            }
        }
        return roomList;
    }

    /**
     * <p>
     * </p>
     * <pre>
     * <code>
     *     GameInitializer.dungeonInit(monsters);
     * </code>
     * </pre>
     * @param monsters List of Monster object.
     * @return a instance of Dungeon.
     */
    public Dungeon dungeonInit(List<Monster> monsters) {
        // instantiate dungeon
        dungeon = new Dungeon(roomsInit(),monsters,false,1);
        return dungeon;
    }


    //public Map mapRoutes() {
//    public List<Map> mapRoutes() {
//        // return a List (roomsList) of room from XMl.
//        roomsNodeList = parser.readXMLFiles(dungeonXMLPath, "room");
//        // Block level Fields.
//        int numOfRooms = roomsNodeList.getLength();
//        Element eElement;
//        String adjacentRoom;
//        int len;
//        String roomDescription;
//        String roomName;
//        String direction;
//        Node node;
//        List<String> roomLeadTo;
//        List<String> roomExitTo;
//        // Map<List<String>, List<String>> routesMap = new HashMap();
//        List<Map> listOfMap = new ArrayList<>();
//
//        // iterate and instantiate all rooms
//        for ( int i = 0; i < numOfRooms; i++ ){
//            node =  roomsNodeList.item(i); // return XML for a single room at index 'i'.
//            roomLeadTo = new ArrayList<>(); // provide a new list for connected room name each iteration.
//            roomExitTo = new ArrayList<>(); // provide a new list for exits each iteration.
//            Map<String, String> innerMap = new HashMap<>();
//
//            if (node.getNodeType() == Node.ELEMENT_NODE){
//                eElement = (Element) node;
//                roomName = eElement.getElementsByTagName("roomName").item(0).getTextContent();
//                roomDescription = eElement.getElementsByTagName("roomFeature").item(0).getTextContent();
//                len = eElement.getElementsByTagName("roomleadTo").getLength();
//                for (int x = 0; x < len; x++) {
//                    adjacentRoom = eElement.getElementsByTagName("roomleadTo").item(x).getTextContent();
//                    roomLeadTo.add(x, adjacentRoom);
//                    direction = eElement.getElementsByTagName("exit").item(x).getTextContent();
//                    roomExitTo.add(x, direction);
//                    innerMap.put(direction, adjacentRoom);
//                    listOfMap.add(x,innerMap);
//                }
//                // instantiate room and populate room to roomList.
//                roomList.add(i, new Room((i+1), roomName, roomDescription, roomLeadTo, roomExitTo));
//                //routesMap.put(roomExitTo,roomLeadTo);
//            }
//        }
//        //return routesMap;
//        return listOfMap;
//    }


}
