package org.university.lab2;

import org.junit.jupiter.api.Test;
import org.university.lab2.DVD;

import static org.junit.jupiter.api.Assertions.*;

class DVDTest {

    @Test
    void createWithIllegalDuration() {
        assertThrows(IllegalArgumentException.class, () -> new DVD("Title", 0));
        assertThrows(IllegalArgumentException.class, () -> new DVD("Title", -1));
    }

    @Test
    void setIllegalDuration() {
        DVD dvd = new DVD("Title", 15);
        assertThrows(IllegalArgumentException.class, () -> dvd.setDuration(0));
        assertThrows(IllegalArgumentException.class, () -> dvd.setDuration(-5));
    }
}
