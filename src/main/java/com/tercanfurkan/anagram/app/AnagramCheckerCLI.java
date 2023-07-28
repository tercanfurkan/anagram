package com.tercanfurkan.anagram.app;

import com.tercanfurkan.anagram.processor.AnagramProcessor;
import com.tercanfurkan.anagram.processor.HashedAnagramProcessor;
import com.tercanfurkan.anagram.util.InputUtil;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class AnagramCheckerCLI {
    private final Scanner scanner;
    private final PrintStream out;
    private final AnagramProcessor processor;

    public AnagramCheckerCLI(InputStream in, PrintStream out, AnagramProcessor processor) {
        this.scanner = new Scanner(in);
        this.out = out;
        this.processor = processor;
    }

    public void run() {
        boolean repeat = true;
        do {
            var inputTexts = InputUtil.waitAndGetTexts(scanner, out);
            var isAnagram = processor.areAnagrams(inputTexts);
            out.println("\n>> Anagram: " + isAnagram);
            out.println("\nEnter (y/Y) to try again..\n");

            if (!InputUtil.waitAndGetTryAgain(scanner)) {
                repeat = false;
            }

        } while (repeat);
    }
}
