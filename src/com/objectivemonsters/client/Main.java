package com.objectivemonsters.client;

import com.objectivemonsters.util.TextParser;

public class Main {

    public static void main(String[] args) {
        TextParser tp = new TextParser();
        tp.monsterXML();
//        List<String> validVerbs = List.of("GO", "OPEN", "INSPECT", "LOOK", "KEEP", "DROP", "FIGHT");
//        Prompter prompter = new Prompter(new Scanner(System.in));
//        String response = prompter.prompt("Where would you like to go?", validVerbs, "That is not a valid command");
//        System.out.println("You have chosen to " + response);
    }
}
