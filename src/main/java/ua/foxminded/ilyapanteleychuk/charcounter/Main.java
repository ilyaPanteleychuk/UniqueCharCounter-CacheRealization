package ua.foxminded.ilyapanteleychuk.charcounter;

import ua.foxminded.ilyapanteleychuk.charcounter.cachedecorator.CacheDecorator;
import ua.foxminded.ilyapanteleychuk.charcounter.charcounter.CharCounter;


public class Main {

    public static void main(String[] args) {
        String input = "Hello world!";
        CacheDecorator cacheDecorator = new CacheDecorator(new CharCounter());
        cacheDecorator.charCount(input);
    }
}