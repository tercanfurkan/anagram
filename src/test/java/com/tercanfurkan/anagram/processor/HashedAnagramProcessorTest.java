package com.tercanfurkan.anagram.processor;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HashedAnagramProcessorTest {

    @Test
    public void shouldReturnFalseForNoAnagrams(){
        var twoTexts = List.of("aabbccd", "acacbdbX");
        assertFalse(new HashedAnagramProcessor().areAnagrams(twoTexts));
    }

    @Test
    public void shouldReturnTrueForTwoAnagrams(){
        var twoTexts = List.of("aabbccd", "acacbdb");
        assertTrue(new HashedAnagramProcessor().areAnagrams(twoTexts));
    }

    @Test
    public void shouldReturnTrueForUntrimmedAnagrams(){
        var twoTexts = List.of("   aabbccd     ", "acacbdb   ");
        assertTrue(new HashedAnagramProcessor().areAnagrams(twoTexts));
    }

    @Test
    public void shouldReturnTrueForNonLetterAnagrams(){
        var twoTexts = List.of("Ñ~]Œ12345?!@+", "234 Ñ~1 5?!@+ ]Œ");
        assertTrue(new HashedAnagramProcessor().areAnagrams(twoTexts));
    }

    @Test
    public void shouldReturnTrueForAnagramsWithLineBreaks(){
        var twoTexts = List.of("\n\naabbccd", "acacbdb");
        assertTrue(new HashedAnagramProcessor().areAnagrams(twoTexts));
    }

    @Test
    public void shouldReturnTrueForIdenticalTexts(){
        var twoTexts = List.of("aabb", "aabb");
        assertTrue(new HashedAnagramProcessor().areAnagrams(twoTexts));
    }

    @Test
    public void shouldReturnTrueForAnagramsWithBlanks(){
        var twoTexts = List.of("aa bb cc d", "acac bd b");
        assertTrue(new HashedAnagramProcessor().areAnagrams(twoTexts));
    }

    @Test
    public void shouldReturnTrueForThreeAnagrams(){
        var twoTexts = List.of("aa bb cc d", "acacbdb", "cc bb aa d");
        assertTrue(new HashedAnagramProcessor().areAnagrams(twoTexts));
    }
}
