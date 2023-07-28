package com.tercanfurkan.anagram.processor;

import java.util.List;

public abstract class AnagramProcessorBase implements AnagramProcessor {

    /**
     * Takes a list of text, converts each text to their anagramKey representation,
     * finally checks whether if they are all identical or not.
     */
    public boolean areAnagrams(List<String> texts) {
        return texts
                .stream()
                .map(this::computeAnagramKey)
                .distinct()
                .count() == 1;

    }

    protected abstract String computeAnagramKey(String text);
}
