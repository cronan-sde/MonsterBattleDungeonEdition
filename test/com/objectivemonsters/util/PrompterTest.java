package com.objectivemonsters.util;

import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class PrompterTest {
    private Scanner scanner;
    private Prompter prompter;

    @After
    public void tearDown() {
        scanner.close();
    }

    @Test
    public void info_shouldPrintAndReturn_whenMessagePassedIn() throws IOException {
        //scanner only needed to create the prompter obj for this test
        scanner = new Scanner(new File("test_responses/responses.txt"));
        prompter = new Prompter(scanner);

        String expectedMessage = "Once upon a time in a galaxy far far away.";
        String actualResponse = prompter.info(expectedMessage);

        assertEquals(expectedMessage, actualResponse);
    }

    @Test
    public void prompt_returnsAnyResponse_whenOnlyPromptMessageParameterSupplied() throws IOException {
        String response = null;
        scanner = new Scanner(new File("test_responses/responses.txt"));
        prompter = new Prompter(scanner);

        response = prompter.prompt("Where would you like to move?");
        assertEquals("go north", response);

        response = prompter.prompt("What would you like to do?");
        assertEquals("open door", response);

        response = prompter.prompt("You see a friendly monster, what would you like to do?");
        assertEquals("inspect monster", response);

        response = prompter.prompt("There is an evil monster blocking your exit, what will you do?");
        assertEquals("fight monster", response);

    }

    @Test
    public void prompt_shouldReturnResponse_whenResponseIncludesValidVerbAndTwoTotalWords_andShouldPrintRetryMessageWhenInvalidEntry() throws IOException {
        String response = null;

        scanner = new Scanner(new File("test_responses/response-retry.txt"));
        prompter = new Prompter(scanner);

        String promptMessage = "What would you like to do?";
        List<String> validVerbs = List.of("GO", "OPEN", "INSPECT", "LOOK", "KEEP", "DROP", "FIGHT");
        String retryMessage = "Sorry, your response must include two words total and the first word must be a valid verb";

        //first response should return go north
        response = prompter.prompt(promptMessage, validVerbs, retryMessage);
        assertEquals("go north", response);

        //second response should return look around
        response = prompter.prompt(promptMessage, validVerbs, retryMessage);
        assertEquals("look around", response);

        //third response should return inspect room
        response = prompter.prompt(promptMessage, validVerbs, retryMessage);
        assertEquals("inspect room", response);

        //fourth response should not return, but print retry message
        //travel is not a valid verb, should then re-prompt user for input

        //fifth response should return fight monster
        response = prompter.prompt(promptMessage, validVerbs, retryMessage);
        assertEquals("fight monster", response);
    }
}