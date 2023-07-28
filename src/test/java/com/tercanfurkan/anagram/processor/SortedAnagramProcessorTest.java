package com.tercanfurkan.anagram.processor;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SortedAnagramProcessorTest {

        @Test
        public void shouldReturnFalseForAnEmptyList() {
                assertFalse(new HashedAnagramProcessor().areAnagrams(Collections.emptyList()));
        }

        @Test
        public void shouldReturnTrueForASingleText() {
                assertTrue(new HashedAnagramProcessor().areAnagrams(List.of("single text")));
        }

        @Test
        public void shouldReturnFalseForNoAnagrams(){
                var twoTexts = List.of("aabbccd", "acacbdbX");
                assertFalse(new SortedAnagramProcessor().areAnagrams(twoTexts));
        }

        @Test
        public void shouldReturnTrueForTwoAnagrams(){
                var twoTexts = List.of("aabbccd", "acacbdb");
                assertTrue(new SortedAnagramProcessor().areAnagrams(twoTexts));
        }

        @Test
        public void shouldReturnTrueForUntrimmedAnagrams(){
                var twoTexts = List.of("   aabbccd     ", "acacbdb   ");
                assertTrue(new SortedAnagramProcessor().areAnagrams(twoTexts));
        }

        @Test
        public void shouldReturnTrueForNonLetterAnagrams(){
                var twoTexts = List.of("Ñ~]Œ12345?!@+", "234 Ñ~1 5?!@+ ]Œ");
                assertTrue(new SortedAnagramProcessor().areAnagrams(twoTexts));
        }

        @Test
        public void shouldReturnTrueForAnagramsWithLineBreaks(){
                var twoTexts = List.of("\n\naabbccd", "acacbdb");
                assertTrue(new SortedAnagramProcessor().areAnagrams(twoTexts));
        }

        @Test
        public void shouldReturnTrueForIdenticalTexts(){
                var twoTexts = List.of("aabb", "aabb");
                assertTrue(new SortedAnagramProcessor().areAnagrams(twoTexts));
        }

        @Test
        public void shouldReturnTrueForAnagramsWithBlanks(){
                var twoTexts = List.of("aa bb cc d", "acac bd b");
                assertTrue(new SortedAnagramProcessor().areAnagrams(twoTexts));
        }

        @Test
        public void shouldReturnTrueForThreeAnagrams(){
                var twoTexts = List.of("aa bb cc d", "acacbdb", "cc bb aa d");
                assertTrue(new SortedAnagramProcessor().areAnagrams(twoTexts));
        }
}
