package com.natestgeorge.paperweight;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

/**
 * Copies the console output to a ByteArrayOutputStream.
 *
 * "Intercepted" from https://stackoverflow.com/a/30665299
 */
public class ConsoleOutputInterceptor {
    public ConsoleOutputInterceptor() {
        // Override System.out.println and inject our own event callback
        System.setOut(new PrintStream(System.out) {
            public void println(String s) {

                super.println(s);
            }
        });
    }

    public void addListener()

}
