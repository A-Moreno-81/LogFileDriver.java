/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Language.java
 * @author: Duc Ta
 * @author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

// java.util.ResourceBundle
// - ResourceBundle is a valid approach to internationalization.
// - ResourceBundle is not required.
// - Other approaches to internationalization are available. Some of these approaches are
// more straightforward and more relevant to new CSC 220 students then ResourceBundle is.
// - Yet, curiosity for intelligence is always highly encouraged:
// https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/ResourceBundle.html


import java.util.Scanner;

public final class Language {
    private static final String defaultAlienSound = "~ ąļīæń ~ ";
    private String language;
    private String[] configPhrases;
    private String[] clubPhrases;
    private String[] universityPhrases;
    private String[] greetingPhrases;
    private String[] timerPhrases;
    private String[] chatPhrases;
    private String[] quizPhrases;

    public Language() {
        this.populateEnglishPhrases();
    }

    public Language(String language) {
        switch (language.toLowerCase()) {
            case "alien" -> this.populateAlienPhrases();
            case "chinese" -> this.populateChinesePhrases();
            case "french" -> this.populateFrenchPhrases();
            case "spanish" -> this.populateSpanishPhrases();
            case "future" -> this.populateYourLanguagePhrases();
            default -> this.populateEnglishPhrases();
        }
    }

    public static void displayAppHeader() {
        System.out.println(Config.getOfficialAppHeader());
    }

    public static Language setLanguagePreference() {
        System.out.print("Language: ");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        return new Language(choice);
    }

    private void populateEnglishPhrases() {
        this.language = "ENGLISH";
        this.configPhrases = new String[]{
                "-".repeat(70), "Language:", "Time Zone:", "Color Sequences:",
                "Standard Output Log:", "Standard Error Log:", "Receipt Log:",
                "Receipt-*-*.log", "Default University:", "Default Club:"
        };
        this.clubPhrases = new String[]{"San Francisco Giants"};
        this.universityPhrases = new String[]{"San Francisco State University"};
        this.greetingPhrases = new String[]{"Hello"};
        this.timerPhrases = new String[]{"Chat session started.", "Chat session ended."};
        this.chatPhrases = new String[]{
                "Welcome to the SAN FRANCISCO GIANTS!", "Your first name and last name, please: ",
                "Your school email address, please: ", "Welcome to my university!",
                "Thank you. We are connecting you with our player...", "Hello {0}. C-O-N-G-R-A-T-U-L-A-T-I-O-N-S!",
                "Thank you, {0}! Nice to e-meet you here!", "Likewise, {0}. Very nice chatting w/ you.",
                "Very nice! Thank you, {0}.", "Thank you again, {0}. See you at your graduation ceremony!",
                "How many SF Giants Thank You cards would you like to order?",
                "In 3 lines, please provide\n[1] Recipient name\n[2] Art symbol (a character)\n[3] Message to recipient",
                "Card #{0}:", "Thanks, {0}. Please confirm your order:"
        };
        this.quizPhrases = new String[]{"*** FREE TICKETS to SF GIANTS Games *** _1 miss allowed_"};
    }

    private void populateAlienPhrases() {
        this.language = "ALIEN";
        this.configPhrases = new String[10];
        for(int i = 0; i < configPhrases.length; i++) configPhrases[i] = defaultAlienSound;
        this.clubPhrases = new String[]{defaultAlienSound};
        this.universityPhrases = new String[]{defaultAlienSound};
        this.greetingPhrases = new String[]{defaultAlienSound};
        this.timerPhrases = new String[]{defaultAlienSound, defaultAlienSound};
        this.chatPhrases = new String[14];
        for(int i = 0; i < chatPhrases.length; i++) chatPhrases[i] = defaultAlienSound;
        this.quizPhrases = new String[]{defaultAlienSound};
    }

    private void populateChinesePhrases() { this.populateEnglishPhrases(); }
    private void populateFrenchPhrases() { this.populateEnglishPhrases(); }
    private void populateSpanishPhrases() { this.populateEnglishPhrases(); }
    private void populateYourLanguagePhrases() { this.populateEnglishPhrases(); }

    public String getLanguage() { return this.language; }
    public String getConfigPhrase(int i) { return this.configPhrases[i]; }
    public String getClubPhrase(int i) { return this.clubPhrases[i]; }
    public String getUniversityPhrase(int i) { return this.universityPhrases[i]; }
    public String getGreetingPhrase(int i) { return this.greetingPhrases[i]; }
    public String getTimerPhrase(int i) { return this.timerPhrases[i]; }
    public String getChatPhrase(int i) { return this.chatPhrases[i]; }
    public String getQuizPhrase(int i) { return this.quizPhrases[i]; }
}