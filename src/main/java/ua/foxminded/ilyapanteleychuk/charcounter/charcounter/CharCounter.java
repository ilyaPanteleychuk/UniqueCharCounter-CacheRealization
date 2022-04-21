package ua.foxminded.ilyapanteleychuk.charcounter.charcounter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class CharCounter implements CharCount {

    @Override
    public Map<Character, Integer> countUniqueChars(String input){
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