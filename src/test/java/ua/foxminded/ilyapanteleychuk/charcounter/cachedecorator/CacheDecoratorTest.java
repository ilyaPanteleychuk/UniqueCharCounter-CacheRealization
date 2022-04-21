package ua.foxminded.ilyapanteleychuk.charcounter.cachedecorator;

import org.junit.jupiter.api.Test;
import ua.foxminded.ilyapanteleychuk.charcounter.charcounter.CharCounter;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;


class CacheDecoratorTest {

    @Test
    void charCount_shouldCallMethodCharCount_whenInputHasNotBeenAddedToCacheYet() {
        String input = "Hello World";
        CharCounter mockCounter = mock(CharCounter.class);
        CacheDecorator decorator = new CacheDecorator(mockCounter);
        decorator.charCount(input);
        verify(mockCounter, times(1)).countUniqueChars(input);
    }

    @Test
    void charCount_shouldNotCallMethodCharCount_whenInputHasAlreadyBeenAddedToCache(){
        String input = "Hello World";
        CharCounter mockCounter = mock(CharCounter.class);
        CacheDecorator decorator = new CacheDecorator(mockCounter);
        decorator.charCount(input);
        decorator.charCount(input);
        verify(mockCounter, times(1)).countUniqueChars(input);
    }
}