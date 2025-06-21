/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Receipt.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public final class Receipt {
    private final Student student;
    private final Player player;
    private final University university;
    private final List<Card> orderedCards;
    private final Timer timer;
    private final boolean passedQuiz;

    public Receipt(Student student, Player player, University university, List<Card> orderedCards, Timer timer, boolean passedQuiz) {
        this.student = student;
        this.player = player;
        this.university = university;
        this.orderedCards = orderedCards;
        this.timer = timer;
        this.passedQuiz = passedQuiz;
    }

    public void generateReceiptFile() {
        String fileName = String.format("%sReceipt-%S-%S-%s.log",
                Config.getDefaultLogDirectoryPath(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail());

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("------------------------- SF GIANTS THANK YOU -------------------------");
            writer.println("                                         powered by CSC 220 @ SFSU");
            writer.println();
            writer.println(timer.getReceiptTimestamp(true) + " - Transaction started.");
            writer.println();
            writer.printf("%S, %d | %S\n", player.getFirstName() + " " + player.getLastName(), player.getJerseyNumber(), player.getClub());
            writer.printf("%S, %s | %S\n", student.getFirstName() + " " + student.getLastName(), student.getEmail(), university.getUniversityName());
            writer.println();
            writer.println(orderedCards.size());
            writer.println("-".repeat(73));
            for (Card card : orderedCards) {
                writer.println(card.getRecipient());
                writer.println(card.getArtSymbol());
                writer.println();
                writer.println(card.getMessage());
                writer.println("-".repeat(73));
            }
            if (this.passedQuiz) {
                writer.println("*** PASSED quiz. Got FREE TICKETS. ***");
                writer.println("-".repeat(73));
            }
            writer.println(timer.getReceiptTimestamp(false) + " - Transaction ended.");
        } catch (IOException e) {
            System.err.println("Error: Could not write receipt file to " + fileName);
        }
    }
}