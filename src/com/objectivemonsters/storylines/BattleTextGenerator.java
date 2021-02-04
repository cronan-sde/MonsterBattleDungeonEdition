package com.objectivemonsters.storylines;

import com.objectivemonsters.util.TextParser;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BattleTextGenerator {

    TextParser tp = new TextParser();
    private ArrayList<String> battleHits = new ArrayList<>();
    private ArrayList<String> battleMiss = new ArrayList<>();


// Generate a map of the battle text HITS from xml
    public ArrayList<String> battleTextHit() {
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
                battleHits.add(eElement.getElementsByTagName("hit1").item(0).getTextContent());
                battleHits.add(eElement.getElementsByTagName("hit2").item(0).getTextContent());
                battleHits.add(eElement.getElementsByTagName("hit3").item(0).getTextContent());
            }
        }
        return battleHits;
    }

    // Generate a list of the battle text MISS from xml
        public ArrayList<String> battleTextMiss() {
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
                    battleMiss.add(eElement.getElementsByTagName("miss1").item(0).getTextContent());
                    battleMiss.add(eElement.getElementsByTagName("miss2").item(0).getTextContent());
                    battleMiss.add(eElement.getElementsByTagName("miss3").item(0).getTextContent());
                }
            }
            return battleMiss;
        }



    public ArrayList<String> getBattleHits() {
        return battleHits;
    }

    private void setBattleHits(ArrayList<String> battleHits) {
        this.battleHits = battleTextHit();
    }

    public ArrayList<String> getBattleMiss() {
        return battleMiss;
    }

    private void setBattleMiss(ArrayList<String> battleMiss) {
        this.battleMiss = battleTextMiss();
    }
}
