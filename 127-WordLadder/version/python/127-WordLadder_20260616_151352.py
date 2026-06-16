# Last updated: 6/16/2026, 3:13:52 PM
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
31                src_wrd = wordList[src_idx]
32                dest_wrd = wordList[dest_idx]
33
34                if src_wrd not in graph:
35                    graph[src_wrd] = []
36
37                if dest_wrd not in graph:
38                    graph[dest_wrd] = []
39
40                if is_one_word_change(src_wrd, dest_wrd):
41                    graph[src_wrd].append(dest_wrd)
42                    graph[dest_wrd].append(src_wrd)
43
44        
45        visited = []
46        queue = deque()
47
48        queue.append([beginWord, 1])
49        visited.append(beginWord)
50
51        shortest_seq = math.inf
52
53        while queue:
54            wrd, dist = queue.popleft()
55
56            # visited.append(wrd)
57
58            if wrd == endWord:
59                shortest_seq = min(shortest_seq, dist)
60
61            for adj_word in graph[wrd]:
62                if adj_word not in visited:
63                    queue.append([adj_word, dist + 1])
64                    visited.append(adj_word)
65
66        if shortest_seq == math.inf:
67            return 0
68        
69        return shortest_seq