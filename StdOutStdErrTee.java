/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: StdOutStdErrTee.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public final class StdOutStdErrTee {
    private PrintStream originalOut;
    private PrintStream originalErr;
    private TeeOutputStream teeOut;
    private TeeOutputStream teeErr;

    private static class TeeOutputStream extends OutputStream {
        private final OutputStream stream1;
        private final OutputStream stream2;

        public TeeOutputStream(OutputStream stream1, OutputStream stream2) {
            this.stream1 = stream1;
            this.stream2 = stream2;
        }

        @Override
        public void write(int b) throws IOException {
            stream1.write(b);
            stream2.write(b);
        }

        @Override
        public void flush() throws IOException {
            stream1.flush();
            stream2.flush();
        }

        @Override
        public void close() throws IOException {
            try (stream1; stream2) {
                // Try-with-resources ensures both streams are closed
            }
        }
    }

    public void startLog() {
        originalOut = System.out;
        originalErr = System.err;
        try {
            new Directory(); // Ensures log directory exists

            FileOutputStream stdOutFile = new FileOutputStream(Config.getDefaultStdOutFilePath());
            teeOut = new TeeOutputStream(originalOut, stdOutFile);
            System.setOut(new PrintStream(teeOut, true));

            FileOutputStream stdErrFile = new FileOutputStream(Config.getDefaultStdErrFilePath());
            teeErr = new TeeOutputStream(originalErr, stdErrFile);
            System.setErr(new PrintStream(teeErr, true));
        } catch (IOException e) {
            originalErr.println("FATAL: Could not open log files. Exiting.");
            e.printStackTrace(originalErr);
            System.exit(1);
        }
    }

    public void stopLog() {
        if (originalOut != null) {
            System.out.flush();
            System.setOut(originalOut);
        }
        if (originalErr != null) {
            System.err.flush();
            System.setErr(originalErr);
        }
        try {
            if (teeOut != null) teeOut.close();
            if (teeErr != null) teeErr.close();
        } catch (IOException e) {
            originalErr.println("Error closing log file streams: " + e.getMessage());
        }
    }

    public String getStdOutFilePath() {
        return Config.getDefaultStdOutFilePath().replace('\\', '/');
    }

    public String getStdErrFilePath() {
        return Config.getDefaultStdErrFilePath().replace('\\', '/');
    }
}