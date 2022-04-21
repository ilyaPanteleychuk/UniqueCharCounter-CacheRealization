package ua.foxminded.ilyapanteleychuk.charcounter.charcounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CharCounterTest {

    private CharCounter charCounter;
    private Map<Character, Integer> actualAmountOfChar;

    @BeforeEach
    void init(){
       charCounter = new CharCounter();
       actualAmountOfChar = new LinkedHashMap<>();
    }

    @Test
    void countUniqueChars_shouldDoRightCalculation_whenInputIsSingleWord() {
        Map<Character, Integer> countedChar = charCounter.countUniqueChars("Hello");
        actualAmountOfChar.put('h', 1);
        actualAmountOfChar.put('e', 1);
        actualAmountOfChar.put('l', 2);
        actualAmountOfChar.put('o', 1);
        assertEquals(countedChar, actualAmountOfChar);
    }

    @Test
    void countUniqueChars_shouldDoRightCalculation_whenInputIsSeveralWord(){
        Map<Character, Integer> countedChar = charCounter.countUniqueChars("Hello World Again");
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
    void countUniqueChars_shouldDoRightCalculation_whenInputHasOnlySpaces(){
        Map<Character, Integer> countedChar = charCounter.countUniqueChars("    ");
        actualAmountOfChar.put(' ', 4);
        assertEquals(countedChar, actualAmountOfChar);
    }

    @Test
    void countUniqueChars_shouldDoRightCalculation_whenInputHasTheSameLetter(){
        Map<Character, Integer> countedChar = charCounter.countUniqueChars("hhhhh");
        actualAmountOfChar.put('h', 5);
        assertEquals(countedChar, actualAmountOfChar);
    }
}