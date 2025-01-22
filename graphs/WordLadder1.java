import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordLadder1 {
    public static void main(String[] args) {
        // String[] strs = {"hot", "dot","dog","lot","log","cog"};
        String[] strs = {"a", "b","c"};
        // String[] strs = {"hot","dog","dot"};
        List<String> wordList=new ArrayList<>();
        Collections.addAll(wordList, strs);
        // System.out.println(ladderLength("hit", "cog", wordList));
        System.out.println(ladderLength("a", "c", wordList));
        // System.out.println(ladderLength("hot", "dog", wordList));
    }
    public static class Pair {
        String x;
        int y;
        Pair(String x, int y) {
            this.x=x;
            this.y=y;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordMap = new HashSet<>();
        for (String s: wordList) {
            wordMap.add(s);
        }
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        HashSet<String> visited = new HashSet<>();
        boolean isFoundEndword = false;

        int level = 0;
        while (!queue.isEmpty()) {
            Pair topPair = queue.poll();
            visited.add(topPair.x);
            char[] chrs = topPair.x.toCharArray();
            int step = topPair.y;

            if (topPair.x.equals(endWord)) {
                level = step;
                break;
            }
            for (int i = 0; i < chrs.length; i++) {
                char[] copyChars = Arrays.copyOf(chrs, chrs.length);
                for (int j = 0; j < 26; j++) {
                    copyChars[i] = (char) ('a' + j);
                    String x = String.valueOf(copyChars);
                    if (wordMap.contains(x) && !visited.contains(x)) {
                        queue.add(new Pair(x, step+ 1));
                        if (x.equals(endWord)) {
                            isFoundEndword = true;
                        }
                    }
                }
            }
        }
        return isFoundEndword ? level: 0;
    }
}
