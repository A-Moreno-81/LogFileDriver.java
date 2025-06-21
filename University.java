/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: University.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;

public final class University extends Organization {
    private final String universityName;
    private static final String MOTTO_LATIN = "Experientia Docet";
    private static final String MOTTO_ENGLISH = "Experience Teaches";
    // ... other fields are unchanged

    public University(String name) {
        this.universityName = name;
    }


    public String getUniversityName() {
        return universityName;
    }

    @Override
    public void displayAbout() {
        System.out.printf("%-24s%s\n", "Official Name:", Color.sfsuColors(this.universityName));
        // ... rest of method is unchanged
        System.out.printf("%-24s%s\n", "Motto in Latin:", MOTTO_LATIN);
        System.out.printf("%-24s%s\n", "Motto in English:", MOTTO_ENGLISH);
        System.out.printf("%-24s%s\n", "Type:", "Public");
        System.out.printf("%-24s%s\n", "Year of Establishment:", 1899);
        System.out.printf("%-24s%s\n", "Location:", "San Francisco, California, United States");
        System.out.printf("%-24s%s\n", "Address:", "1600 Holloway Avenue, San Francisco, CA 94132");
        System.out.printf("%-24s%s\n", "Colors:", "Purple, Gold");
        System.out.printf("%-24s%s\n", "Nickname:", "Gators");
        System.out.printf("%-24s%s\n", "Mascot:", "Gator");
        System.out.printf("%-24s%s\n", "Website:", "www.sfsu.edu");
    }

    @Override
    public void displayMission() { /* Unchanged */ }
}