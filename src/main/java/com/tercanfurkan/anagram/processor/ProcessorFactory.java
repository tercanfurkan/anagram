package com.tercanfurkan.anagram.processor;

public class ProcessorFactory {

    public enum ProcessorType {
        SORTING, HASHING;
    }

    public static AnagramProcessor initProcessor(ProcessorType type) {
        switch (type) {
            case HASHING: return new HashedAnagramProcessor();
            default: return new SortedAnagramProcessor();
        }
    }
}
