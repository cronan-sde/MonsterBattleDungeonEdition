package com.objectivemonsters.monsters;

import com.objectivemonsters.util.TextParser;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class MonsterLocationsList {

    // TODO: figure out why this is failing the test - likely b/c doesn't work but why

    public List<String> friendlyMonsterLocations = new ArrayList<>();
    public List<String> angryMonsterLocations = new ArrayList<>();
    TextParser tp = new TextParser();

    // Locate a monster in the room (from XML) Friendly
    public List<String> friendlyLocations() {
        NodeList friendLocal = tp.readXMLFiles("resources/friendlyMonLocation.xml", "friendlyLocation");
        List<String> localList = new ArrayList<>();

        // iterate through the node list to extract each nonster and store it in a list
        for (int i = 0; i < friendLocal.getLength(); i++) {
            // initalize a new node based on index
            Node nod = friendLocal.item(0);
            //check if type is an element
            if (nod.getNodeType() == Node.ELEMENT_NODE) {
                // set new element to cast node
                Element eElement = (Element) nod;
                // add to string list
                localList.add(eElement.getElementsByTagName("local1").item(0).getTextContent());
                localList.add(eElement.getElementsByTagName("local2").item(0).getTextContent());
                localList.add(eElement.getElementsByTagName("local3").item(0).getTextContent());
                localList.add(eElement.getElementsByTagName("local4").item(0).getTextContent());
                localList.add(eElement.getElementsByTagName("local5").item(0).getTextContent());
            }
        }
        return localList;
    }

    // Locate a monster in the room (from XML) Friendly
    public List<String> angryLocations() {
        NodeList angryLocal = tp.readXMLFiles("resources/angryMonsterLocation.xml", "angryLocation");
        List<String> localList2 = new ArrayList<>();

        // iterate through the node list to extract each nonster and store it in a list
        for (int i = 0; i < angryLocal.getLength(); i++) {
            // initalize a new node based on index
            Node nod = angryLocal.item(0);
            //check if type is an element
            if (nod.getNodeType() == Node.ELEMENT_NODE) {
                // set new element to case node
                Element eElement = (Element) nod;
                // add to string list
                localList2.add(eElement.getElementsByTagName("local1").item(0).getTextContent());
                localList2.add(eElement.getElementsByTagName("local2").item(0).getTextContent());
                localList2.add(eElement.getElementsByTagName("local3").item(0).getTextContent());
                localList2.add(eElement.getElementsByTagName("local4").item(0).getTextContent());
            }
        }
        return localList2;
    }

    public List<String> getFriendlyMonsterLocations() {
        return friendlyMonsterLocations;
    }

    public void setFriendlyMonsterLocations(List<String> friendlyMonsterLocations) {
        this.friendlyMonsterLocations = friendlyMonsterLocations;
    }

    public List<String> getAngryMonsterLocations() {
        return angryMonsterLocations;
    }

    public void setAngryMonsterLocations(List<String> angryMonsterLocations) {
        this.angryMonsterLocations = angryMonsterLocations;
    }

    @Override
    public String toString() {
        return "MonsterLocationsList{" +
                "friendlyMonsterLocations=" + friendlyMonsterLocations +
                ", angryMonsterLocations=" + angryMonsterLocations +
                '}';
    }
}
