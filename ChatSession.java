/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: ChatSession.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class ChatSession {
    private static final Scanner scanner = new Scanner(System.in);
    private final Club club;
    private final University university;
    private final Timer timer;
    private final Language language;
    private Student student;
    private Player player;

    public ChatSession(Club club, University university) {
        this.club = club;
        this.university = university;
        this.timer = Messenger.getConfig().getTimer();
        this.language = Messenger.getConfig().getLanguage();
    }

    public void runChatSession() {
        startChatSession();
        connectChatters();
        chat();
        stopChatSession();
    }


    private void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void startChatSession() {
        this.timer.start();
        pause(2000);
        System.out.println("SF Giants: " + language.getChatPhrase(0));
        pause(2000);
        System.out.println("-".repeat(70));
        this.club.displayAbout();
        System.out.println("-".repeat(70));
        pause(2000);
    }

    private void connectChatters() {
        System.out.print("SF Giants: " + language.getChatPhrase(1));
        String[] name = scanner.nextLine().split(" ", 2);
        System.out.print("SF Giants: " + language.getChatPhrase(2));
        String email = scanner.nextLine();
        this.student = new Student(name[0], name[1], email);

        pause(2000);
        student.sayGreeting(language.getChatPhrase(3));
        pause(2000);
        System.out.println("-".repeat(70));
        this.university.displayAbout();
        System.out.println("-".repeat(70));
        pause(2000);

        System.out.println("SF Giants: " + language.getChatPhrase(4));
        pause(2500);
        System.out.println(". . . . .");
        pause(2500);
        System.out.println("-".repeat(70));
        this.player = new Player("Buster", "Posey", "San Francisco Giants", "Catcher", 28, "Right", "Right", 2009);
        player.displayInfo();
        System.out.println("-".repeat(70));
        pause(2000);
    }

    private void chat() {
        player.sayGreeting(MessageFormat.format(language.getChatPhrase(5), student.getFirstName()));
        pause(2500);
        student.sayGreeting(MessageFormat.format(language.getChatPhrase(6), player.getFirstName()));
        pause(2500);
        player.sayGreeting(MessageFormat.format(language.getChatPhrase(7), student.getFirstName()));
        pause(2500);
        student.sayGreeting(MessageFormat.format(language.getChatPhrase(8), player.getFirstName()));
        pause(2500);
        player.sayGreeting(MessageFormat.format(language.getChatPhrase(9), student.getFirstName()));
        pause(2000);




        player.sayGreeting(language.getChatPhrase(10));
        pause(1000);
        System.out.print(Color.sfsuColors(student.getFirstName() + " " + student.getLastName() + ": "));
        int numCards = Integer.parseInt(scanner.nextLine());
        List<Card> cards = new ArrayList<>();
        pause(1000);
        player.sayGreeting(language.getChatPhrase(11));
        pause(1000);

        for (int i = 0; i < numCards; i++) {
            player.sayGreeting(MessageFormat.format(language.getChatPhrase(12), i + 1));
            String prompt = student.getFirstName() + " " + student.getLastName() + ":";
            System.out.print(Color.sfsuColors(prompt) + " [1] ");
            String recipient = scanner.nextLine();
            System.out.print(Color.sfsuColors(prompt) + " [2] ");
            char artSymbol = scanner.nextLine().charAt(0);
            System.out.print(Color.sfsuColors(prompt) + " [3] ");
            String message = scanner.nextLine();
            cards.add(new Card(recipient, artSymbol, message));
            pause(500);
        }

        player.sayGreeting(MessageFormat.format(language.getChatPhrase(13), student.getFirstName()));
        pause(2000);


        try {
            for (Card card : cards) {
                SFGiantsCardGenerator.generateSFGiantsCard(
                        card.getRecipient(), card.getMessage(), student.getFirstName(),
                        student.getEmail(), card.getArtSymbol(), card.getArtSize(), card.getArtFont());
                pause(2000);
            }
        } catch (Exception e) {
            System.err.println("Error generating ASCII art card: " + e.getMessage());
        }
        boolean passedQuiz = runQuiz();
        pause(2000);

        Receipt receipt = new Receipt(this.student, this.player, this.university, cards, this.timer, passedQuiz);
        receipt.generateReceiptFile();
    }

    private boolean runQuiz() {
        Quiz quiz = new Quiz();
        return quiz.run(scanner, "SF Giants", student.getFirstName() + " " + student.getLastName());
    }

    private void stopChatSession() {
        timer.stop();
    }
}