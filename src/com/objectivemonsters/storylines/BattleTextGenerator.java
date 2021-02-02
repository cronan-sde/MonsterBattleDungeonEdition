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
// TODO: optimize to read XMLs at startup and store for later
List<String> hits = new ArrayList<>();
List<String> miss = new ArrayList<>();
HashMap<String, String> battleText = new HashMap<>();

// Generate a map of the battle text HITS from xml
    public List<String> battleTextHit() {
        NodeList battleNod = tp.readXMLFiles("resources/battleTextHit.xml", "battleHits");

        // iterate through the node list to extract each nonster and store it in a list
        for (int i = 0; i < battleNod.getLength(); i++) {
            // initalize a new node based on index
            Node nod = battleNod.item(i);
            //check if type is an element
//            if (nod.getNodeType() == Node.ELEMENT_NODE) {
                // set new element to case node
                Element eElement = (Element) nod;
                // add to string list
                hits.add(eElement.getElementsByTagName("hit1").item(0).getTextContent());
                hits.add(eElement.getElementsByTagName("hit2").item(0).getTextContent());
                hits.add(eElement.getElementsByTagName("hit3").item(0).getTextContent());
        }
        return hits;
    }

    // return one random HIT text line
    public String oneHit(){
        String hitText = "";
        List<String> local = new ArrayList<>();
        local = battleTextHit();

        int rando = (int)((Math.random() * local.size()));
        System.out.println(rando);

        for (int j = 0; j < local.size(); j++) {
            if (j == rando) {
                hitText = local.get(j);
            }
        }
        return hitText;
    }

    // Generate a map of the battle text HITS from xml
    public List<String> battleTextMiss() {
        NodeList battleNod = tp.readXMLFiles("resources/battleTextMiss.xml", "battleMiss");

        // iterate through the node list to extract each nonster and store it in a list
        for (int i = 0; i < battleNod.getLength(); i++) {
            // initalize a new node based on index
            Node nod = battleNod.item(i);
            //check if type is an element
//            if (nod.getNodeType() == Node.ELEMENT_NODE) {
            // set new element to case node
            Element eElement = (Element) nod;
            // add to string list
            miss.add(eElement.getElementsByTagName("miss1").item(0).getTextContent());
            miss.add(eElement.getElementsByTagName("miss2").item(0).getTextContent());
            miss.add(eElement.getElementsByTagName("miss3").item(0).getTextContent());
        }
        return miss;
    }
    // return one random MISS text
    public String oneMiss(){
        String missText = "";
        List<String> local = new ArrayList<>();
        local = battleTextMiss();

        int rando = (int)((Math.random() * local.size()));
        System.out.println(rando);

        for (int j = 0; j < local.size(); j++) {
            if (j == rando) {
                missText = local.get(j);
            }
        }
        return missText;
    }

}
