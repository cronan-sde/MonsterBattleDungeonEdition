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

    // call and pass in the XML doc and node name to return a node list of the xml 
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
