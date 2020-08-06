package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
/*        wordDictionary.search("pad");
        wordDictionary.search("bad");*/
        wordDictionary.search(".ad");
        wordDictionary.search("b..");
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            TrieNode node = current.characterTrieNodeMap.get(character);
            if (node == null) {
                node = new TrieNode();
                current.characterTrieNodeMap.put(character, node);
            }
            current = node;
        }

        current.isEndOfWord = true;


    }


    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    public boolean searchHelper(String word, int pos, TrieNode node) {

        if (pos == word.length()) {
            return node.isEndOfWord;
        }

        if (node.characterTrieNodeMap.size() == 0) {
            return false;
        }

        final char key = word.charAt(pos);
        if (key == '.') {
            for (Character c : node.characterTrieNodeMap.keySet()) {
                searchHelper(word, pos + 1, node.characterTrieNodeMap.get(c));
            }
        }

        if (!node.characterTrieNodeMap.containsKey(key)) {
            return false;
        }

        return searchHelper(word, pos + 1, node.characterTrieNodeMap.get(key));

    }


    class TrieNode {
        Map<Character, TrieNode> characterTrieNodeMap;
        boolean isEndOfWord;

        TrieNode() {
            this.characterTrieNodeMap = new HashMap<>();
            this.isEndOfWord = false;
        }
    }
}
