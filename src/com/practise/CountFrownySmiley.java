package com.practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class CountFrownySmiley {

    static final Set<Character> eyebrow = Set.of('>');
    static final Set<Character> eyes = Set.of(':', ';', '8');
    static final Set<Character> tears = Set.of('\'');
    static final Set<Character> nose = Set.of('-', 'o', '~');
    static final Set<Character> frownySmiley = Set.of('(', 'C', '<', '[', '{', '@');
    static final Set<Character> happySmiley = Set.of(')', ']', '}', 'D');

    public static void main(String[] args) throws IOException {
        System.out.println(tears);
       /* CountFrownySmiley countFrownySmiley = new CountFrownySmiley();
        int result = countFrownySmiley.countFrownySmiley("I want to buy a onesie… :o) but know >;-( it won’t suit me :'{");
        System.out.println(result);

        int result1 = countFrownySmiley.countFrownySmiley("I want to buy a onesie… :o) but know >;-( it won’t suit me :'{");
        System.out.println(result1);

        int result2 = countFrownySmiley.countFrownySmiley("I'd rather be a bird than a fish. :D");
        System.out.println(result2);
*/


        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }


        CountFrownySmiley countFrownySmiley = new CountFrownySmiley();
        int result = countFrownySmiley.countFrownySmiley(sb.toString());
        System.out.println(result);


    }

    private int countFrownySmiley(String input) {

        boolean isSmileyStarted = false;
        int frownySmileyCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isSmileyStarted) {
                if (tears.contains(c) || nose.contains(c)) {
                    continue;
                } else if (frownySmiley.contains(c)) {
                    frownySmileyCount++;
                    isSmileyStarted = false;
                } else if (happySmiley.contains(c)) {
                    isSmileyStarted = false;
                }
            }
            if (eyebrow.contains(c) || eyes.contains(c)) {
                isSmileyStarted = true;
            }
        }
        return frownySmileyCount;

    }

}
