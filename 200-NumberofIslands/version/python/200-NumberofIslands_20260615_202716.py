# Last updated: 6/15/2026, 8:27:16 PM
1from collections import deque
2
3class Solution:
4    # Time - O(row * col)
5    # Space - O(min(row, col)) https://imgur.com/gallery/M58OKvB
6    #         because in worst case where the grid is filled with lands, 
7    #         the size of queue can grow up to min(M,N).
8    
9    def numIslands(self, grid: List[List[str]]) -> int:
10        total_row: int = len(grid)
11        total_col: int = len(grid[0])
12        DIRECTIONS = [(0, 1), (1, 0), (-1, 0), (0, -1)]
13
14        def bfs(row: int, col: int):
15            queue = deque()
16            queue.append([row, col])
17
18            while queue:
19                popped_row, popped_col = queue.popleft()
20
21
22                for direction in DIRECTIONS:
23                    adj_row = popped_row + direction[0]
24                    adj_col = popped_col + direction[1]
25
26                    if adj_row < 0 or adj_row >= total_row or adj_col < 0 or adj_col >= total_col:
27                        continue
28                    
29                    if visited[adj_row][adj_col]:
30                        continue
31                    
32                    if grid[adj_row][adj_col] == "1":
33                        queue.append([adj_row, adj_col])
34                        visited[adj_row][adj_col] = True
35
36        visited = [[False for _ in range(total_col)] for _ in range(total_row)]
37
38        num_of_islands = 0
39
40        for sr in range(total_row):
41            for sc in range(total_col):
42                if not visited[sr][sc] and grid[sr][sc] == "1":
43                    visited[sr][sc] = True
44                    bfs(sr, sc)
45                    num_of_islands += 1
46        
47        return num_of_islands
48
49        