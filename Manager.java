/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Manager.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Manager extends Person {

    //
    // Instance Data Fields
    //
    private String title;

    //
    // Constructors
    //
    public Manager() {
    }

    public Manager(String firstName, String lastName, String title) {
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