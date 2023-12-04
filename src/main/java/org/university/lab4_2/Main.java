package org.university.lab4_2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> encodedStrings = Arrays.asList(
                "t2st3ng", "vetviph"
        );

        for (String encoded : encodedStrings) {
            String decoded = Decoder.decode(encoded);
            System.out.println(encoded + " - " + decoded);
        }
    }
}
