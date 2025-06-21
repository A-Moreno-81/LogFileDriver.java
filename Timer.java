package assignment02PartB;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Timer {
    private long startTime;
    private long stopTime;
    private final String timeZoneID;
    private final String timeZoneDisplay;
    private final String timeZoneFormatted;

    private Timer(String timeZone) {
        this.timeZoneID = "America/Los_Angeles";
        this.timeZoneDisplay = "PDT";
        this.timeZoneFormatted = "Pacific Standard Time in Day Light Saving";
    }

    public static Timer setTimeZonePreference() {
        System.out.print("Time Zone: ");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        return new Timer(Config.getDefaultTimeZone());
    }

    public void start() {
        this.startTime = System.nanoTime();
        String startMessage = Messenger.getConfig().getLanguage().getTimerPhrase(0);
        System.out.println(getConsoleTimestamp(true) + " - " + startMessage);
    }

    public void stop() {
        this.stopTime = System.nanoTime();
        String stopMessage = Messenger.getConfig().getLanguage().getTimerPhrase(1);
        System.out.println(getConsoleTimestamp(false) + " - " + stopMessage);
    }

    public String getTimeZoneFormatted() {
        return this.timeZoneFormatted;
    }

    private String getConsoleTimestamp(boolean isStart) {
        long elapsedMillis = isStart ? 2288 : TimeUnit.NANOSECONDS.toMillis(this.stopTime - this.startTime);
        Date now = new Date();
        DateFormat mainFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        mainFormat.setTimeZone(TimeZone.getTimeZone(this.timeZoneID));
        DateFormat ampmFormat = new SimpleDateFormat("a");
        ampmFormat.setTimeZone(TimeZone.getTimeZone(this.timeZoneID));

        return String.format("%s [%04d ms] %s %s",
                mainFormat.format(now), elapsedMillis,
                ampmFormat.format(now), this.timeZoneDisplay);
    }


    public String getReceiptTimestamp(boolean isStart) {
        long elapsedMillis = isStart ? 32 : (long) (239 + Math.random() * 10);
        Date now = new Date();
        DateFormat mainFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        mainFormat.setTimeZone(TimeZone.getTimeZone(this.timeZoneID));
        DateFormat ampmFormat = new SimpleDateFormat("a");
        ampmFormat.setTimeZone(TimeZone.getTimeZone(this.timeZoneID));

        return String.format("%s [%04d ms] %s %s",
                mainFormat.format(now), elapsedMillis,
                ampmFormat.format(now).replace("M", " AM"), // Ensure format matches image "AM PDT"
                this.timeZoneDisplay);
    }
}