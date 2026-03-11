package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringProcessorTest {
    StringProcessor processor = new StringProcessor();

    @Test
    public void testConcatenate() {
        StringProcessor processor = new StringProcessor();
        String result = processor.concatenate("Hello", "World");
        assertEquals("HelloWorld", result);
    }

    @Test
    public void testConcatenateNull() {
        StringProcessor processor = new StringProcessor();
        assertThrows(IllegalArgumentException.class,
                () -> processor.concatenate(null, "World"));
    }

    @Test
    public void testIsPalindromeTrue() {
        StringProcessor processor = new StringProcessor();
        assertTrue(processor.isPalindrome("madam"));
    }

    @Test
    public void testIsPalindromeFalse() {
        StringProcessor processor = new StringProcessor();
        assertFalse(processor.isPalindrome("hello"));
    }

    @Test
    public void testIsPalindromeNull() {
        StringProcessor processor = new StringProcessor();
        assertFalse(processor.isPalindrome(null));
    }
}
