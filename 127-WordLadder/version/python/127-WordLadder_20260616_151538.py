# Last updated: 6/16/2026, 3:15:38 PM
1from collections import deque
2import math
3
4
5class Solution:
6    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
7
8        if endWord not in wordList:
9            return 0
10        
11        def is_one_word_change(src_word, dest_word):
12            n = len(src_word)
13
14            count = 0
15
16            if len(src_word) == 1 and len(dest_word) == 1:
17                return True
18
19            for i in range(n):
20                if src_word[i] == dest_word[i]:
21                    count += 1
22                
23            return n - 1 == count
24        
25        graph = {}
26
27        wordList.append(beginWord)
28
29        for src_idx in range(len(wordList)):
30            for dest_idx in range(src_idx, len(wordList)):
31                
32                src_wrd = wordList[src_idx]
33                dest_wrd = wordList[dest_idx]
34
35                if src_wrd == dest_wrd:
36                    continue
37
38                if src_wrd not in graph:
39                    graph[src_wrd] = []
40
41                if dest_wrd not in graph:
42                    graph[dest_wrd] = []
43
44                if is_one_word_change(src_wrd, dest_wrd):
45                    graph[src_wrd].append(dest_wrd)
46                    graph[dest_wrd].append(src_wrd)
47
48        
49        visited = []
50        queue = deque()
51
52        queue.append([beginWord, 1])
53        visited.append(beginWord)
54
55        shortest_seq = math.inf
56
57        while queue:
58            wrd, dist = queue.popleft()
59
60            if wrd == endWord:
61                shortest_seq = min(shortest_seq, dist)
62
63            for adj_word in graph[wrd]:
64                if adj_word not in visited:
65                    queue.append([adj_word, dist + 1])
66                    visited.append(adj_word)
67
68        if shortest_seq == math.inf:
69            return 0
70        
71        return shortest_seq