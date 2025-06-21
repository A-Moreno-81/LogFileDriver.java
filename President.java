/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: President.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class President extends Person {

    //
    // Instance Data Fields
    //
    private String title;

    //
    // Constructors
    //
    public President() {
    }

    public President(String firstName, String lastName, String title) {
        super(firstName, lastName);
        this.title = title;
    }

    //
    // Instance Methods
    //

    //
    // Language
    //

    //
    // Override
    //
    @Override
    public void sayGreeting(String greeting) {
    }
}
