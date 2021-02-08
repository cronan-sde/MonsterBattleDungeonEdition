package com.objectivemonsters.storylines;

import com.objectivemonsters.util.TextParser;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class BattleTextList {

    TextParser tp = new TextParser();

// Generate a map of the battle text HITS from xml
    public List<String> battleTextHit() {
        List<String> hitLIst = new ArrayList<>();
        NodeList battleHitsNod = tp.readXMLFiles("resources/battleTextHit.xml", "battleHits");

        // iterate through the node list to extract each monster and store it in a list
        for (int i = 0; i < battleHitsNod.getLength(); i++) {
            // initalize a new node based on index
            Node nod = battleHitsNod.item(i);
            //check if type is an element
            if (nod.getNodeType() == Node.ELEMENT_NODE) {
                // set new element to case node
                Element eElement = (Element) nod;
                // add to string list
                hitLIst.add(eElement.getElementsByTagName("hit1").item(0).getTextContent());
                hitLIst.add(eElement.getElementsByTagName("hit2").item(0).getTextContent());
                hitLIst.add(eElement.getElementsByTagName("hit3").item(0).getTextContent());
            }
        }
        return hitLIst;
    }

    // Generate a list of the battle text MISS from xml
        public List<String> battleTextMiss() {
        List<String> missList = new ArrayList<>();
            NodeList battleMissNod = tp.readXMLFiles("resources/battleTextHit.xml", "battleHits");

            // iterate through the node list to extract each monster and store it in a list
            for (int i = 0; i < battleMissNod.getLength(); i++) {
                // initalize a new node based on index
                Node nod = battleMissNod.item(i);
                //check if type is an element
                if (nod.getNodeType() == Node.ELEMENT_NODE) {
                    // set new element to case node
                    Element eElement = (Element) nod;
                    // add to string list
                    missList.add(eElement.getElementsByTagName("miss1").item(0).getTextContent());
                    missList.add(eElement.getElementsByTagName("miss2").item(0).getTextContent());
                    missList.add(eElement.getElementsByTagName("miss3").item(0).getTextContent());
                }
            }
            return missList;
        }

}
