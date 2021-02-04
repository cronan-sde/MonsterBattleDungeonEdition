package com.objectivemonsters.monsters;

import com.objectivemonsters.util.TextParser;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class MonsterLocationsList {

    private List<String> friendlyMonsterLocations = new ArrayList<>();
    private List<String> angryMonsterLocations = new ArrayList<>();
    TextParser tp;

    // Locate a monster in the room (from XML) Friendly
    private List<String> friendlyLocations() {
        NodeList friendLocal = tp.readXMLFiles("resources/friendlyMonLocation.xml", "friendlyLocation");

        // iterate through the node list to extract each nonster and store it in a list
        for (int i = 0; i < friendLocal.getLength(); i++) {
            // initalize a new node based on index
            Node nod = friendLocal.item(i);
            //check if type is an element
            if (nod.getNodeType() == Node.ELEMENT_NODE) {
                // set new element to case node
                Element eElement = (Element) nod;
                // add to string list
                friendlyMonsterLocations.add(eElement.getElementsByTagName("local1").item(0).getTextContent());
                friendlyMonsterLocations.add(eElement.getElementsByTagName("local2").item(0).getTextContent());
                friendlyMonsterLocations.add(eElement.getElementsByTagName("local3").item(0).getTextContent());
                friendlyMonsterLocations.add(eElement.getElementsByTagName("local4").item(0).getTextContent());
                friendlyMonsterLocations.add(eElement.getElementsByTagName("local5").item(0).getTextContent());
            }
        }
        return friendlyMonsterLocations;
    }

    // Locate a monster in the room (from XML) Friendly
    private List<String> angryLocations() {
        NodeList angryLocal = tp.readXMLFiles("resources/angryMonsterLocation.xml", "angryLocation");

        // iterate through the node list to extract each nonster and store it in a list
        for (int i = 0; i < angryLocal.getLength(); i++) {
            // initalize a new node based on index
            Node nod = angryLocal.item(i);
            //check if type is an element
            if (nod.getNodeType() == Node.ELEMENT_NODE) {
                // set new element to case node
                Element eElement = (Element) nod;
                // add to string list
                angryMonsterLocations.add(eElement.getElementsByTagName("local1").item(0).getTextContent());
                angryMonsterLocations.add(eElement.getElementsByTagName("local2").item(0).getTextContent());
                angryMonsterLocations.add(eElement.getElementsByTagName("local3").item(0).getTextContent());
                angryMonsterLocations.add(eElement.getElementsByTagName("local4").item(0).getTextContent());
                angryMonsterLocations.add(eElement.getElementsByTagName("local5").item(0).getTextContent());
            }
        }
        return angryMonsterLocations;
    }

    public List<String> getFriendlyMonsterLocations() {
        return friendlyMonsterLocations;
    }

    public List<String> getAngryMonsterLocations() {
        return angryMonsterLocations;
    }

    private void setFriendlyMonsterLocations(List<String> friendlyMonsterLocations) {
        this.friendlyMonsterLocations = friendlyLocations();
    }

    private void setAngryMonsterLocations(List<String> angryMonsterLocations) {
        this.angryMonsterLocations = angryLocations();
    }

    @Override
    public String toString() {
        return "MonsterLocationsList{" +
                "friendlyMonsterLocations=" + friendlyMonsterLocations +
                ", angryMonsterLocations=" + angryMonsterLocations +
                '}';
    }
}
