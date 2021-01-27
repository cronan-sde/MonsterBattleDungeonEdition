package com.objectivemonsters.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class TextParser {

    // xml parser, pass in desired file to parse

    public void  monsterXML() {
        String fileName = "resources/monster.xml";
        readXMLFiles(fileName);
    }

    public void readXMLFiles(String textDoc){

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File inputFile = new File(textDoc);
            Document doc = db.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("monster");
            for(int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("\nNode Name: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    System.out.println("Name: " + eElement.getElementsByTagName("name").item(0).getTextContent());
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}