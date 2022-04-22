package ua.foxminded.ilyapanteleychuk.charcounter;

import ua.foxminded.ilyapanteleychuk.charcounter.charcounter.CharCountImplementation;
import ua.foxminded.ilyapanteleychuk.charcounter.formatter.Formatter;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        String input = "Hello world!";
        CharCountImplementation charCounter = new CharCountImplementation();
        Map<Character, Integer> mapToOutput = charCounter.charCount(input);
        Formatter formatter = new Formatter();
        String output = formatter.format(mapToOutput);
        System.out.print(output);
    }
}