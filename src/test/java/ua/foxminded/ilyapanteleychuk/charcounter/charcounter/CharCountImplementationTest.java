package ua.foxminded.ilyapanteleychuk.charcounter.charcounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;


class CharCountImplementationTest {

    private CharCountImplementation charCountImplementation;
    private Map<Character, Integer> actualAmountOfChar;

    @BeforeEach
    void init(){
       charCountImplementation = new CharCountImplementation();
       actualAmountOfChar = new LinkedHashMap<>();
    }

    @Test
    void charCount_shouldDoRightCalculation_whenInputIsSingleWord() {
        Map<Character, Integer> countedChar = charCountImplementation.charCount("Hello");
        actualAmountOfChar.put('h', 1);
        actualAmountOfChar.put('e', 1);
        actualAmountOfChar.put('l', 2);
        actualAmountOfChar.put('o', 1);
        assertEquals(countedChar, actualAmountOfChar);
    }

    @Test
    void charCount_shouldDoRightCalculation_whenInputIsSeveralWord(){
        Map<Character, Integer> countedChar = charCountImplementation.charCount("Hello World Again");
        actualAmountOfChar.put('h', 1);
        actualAmountOfChar.put('e', 1);
        actualAmountOfChar.put('l', 3);
        actualAmountOfChar.put('o', 2);
        actualAmountOfChar.put(' ', 2);
        actualAmountOfChar.put('w', 1);
        actualAmountOfChar.put('r', 1);
        actualAmountOfChar.put('d', 1);
        actualAmountOfChar.put('a', 2);
        actualAmountOfChar.put('g', 1);
        actualAmountOfChar.put('i', 1);
        actualAmountOfChar.put('n', 1);
        assertEquals(countedChar, actualAmountOfChar);
    }

    @Test
    void charCount_shouldDoRightCalculation_whenInputHasOnlySpaces(){
        Map<Character, Integer> countedChar = charCountImplementation.charCount("    ");
        actualAmountOfChar.put(' ', 4);
        assertEquals(countedChar, actualAmountOfChar);
    }

    @Test
    void charCount_shouldDoRightCalculation_whenInputHasTheSameLetter(){
        Map<Character, Integer> countedChar = charCountImplementation.charCount("hhhhh");
        actualAmountOfChar.put('h', 5);
        assertEquals(countedChar, actualAmountOfChar);
    }

    @Test
    void charCount_shouldUseCachedValue_whenTheSameInputHasBeenAddedSeveralTimes(){
        String input = "Hello world!";
        String secondInput = "Hello world!";
        Map<Character, Integer> result = charCountImplementation.charCount(input);
        Map<Character, Integer> resultFromCache = charCountImplementation.charCount(secondInput);
        assertSame(result, resultFromCache);
    }

    @Test
    void charCount_shouldNotUseCacheValue_whenInputWasAddedOnlyOnce(){
        String input = "Hello world!";
        String secondInput = "Hello wo";
        Map<Character, Integer> result = charCountImplementation.charCount(input);
        Map<Character, Integer> resultFromCache = charCountImplementation.charCount(secondInput);
        assertNotSame(result, resultFromCache);
    }
}