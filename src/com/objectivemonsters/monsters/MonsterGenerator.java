package com.objectivemonsters.monsters;

import com.objectivemonsters.util.TextParser;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;


public class MonsterGenerator {
    List<Monster> monsters = new ArrayList<>();
    TextParser tp = new TextParser();

    // Generate a list of monsters from xml
    public List<Monster> allMonsters() {
        /* pass in the file link and node name in call on textParser to return a node list of monsters */
        NodeList monsNod = tp.readXMLFiles("resources/monster.xml", "monster");

        // iterate through the node list to extract each monster adn store in a object list of monsters
        for (int i = 0; i < monsNod.getLength(); i++) {
            // initialize a new node based on index
            Node nod = monsNod.item(i);
            // check if type is an element
            if (nod.getNodeType() == Node.ELEMENT_NODE) {
                // set new element to cast node
                Element eElement = (Element) nod;
                // new temporary monster
                Monster monty = new Monster();

                // set the temp monster to xml values in iteration
                // item is zero it is the nod that increments
                monty.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                // casting to retrieve boolean from string
                monty.setFriendly(Boolean.parseBoolean(eElement.getElementsByTagName("friendly").item(0).getTextContent()));
                // casting to retrieve int from string
                monty.setHP(Integer.parseInt(eElement.getElementsByTagName("HP").item(0).getTextContent()));
                monty.setStrength(Integer.parseInt(eElement.getElementsByTagName("intellect").item(0).getTextContent()));
                monty.setIntellect(Integer.parseInt(eElement.getElementsByTagName("intellect").item(0).getTextContent()));
                monty.setAgility(Integer.parseInt(eElement.getElementsByTagName("agility").item(0).getTextContent()));
                monty.setDesc(eElement.getElementsByTagName("description").item(0).getTextContent());

                // add each monster to monster list
                monsters.add(monty);
            }
        }
        // return the newly stocked list of monsters
        return monsters;
    }

    // Generate a list of Angry Monsters
    public List<Monster> aMonsters(List<Monster> localMonster) {
        List<Monster> angryMonsters = new ArrayList<>();
        for (Monster mon : localMonster) {
            if (mon.isFriendly() == false) {
                angryMonsters.add(mon);
            }
        }
        return angryMonsters;
    }

    // Generate a list of Friendly Monsters
    public List<Monster> fMonsters(List<Monster> localMonster) {
        List<Monster> friendlyMonsters = new ArrayList<>();
        for (Monster mon : localMonster) {
            if (mon.isFriendly() == true) {
                friendlyMonsters.add(mon);
            }
        }
        return friendlyMonsters;
    }

    // Return one Random Monster
    public Monster randoMon(List<Monster> ranMons) {

        Monster monty = new Monster();
        int rando = (int)((Math.random() * ranMons.size()) + 1);

        for (int j = 0; j < ranMons.size(); j++) {
            if (j == rando) {
                monty = ranMons.get(j);
            }
        }
        return monty;
    }

    // Morph a dead Angry monster to a Friendly monster

    // Locate a monster in the room (from XML) Angry

    // Locate a monster in the room (from XML) Friendly


}
