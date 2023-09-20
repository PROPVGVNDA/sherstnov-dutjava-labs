package org.example.university.lab4_1;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(IsPalindrome("HELLO"));
        System.out.println(IsPalindrome("lOl"));
        System.out.println(IsPalindrome("sos"));
        System.out.println(IsPalindrome("s os"));
    }

    public static boolean IsPalindrome(String s)
    {
        if (s.isEmpty()) return true;

        int first = 0;
        int last = s.length() - 1;
        while (first <= last)
        {
            char currentFirst = s.charAt(first);
            char currentLast = s.charAt(last);
            if (currentFirst == ' ') first++;
            else if (currentLast == ' ') last--;
            else
            {
                if (Character.toLowerCase(currentFirst) != Character.toLowerCase(currentLast)) return false;
                first++;
                last--;
            }
        }
        return true;
    }
}