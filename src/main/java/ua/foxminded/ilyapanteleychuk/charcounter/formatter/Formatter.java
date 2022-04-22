package ua.foxminded.ilyapanteleychuk.charcounter.formatter;

import java.util.Map;
import static java.lang.System.lineSeparator;


public class Formatter {

    public String format(Map<Character, Integer> mapToPrint){
        StringBuilder output = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : mapToPrint.entrySet()){
            output.append(entry.getKey()).append(":").append(entry.getValue())
                                                            .append(lineSeparator());
        }
        return output.toString();
    }
}