package com.tercanfurkan.anagram.processor;

import java.util.List;

public abstract class AnagramProcessorBase implements AnagramProcessor {
    public boolean areAnagrams(List<String> texts) {
        return texts
                .stream()
                .map(this::computeAnagramKey)
                .distinct()
                .count() <= 1;

    }

    protected abstract String computeAnagramKey(String text);
}
