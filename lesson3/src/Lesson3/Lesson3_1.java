package Lesson3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Lesson3_1 {

    static String[] wordsArray = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                                  "one", "one", "two", "two", "three", "three", "four", "four", "five", "five",
                                  "six", "six", "seven", "seven", "nine", "nine", "ten", "ten",
                                  "one","three", "five", "seven", "nine"};

    static HashSet<String> uniqueWords (String[] array){
        return new HashSet<>(Arrays.asList(array));
    }

    static HashMap<String, Integer> sameWordsCount (String[] array){
        HashMap<String, Integer> count = new HashMap<>();
        for ( String word : array ) {
            count.put(word, count.getOrDefault(word, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(uniqueWords(wordsArray));
        System.out.println(sameWordsCount(wordsArray));
    }
}
