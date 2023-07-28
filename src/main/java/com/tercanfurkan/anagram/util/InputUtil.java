package com.tercanfurkan.anagram.util;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputUtil {
    public static List<String> waitAndGetTexts(Scanner input, PrintStream out) {
        return IntStream.of(1,2).mapToObj(counter -> {
            var text = "";
            while(text.isBlank()) {
                out.print("Enter a non-blank text #" + counter + ": ");
                text = input.nextLine();
            }
            return text;
        }).collect(Collectors.toList());
    }

    public static boolean waitAndGetTryAgain(Scanner input) {
        var tryAgain = input.nextLine();
        return "y".equals(tryAgain) || "Y".equals(tryAgain);
    }
}
