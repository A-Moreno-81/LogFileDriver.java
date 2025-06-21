/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Card.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"


public final class Card {
    private final String recipient;
    private final char artSymbol;
    private final String message;
    private int artSize = 12;
    private String artFont = "Courier";

    public Card(String recipient, char artSymbol, String message) {
        this.recipient = recipient;
        this.artSymbol = artSymbol;
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public char getArtSymbol() {
        return artSymbol;
    }

    public String getMessage() {
        return message;
    }

    public int getArtSize() {
        return artSize;
    }

    public String getArtFont() {
        return artFont;
    }
}


