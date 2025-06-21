/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Player.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;

public final class Player extends Person {
    private final String team;
    private final String position;
    private final int jerseyNumber;
    private final String bats;
    private final String throws_;
    private final int mlbDebut;

    public Player(String firstName, String lastName, String team, String position, int jerseyNumber, String bats, String throws_, int mlbDebut) {
        super(firstName, lastName);
        this.team = team;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.bats = bats;
        this.throws_ = throws_;
        this.mlbDebut = mlbDebut;
    }

    // Getters added for Receipt class
    public int getJerseyNumber() {
        return jerseyNumber;
    }
    public String getClub() {
        return team;
    }

    public void displayInfo() {
        System.out.printf("%-18s%s %s\n", "Player:", getFirstName(), getLastName());
        System.out.printf("%-18s%s\n", "Club:", this.team);
        System.out.printf("%-18s%s\n", "Position:", this.position);
        System.out.printf("%-18s%s\n", "Number:", this.jerseyNumber);
        System.out.printf("%-18s%s\n", "Bats:", this.bats);
        System.out.printf("%-18s%s\n", "Throws:", this.throws_);
        System.out.printf("%-18s%s\n", "MLB Debut:", this.mlbDebut);
    }

    @Override
    public void sayGreeting(String greeting) {
        System.out.println(getFirstName() + " " + getLastName() + ", " + this.jerseyNumber + ": " + greeting);
    }
}