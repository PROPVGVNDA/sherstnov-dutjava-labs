package org.example.university.lab4_1;

import static org.example.university.lab4_1.Main.IsPalindrome;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    void testIsPalindrome() {
        assertTrue(IsPalindrome("Never odd or even"));
        assertTrue(IsPalindrome("Dennis sinNed"));
        assertTrue(IsPalindrome("Do geese see God"));
        assertTrue(IsPalindrome("pop"));
        assertTrue(IsPalindrome(""));
        assertTrue(IsPalindrome("  "));

        assertFalse(IsPalindrome("hello"));
    }

}
