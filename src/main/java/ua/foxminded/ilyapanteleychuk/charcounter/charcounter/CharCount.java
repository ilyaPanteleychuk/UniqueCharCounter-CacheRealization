package ua.foxminded.ilyapanteleychuk.charcounter.charcounter;

import java.util.Map;


public interface CharCount {

    Map<Character, Integer> countUniqueChars(String input);
}