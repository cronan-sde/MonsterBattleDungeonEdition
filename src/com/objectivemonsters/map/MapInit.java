package com.objectivemonsters.map;

import com.objectivemonsters.monsters.Monster;
import com.objectivemonsters.util.TextParser;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class MapInit {

    //private fields.
    TextParser parser = new TextParser();
    private Dungeon dungeon;
    private List<Room> roomList = new ArrayList<>();
    private NodeList roomsNodeList;
    private String dungeonXMLPath = "resources/dungeon.xml" ;

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
        Node node;
        List<String> roomLeadTo;

        // iterate and instantiate all rooms
        for ( int i = 0; i < numOfRooms; i++ ){
            node =  roomsNodeList.item(i); // return XML for a single room at index 'i'.
                roomLeadTo = new ArrayList<>(); // provide a new list each iteration.
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
}
