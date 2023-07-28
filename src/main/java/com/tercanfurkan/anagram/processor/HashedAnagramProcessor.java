package com.tercanfurkan.anagram.processor;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HashedAnagramProcessor extends AnagramProcessorBase {

    @Override
    protected String computeAnagramKey(String text) {
        return Integer.toString(
                Arrays.stream(text.split(""))
                        .filter(c -> !c.isBlank())
                        .collect(Collectors.groupingBy(c -> c, Collectors.counting())
                        ).hashCode());
    }
}
