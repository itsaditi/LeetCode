# Last updated: 6/15/2026, 8:22:54 PM
1from collections import deque
2
3class Solution:
4    
5
6    def numIslands(self, grid: List[List[str]]) -> int:
7        total_row: int = len(grid)
8        total_col: int = len(grid[0])
9        DIRECTIONS = [(0, 1), (1, 0), (-1, 0), (0, -1)]
10
11        def bfs(row: int, col: int):
12            queue = deque()
13            queue.append([row, col])
14
15            while queue:
16                popped_row, popped_col = queue.popleft()
17
18
19                for direction in DIRECTIONS:
20                    adj_row = popped_row + direction[0]
21                    adj_col = popped_col + direction[1]
22
23                    if adj_row < 0 or adj_row >= total_row or adj_col < 0 or adj_col >= total_col:
24                        continue
25                    
26                    if visited[adj_row][adj_col]:
27                        continue
28                    
29                    if grid[adj_row][adj_col] == "1":
30                        queue.append([adj_row, adj_col])
31                        visited[adj_row][adj_col] = True
32
33
34
35
36
37
38        visited = [[False for _ in range(total_col)] for _ in range(total_row)]
39
40        num_of_islands = 0
41
42        for sr in range(total_row):
43            for sc in range(total_col):
44                if not visited[sr][sc] and grid[sr][sc] == "1":
45                    visited[sr][sc] = True
46                    bfs(sr, sc)
47                    num_of_islands += 1
48        
49        return num_of_islands
50
51        