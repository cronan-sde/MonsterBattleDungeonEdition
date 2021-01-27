package com.objectivemonsters.util;

import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * General-purpose prompter that delegates to a {@code Scanner}, which
 * must be provided in the constructor.  The {@code Scanner} passed to the constructor
 * must be initialized by the client, and allows for console-based or file-based for testing.
 * </p>
 * <pre>
 * <code>
 *     // To use with a human user at the console:
 *     Prompter prompter = new Prompter(new Scanner(System.in));
 *
 *     // use for automated unit testing without human inputs:
 *     Prompter prompter = new Prompter(new Scanner(new File("inputs.txt")));
 * </code>
 * </pre>
 *
 * @author Cody Cronberger
 * @version 1.0
 */
public class Prompter {

    private Scanner scanner;

    /**
     * Creates a {@code Scanner}-based prompter object, that delegates to the {@code Scanner} for all input
     * @param scanner delegate object used by this prompter for reading input.
     */
    public Prompter(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Outputs provided text.  Simply calls {@code System.out.println(info)}.
     * @param messages Any informative text the game wishes to display to the user.
     */
    public void info(String messages) {
        System.out.println(messages);
    }

    /**
     * Prompts for input, and returns the line of text entered, as a string.
     * @param promptMessage prompt message to display to user.
     * @return the input provided from the user
     */
    public String prompt(String promptMessage) {
        System.out.print(promptMessage);
        return scanner.nextLine();
    }

    /**
     * <p>
     * Prompts for input, validates it against the list of acceptable words provided, and returns
     * the line of text entered, as a string.  If the first input does not match a word in provided list,
     * or the provided input is not two words, the error message text is displayed, and then the prompt text is displayed again.
     * </p>
     * <pre>
     * <code>
     *     prompter.prompt("What would you like to do?", ["GO", "OPEN", "Look"], "I'm sorry I don't understand those commands");
     * </code>
     * </pre>
     *
     * @param promptMessage prompt message.
     * @param acceptableVerbs List of verbs the game allows for use
     * @param retryMessage error message displayed when input string does not match regex pattern.
     * @return the line of text that was input, as a string.
     */
    public String prompt(String promptMessage, List<String> acceptableVerbs, String retryMessage) {
        String response = null;
        boolean isValidRes = false;

        while (!isValidRes) {
            System.out.println(promptMessage);
            response = scanner.nextLine().toLowerCase();
            String[] resArray = response.split(" ");
            for (String verb : acceptableVerbs) {
                if (resArray[0].equals(verb.toLowerCase()) && resArray.length == 2) {
                    isValidRes = true;
                    break;
                }
            }
            if (!isValidRes) {
                System.out.println(retryMessage);
            }
        }

        return response;
    }
}