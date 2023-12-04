package org.university.lab4_2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DecoderTest {
    @Test
    void testVowelDecoding() {
        assertEquals("testing", Decoder.decode("t2st3ng"));
    }

    @Test
    void testConsonantDecoding() {
        assertEquals("testing", Decoder.decode("vetviph"));
    }
}
