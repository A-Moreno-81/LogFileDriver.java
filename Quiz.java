/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Quiz.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Quiz {
    private final List<QuestionAnswer> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
        populateQuestions();
    }

    public boolean run(Scanner scanner, String prompter, String studentName) {
        String introMessage = Messenger.getConfig().getLanguage().getQuizPhrase(0);
        System.out.println(prompter + ": " + introMessage);
        boolean allCorrect = true;

        for (QuestionAnswer qa : questions) {
            System.out.println(prompter + ": " + qa.getQuestion());
            System.out.print(Color.sfsuColors(studentName + ": "));
            String userAnswer = scanner.nextLine();
            if (userAnswer.equalsIgnoreCase(qa.getAnswer())) {
                System.out.println(prompter + ": Correct!");
            } else {
                System.out.println(prompter + ": Incorrect!");
                allCorrect = false;
            }
        }
        System.out.println("*** Congrats! You won FREE TICKETS to SF GIANTS Games ***");
        return allCorrect;
    }

    private void populateQuestions() {
        questions.add(new QuestionAnswer("Which type of class has 'protected' constructors?", "abstract"));
        questions.add(new QuestionAnswer("What type of method did Java 8 add to 'interface'?", "default"));
        questions.add(new QuestionAnswer("What new keyword did Java 13 add to 'switch' statement?", "yield"));
        questions.add(new QuestionAnswer("In Java 15, what keyword pairs with 'sealed'?", "permits"));
        questions.add(new QuestionAnswer("Giants in Spanish?", "Gigantes"));
        questions.add(new QuestionAnswer("Take me out to the...?", "Ball Game"));
    }
}