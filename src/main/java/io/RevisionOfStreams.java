package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Revision of {@link java.io.InputStream} methods
 */
public class RevisionOfStreams {

    public static void main(String[] args) throws FileNotFoundException {
        new PrintWriter(new BufferedOutputStream(new FileOutputStream("")));
    }
}
