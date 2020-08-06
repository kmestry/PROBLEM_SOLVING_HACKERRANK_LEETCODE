package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Trie {


    TrieDataStructure root;


    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieDataStructure();
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("abc");
        obj.insert("abd");
        obj.search("abc");
    }

    //abc
    public void insert(String word) {
        TrieDataStructure current = root;

        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            TrieDataStructure node = current.charTrieMap.get(character);

            if (node == null) {
                node = new TrieDataStructure();
                current.charTrieMap.put(character, node);
            }
            current = node;

        }
        current.isEndOfWord = true;


    }

    public boolean search(String word) {
        TrieDataStructure current = root;
        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            if (current.charTrieMap.containsKey(character)) {
                current = current.charTrieMap.get(character);
            } else {
                return false;
            }
        }

        return current.isEndOfWord == true;
    }

    public boolean startsWith(String prefix) {
        TrieDataStructure current = root;

        for (int i = 0; i < prefix.length(); i++) {
            Character character = prefix.charAt(i);
            if (current.charTrieMap.containsKey(character)) {
                current = current.charTrieMap.get(character);
            } else {
                return false;
            }
        }
        return true;
    }

    class TrieDataStructure {
        Map<Character, TrieDataStructure> charTrieMap;
        boolean isEndOfWord;

        TrieDataStructure() {
            charTrieMap = new HashMap<>();
            isEndOfWord = false;
        }
    }
}
