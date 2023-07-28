package com.tercanfurkan.anagram.processor;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortedAnagramProcessor extends AnagramProcessorBase {

    @Override
    protected String computeAnagramKey(String text) {
        return Stream.of(text.split(""))
                .filter(c -> !c.isBlank())
                .sorted()
                .collect(Collectors.joining());
    }
}
