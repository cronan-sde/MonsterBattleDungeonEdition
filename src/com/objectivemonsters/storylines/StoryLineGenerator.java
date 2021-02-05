package com.objectivemonsters.storylines;

import com.objectivemonsters.util.TextParser;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;

public class StoryLineGenerator {

    TextParser tp = new TextParser();
    HashMap<String, String> storyLines = new HashMap();

    public HashMap getStoryTxt() {
        NodeList stories = tp.readXMLFiles("resources/storyTxt.xml", "storyText");

        for (int i = 0; i < stories.getLength(); i++) {
            // initialize a new node
            Node nod = stories.item(i);
            if (nod.getNodeType() == Node.ELEMENT_NODE) {
                // set new element to cast node
                Element eElement = (Element) nod;

                storyLines.put("welcome", eElement.getElementsByTagName("welcome").item(0).getTextContent());
                storyLines.put("opening", eElement.getElementsByTagName("opening").item(0).getTextContent());
                storyLines.put("moreInfo", eElement.getElementsByTagName("moreInfo").item(0).getTextContent());
                storyLines.put("friendlyGesture", eElement.getElementsByTagName("friendlyGesture").item(0).getTextContent());
                storyLines.put("hint", eElement.getElementsByTagName("hint").item(0).getTextContent());
                storyLines.put("diretions", eElement.getElementsByTagName("diretions").item(0).getTextContent());
                storyLines.put("directionsMore", eElement.getElementsByTagName("directionsMore").item(0).getTextContent());
                storyLines.put("wordList", eElement.getElementsByTagName("wordList").item(0).getTextContent());

            }
        }
        return storyLines;
    }

}
