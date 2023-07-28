# Anagram Checker App

## Summary

Java CLI application to check if two given texts are anagrams.

## Calculation method

You can pick and choose two different implementations to check anagrams.

### a) Sorting approach

Transforms the text to a unique anagram key by sorting them in ascending order.\


### b) Hashing approach

1- Constructs a map for each text as `{ unique_char to count }`.\

Ex: Map representation of the text "aabbccc":\
`{ "a": 2, "b": 2, "c": 3}`

2- Calculates the hashCode for the map. 

The generated hashCode is then the same for anagrams.

## How it works
```
# To build and run
mvn package && mvn exec:java

# Just run tests
mvn test
```