package org.university.lab4_2;

public class Decoder {

    public static String decodeVowels(String encoded) {
        return encoded.replaceAll("1", "a")
                .replaceAll("2", "e")
                .replaceAll("3", "i")
                .replaceAll("4", "o")
                .replaceAll("5", "u");
    }

    public static String decodeConsonants(String encoded) {
        StringBuilder decoded = new StringBuilder();
        for (char c : encoded.toCharArray()) {
            if (Character.isLetter(c) && "aeiou".indexOf(c) == -1) {
                if (c == 'b') {
                    c = 'z';
                } else if (c != 'a') {
                    c = (char) (c - 1);
                    if ("aeiou".indexOf(c) != -1) {
                        c = (char) (c - 1);
                    }
                }
            }
            decoded.append(c);
        }
        return decoded.toString();
    }

    public static String decode(String encoded) {
        if (encoded.matches(".*[12345].*")) {
            return decodeVowels(encoded);
        }
        else if (encoded.matches(".*[bcdfghjklmnpqrstvwxyz].*")) {
            return decodeConsonants(encoded);
        }
        return encoded;
    }
}
