package ua.foxminded.ilyapanteleychuk.charcounter.charcounter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class CharCountImplementation implements CharCount {

    private static final Map<String, Map<Character, Integer>> cache = new LinkedHashMap<>();

    @Override
    public Map<Character, Integer> charCount(String input){
        Map<Character, Integer> cached = cache.get(input);
        if(cached != null){
            return cached;
        }
        Map<Character, Integer> calculated = calculateUniqueChars(input);
        cache.put(input, calculated);
        return calculated;
    }

    private Map<Character, Integer> calculateUniqueChars(String input){
        Map<Character, Integer> uniqueChars = new LinkedHashMap<>();
        List<Character> inputCharList = input.toLowerCase().chars().
                    mapToObj(c -> (char) c).collect(Collectors.toList());
        for(int i = 0; i != inputCharList.size();){
            int value = 1;
            uniqueChars.put(inputCharList.get(i), value);
            for(int j = i + 1; j != inputCharList.size(); j++){
                if(inputCharList.get(j).equals(inputCharList.get(i))){
                    value++;
                    uniqueChars.replace(inputCharList.get(i), value);
                    inputCharList.remove(j);
                    j--;
                }
            }
            inputCharList.remove(i);
        }
        return uniqueChars;
    }
}
