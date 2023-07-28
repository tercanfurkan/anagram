package com.tercanfurkan.anagram.app;

import com.tercanfurkan.anagram.processor.HashedAnagramProcessor;
import com.tercanfurkan.anagram.processor.SortedAnagramProcessor;

public class Main {
    public static void main(String[] args) {
        var processor = new HashedAnagramProcessor();
        // var processor = new SortedAnagramProcessor();
        var anagramChecker = new AnagramCheckerCLI(System.in, System.out, processor);
        anagramChecker.run();
    }
}
