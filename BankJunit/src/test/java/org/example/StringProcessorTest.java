package org.example;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.*;
public class StringProcessorTest {
    StringProcessor processor = new StringProcessor();

    @Test
    public void testConcatenate() {
        String res = processor.concatenate("Hello ", "World");
        assertEquals("Hello World", res);
    }

    @Test
    public void testConcatenationWithNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            processor.concatenate(null, "World");
        });
    }

    @Test
    public void testConcatenateEmptyStrings() {
        String result = processor.concatenate("", "");
        assertEquals("", result);
    }

    @Test
    public void testPalindromeTrue() {
        assertTrue(processor.isPalindrome("madam"));
    }

    @Test
    public void testPalindromeFalse() {
        assertFalse(processor.isPalindrome("hello"));
    }

    @Test
    public void testPalindromeNull() {
        assertFalse(processor.isPalindrome(null));
    }

    @Test
    public void testPalindromeSingleCharacter() {
        assertTrue(processor.isPalindrome("a"));
    }

}
