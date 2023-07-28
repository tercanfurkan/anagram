package com.tercanfurkan.anagram.processor;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class implements #computeAnagramKey using the sorted version of the passed text
 * For example the anagram key for "apple":
 * >> "aellpp"
 *
 * Sorted version of anagrams will be equal to each other.
 *
 * The complexity of computing the anagramKey:
 * O(nlog(n)) time, O(n) space; where n is the number of characters in the text.
 * The complexity comes from the sorting algorithm which Arrays.sort() uses under the hood.
 */
public class SortedAnagramProcessor extends AnagramProcessorBase {

    @Override
    protected String computeAnagramKey(String text) {
        return Stream.of(text.split(""))
                .filter(c -> !c.isBlank())
                .sorted()
                .collect(Collectors.joining());
    }
}
