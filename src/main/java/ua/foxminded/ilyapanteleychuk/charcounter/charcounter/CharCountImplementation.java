package ua.foxminded.ilyapanteleychuk.charcounter.charcounter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class CharCountImplementation implements CharCount {

    private static final Map<String, Map<Character, Integer>> cache = new LinkedHashMap<>();

    @Override
    public Map<Character, Integer> charCount(String input) {
        Map<Character, Integer> cached = cache.get(input);
        if(cached != null) {
            return cached;
        }
        Map<Character, Integer> calculated = calculateUniqueChars(input);
        cache.put(input, calculated);
        return calculated;
    }

    private Map<Character, Integer> calculateUniqueChars(String input) {
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        char[] inputCharArray = input.toCharArray();
        for(char c : inputCharArray){
            uniqueChars.compute(c, (k, v) -> (v == null) ? 1 : v+1);
        }
        return uniqueChars;
    }
}
