# Last updated: 6/15/2026, 9:21:51 PM
1from collections import deque
2
3class Solution:
4    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
5        total_row = len(heights)
6        total_col = len(heights[0])
7
8        grid_coor: List[List[int]] = []
9
10        directions =[(0, 1), (1, 0), (-1, 0), (0, -1)]
11
12        def bfs(queue, visited_set):
13
14            while queue:
15                row, col = queue.popleft()
16                
17                if (row, col) in visited_set:
18                    continue
19                
20                visited_set.append((row, col))
21
22                for direction in directions:
23                    adj_row = row + direction[0]
24                    adj_col = col + direction[1]
25
26                    if adj_row < 0 or adj_row >= total_row or adj_col < 0 or adj_col >= total_col:
27                        continue
28
29                    if (adj_row, adj_col) in visited_set:
30                        continue
31                    print(row, col, adj_row, adj_col)
32                    if heights[row][col] <= heights[adj_row][adj_col]:
33                        queue.append((adj_row, adj_col))
34        
35        
36        def traverse_set(smaller_set, bigger_set, res):
37            for i in range(len(smaller_set)):
38                if smaller_set[i] in bigger_set:
39                    res.append(smaller_set[i])
40        
41        pacific_queue = deque()
42        atlantic_queue = deque()
43
44        pacific_visited = []
45        atlantic_visited = []
46
47        res = []
48        
49        # Upper row (Pacific) and last column (Atlantic)
50        for col in range(total_col):
51            pacific_queue.append([0, col])
52            atlantic_queue.append([total_row - 1, col])
53        
54        for row in range(total_row):
55            pacific_queue.append([row, 0])
56            atlantic_queue.append([row, total_col - 1])
57        
58        bfs(pacific_queue, pacific_visited)
59        print(pacific_visited)
60
61        bfs(atlantic_queue, atlantic_visited)
62        print(atlantic_visited)
63
64        if len(pacific_visited) <= len(atlantic_visited):
65            traverse_set(pacific_visited, atlantic_visited, res)
66        else:
67            traverse_set(atlantic_visited, pacific_visited, res)
68
69
70
71        
72        return res
73        