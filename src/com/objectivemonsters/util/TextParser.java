package com.objectivemonsters.util;

import com.objectivemonsters.monsters.Monster;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class TextParser {


    public NodeList  monsterXML() {
        String fileName = "resources/monster.xml";
        return readXMLFiles(fileName, "monster");
    }

    public void createMons() {
        NodeList monsNod = monsterXML();

        int numberMons = monsNod.getLength();

        int rando = (int) ((Math.random() * numberMons) + 1);
        System.out.println(rando);

        Node nod = monsNod.item(rando);
        if (nod.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) nod;
//            Monster monty = new Monster(); -- need to instatiate with all the constructor args
//            monty.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
//            monty.setDesc(eElement.getElementsByTagName("description").item(0).getTextContent());
//            System.out.println(monty);
        }
    }


    public NodeList readXMLFiles(String textDoc, String nodNam){

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File inputFile = new File(textDoc);
            Document doc = db.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName(nodNam);
            return nodeList;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
