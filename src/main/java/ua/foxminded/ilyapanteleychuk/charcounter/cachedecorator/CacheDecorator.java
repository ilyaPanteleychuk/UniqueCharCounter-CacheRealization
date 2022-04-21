package ua.foxminded.ilyapanteleychuk.charcounter.cachedecorator;

import ua.foxminded.ilyapanteleychuk.charcounter.charcounter.CharCounter;
import java.util.LinkedHashMap;
import java.util.Map;


public class CacheDecorator {

    private final Map<String, Map<Character, Integer>> cache = new LinkedHashMap<>();
    private final CharCounter charCounter;

    public CacheDecorator(CharCounter charCounter) {
        this.charCounter = charCounter;
    }

    public Map<Character, Integer> charCount(String input){
        Map<Character, Integer> cached = cache.get(input);
        if(cached != null){
            return print(cached);
        }
        Map<Character, Integer> calculated = charCounter.countUniqueChars(input);
        cache.put(input, calculated);
        return print(calculated);
    }

    private Map<Character, Integer> print(Map<Character, Integer> mapToPrint){
        for(Map.Entry<Character, Integer> entry : mapToPrint.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        return mapToPrint;
    }
}