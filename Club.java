/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Club.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"


public final class Club extends Organization {
    private final String name;
    private static final String OFFICIAL_SONG = "Take me out to the Ball Game";

    public Club(String name) {
        this.name = name;
    }

    public static String getOfficialSong() {
        return OFFICIAL_SONG;
    }

    @Override
    public void displayAbout() {
        System.out.printf("%-24s%s\n", "Club:", this.name);
        System.out.printf("%-24s%s\n", "Short Name:", "SF Giants");
        System.out.printf("%-24s%s\n", "Established in:", 1883);
        System.out.printf("%-24s%s\n", "Colors:", "Orange, Black, Gold, Cream");
        System.out.printf("%-24s%s\n", "Ballpark:", "Oracle Park");
        System.out.printf("%-24s%s\n", "World Series Titles:", 8);
        System.out.printf("%-24s%s\n", "NL Pennants:", 23);
        System.out.printf("%-24s%s\n", "Division Titles:", 8);
        System.out.printf("%-24s%s\n", "Wild Card Berths:", 3);
        System.out.printf("%-24s%s\n", "Owners:", "San Francisco Baseball Associates LLC");
        System.out.printf("%-24s%s\n", "President:", "Farhan Zaidi");
        System.out.printf("%-24s%s\n", "General Manager:", "Scott Harris");
        System.out.printf("%-24s%s\n", "Manager:", "Gabe Kapler");
    }

    @Override
    public void displayMission() {
    }
}