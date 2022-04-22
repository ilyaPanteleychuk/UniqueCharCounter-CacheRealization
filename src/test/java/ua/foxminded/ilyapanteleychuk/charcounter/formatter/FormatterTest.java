package ua.foxminded.ilyapanteleychuk.charcounter.formatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.foxminded.ilyapanteleychuk.charcounter.charcounter.CharCountImplementation;
import static java.lang.System.lineSeparator;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;


class FormatterTest {

    private Formatter formatter;
    private CharCountImplementation charCounter;

    @BeforeEach
    void init(){
        formatter = new Formatter();
        charCounter = new CharCountImplementation();
    }

    @Test
    void format_shouldDoRightOutput_whenInputIsOneWord() {
        Map<Character, Integer> mapToPrint = charCounter.charCount("Hello");
        String expected = ("h:1" + lineSeparator() +
                           "e:1" + lineSeparator() +
                           "l:2" + lineSeparator() +
                           "o:1" + lineSeparator());
        String actual = formatter.format(mapToPrint);
        assertEquals(expected, actual);
    }

    @Test
    void format_shouldDoRightOutput_whenInputIsSeveralWord(){
        Map<Character, Integer> mapToPrint = charCounter.charCount("Hello World!");
        String expected =("h:1" + lineSeparator() +
                          "e:1" + lineSeparator() +
                          "l:3" + lineSeparator() +
                          "o:2" + lineSeparator() +
                          " :1" + lineSeparator() +
                          "w:1" + lineSeparator() +
                          "r:1" + lineSeparator() +
                          "d:1" + lineSeparator() +
                          "!:1" + lineSeparator());
        String actual = formatter.format(mapToPrint);
        assertEquals(expected, actual);
    }

    @Test
    void format_shouldDoRightOutput_whenInputIsTheSameLetter(){
        Map<Character, Integer> mapToPrint = charCounter.charCount("hhhh");
        String expected =("h:4" + lineSeparator());
        String actual = formatter.format(mapToPrint);
        assertEquals(expected, actual);
    }

    @Test
    void format_shouldDoRightOutput_whenInputHasOnlySpaces(){
        Map<Character, Integer> mapToPrint = charCounter.charCount("    ");
        String expected =(" :4" + lineSeparator());
        String actual = formatter.format(mapToPrint);
        assertEquals(expected, actual);
    }
}
