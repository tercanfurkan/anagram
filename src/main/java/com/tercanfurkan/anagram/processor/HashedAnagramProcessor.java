package com.tercanfurkan.anagram.processor;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This class implements #computeAnagramKey using the hashcode of a generated map with the following structure:
 * key => unique character,
 * value => the total count of the unique character within the text
 * For example the text "aabbccc" will be represented in a map structure such as:
 * {
 *     "a": 2,
 *     "b": 2,
 *     "c": 3
 * }
 *
 * The hashCode of two maps will be equal as long as they contain the same set of entries.
 *
 * The complexity of generating the hashCode:
 * O(n) Time, O(n) Space; where n is the number of characters in the text.
 */
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
