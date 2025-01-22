import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordLadder {
    public static void main(String[] args) {
        String[] wordList = {"des","der","dfr","dgt","dfs"};
        List<String> wordStrings = new ArrayList<>();
        for (int i =0;i<wordList.length;i++){
            wordStrings.add(wordList[i]);
        }
        System.out.println(ladderLength("der", "dfs", wordStrings));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = wordList.size();
        HashSet<String> wordMap = new HashSet<>();
        for (String s: wordList) {
            wordMap.add(s);
        }
        if (!wordMap.contains(beginWord) || !wordMap.contains(endWord)) {
            return 0;
        }
        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            String top = queue.poll();
            // change the word in sequence
            for (int i = 0; i < top.length(); i++) {
                char curr = top.charAt(i);
                top.substring(i+1, len);
            }
        }

        return 0;
    }
}
