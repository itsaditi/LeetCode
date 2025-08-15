// Last updated: 8/15/2025, 6:46:07 PM
class Word {
    String word;
    int distance;

    public Word(String word, int dist) {
        this.word = word;
        this.distance = dist;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        
        if (!wordList.contains(endWord)) return 0;

        if (!wordList.contains(beginWord)) wordList.add(beginWord);

        for (int i = 0 ; i < wordList.size() ; i++) {
            String s = wordList.get(i);
            for (int j = i + 1 ; j < wordList.size() ; j ++) {
                String t = wordList.get(j);

                if (!map.containsKey(s)) {
                    map.put(s, new ArrayList<>());
                }

                if (!map.containsKey(t)) {
                    map.put(t, new ArrayList<>());
                }

                if (oneEditAway(s, t)) {
                    map.get(s).add(t);
                    map.get(t).add(s);
                }
            }
        }

        Queue<Word> queue = new LinkedList<>();
        int shortestSeq = Integer.MAX_VALUE;
        Set<String> visited = new HashSet<>();

        queue.add(new Word(beginWord, 0));
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Word poppedWord = queue.poll();

            String word = poppedWord.word;
            int distance = poppedWord.distance;


            if (word.equals(endWord)) {
                shortestSeq = Math.min(shortestSeq, distance);
            }

            for (String oneDistAwayString : map.get(word)) {
                if (!visited.contains(oneDistAwayString)) {
                    queue.add(new Word(oneDistAwayString, distance + 1));
                    visited.add(oneDistAwayString);
                }
            }

        }
        return shortestSeq == Integer.MAX_VALUE ? 0 : shortestSeq + 1;
    }

    private boolean oneEditAway(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int matched = 0;
        for (int i = 0 ; i < s.length(); i ++) {
            if (s.charAt(i) == t.charAt(i)) {
                matched++;
            }
        }

        return matched == s.length() - 1;
    }
}

/*
{
    hit = [hot],
    hot = [hit, dot],
    hot = [dot, lot],
    dot = [hot, dog],
    lot = [hot, log],
    dog = [log, cog],
    log = [dog, cog],
    cog = [dog, log]
}





*/