/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Directory.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"


import java.io.File;

public final class Directory {
    private final String path;

    public Directory() {
        this.path = Config.getDefaultLogDirectoryPath();
        createDirectory();
    }

    private void createDirectory() {
        File dir = new File(this.path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public String getPath() {
        return this.path.replace('\\', '/');
    }
}