package com.leetcode;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList1) {

        if (!wordList1.contains(endWord)) {
            return 0;
        }
        Set<String> wordList = new HashSet<>(wordList1);

        Map<String, Boolean> vMap = new HashMap<>();

        for (String word : wordList) {
            vMap.put(word, false);
        }

        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);
        vMap.put(beginWord, true);
        int level = 1;

        while (!queue.isEmpty()) {
            //System.out.println("here");
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                assert word != null;
                if (word.equals(endWord)) {
                    return level;
                }

                wordMatch(word, queue, wordList, vMap);


            }
            level++;
        }

        return 0;
    }

    private void wordMatch(String word, Queue<String> queue, Set<String> wordList, Map<String, Boolean> vMap) {
        //System.out.println("here");
        char[] ch = word.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            char temp = ch[i];
            for (int j = 0; j < 26; j++) {
                int c = j + 'a';

                ch[i] = (char) c;
                StringBuilder sb = new StringBuilder();
                for (char value : ch) {
                    sb.append(value);
                }
                //  System.out.println(sb.toString());
                String check = String.valueOf(sb);
                if (wordList.contains(check) && !vMap.get(check)) {
                    queue.offer(check);
                    //System.out.println(check);
                    vMap.put(check, true);
                }


            }
            ch[i] = temp;
        }
        //  System.out.println(queue);

    }
}
