package com.leetcode;


import java.util.HashMap;
import java.util.Map;

public class StreamChecker {

    TrieDataStructure root = new TrieDataStructure();

    String s = "";

    public StreamChecker(String[] words) {


        for (int i = 0; i < words.length; i++) {

            TrieDataStructure current = root;
            String word = words[i];

            //store the words in trie data structure in REVERSE

            for (int j = word.length() - 1; j >= 0; j--) {

                Character c = word.charAt(j);
                TrieDataStructure node = current.charMap.get(c);

                if (node == null) {

                    node = new TrieDataStructure();
                    current.charMap.put(c, node);

                }

                current = node;

            }

            current.isLastLetter = true;
        }

    }

    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"}); // init the dictionary.
        streamChecker.query('a');          // return false
        streamChecker.query('b');          // return false
        streamChecker.query('c');          // return false
        streamChecker.query('d');          // return true, because 'cd' is in the wordlist
        streamChecker.query('e');          // return false
        streamChecker.query('f');          // return true, because 'f' is in the wordlist
        streamChecker.query('g');          // return false
        streamChecker.query('h');          // return false
        streamChecker.query('i');          // return false
        streamChecker.query('j');          // return false
        streamChecker.query('k');          // return false
        streamChecker.query('l');          // return true, because 'kl' is in the wordlist
    }

    public boolean query(char letter) {

        s = letter + s; //keep appending the letter at start of the string. and then search the word till u encounter last letter.

        TrieDataStructure current = root;

        for (int i = 0; i < s.length(); i++) {

            TrieDataStructure node = current.charMap.get(s.charAt(i));

            if (node != null) {
                current = node;
                if (current.isLastLetter) return true;  //imp to return when u encounter end of word or last letter
            } else {
                return false;
            }
        }

        return current.isLastLetter == true;

    }

    //TRIE data structure
    class TrieDataStructure {

        Map<Character, TrieDataStructure> charMap;
        boolean isLastLetter;

        TrieDataStructure() {
            this.charMap = new HashMap<>();
            isLastLetter = false;
        }
    }
}
