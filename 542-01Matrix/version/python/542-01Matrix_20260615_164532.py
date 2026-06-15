# Last updated: 6/15/2026, 4:45:32 PM
1from collections import deque
2
3
4class Solution:
5    TOTAL_ROW: int = 0
6    TOTAL_COL: int = 0
7    DIRECTIONS = [[0, 1], [1, 0], [-1, 0], [0, -1]]
8
9    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
10        
11        def isValid(row, col):
12            return 0 <= row < self.TOTAL_ROW and 0 <= col < self.TOTAL_COL
13
14        self.TOTAL_ROW = len(mat)
15        self.TOTAL_COL = len(mat[0])
16
17        matrix = [row[:] for row in mat]
18        queue = deque()
19        visited = [[False for _ in range(self.TOTAL_COL)] for _ in range(self.TOTAL_ROW)]
20
21        for sr in range(self.TOTAL_ROW):
22            for sc in range(self.TOTAL_COL):
23                if mat[sr][sc] == 0:
24                    queue.append([sr, sc, 0])
25                    visited[sr][sc] = True     
26
27        while len(queue) != 0 :
28            row, col, dist = queue.popleft()
29
30            for direction in self.DIRECTIONS:
31                adj_row = row + direction[0]
32                adj_col = col + direction[1]
33                
34                if (adj_row < 0 or adj_row >= self.TOTAL_ROW) or (adj_col < 0 or adj_col >= self.TOTAL_COL):
35                    continue
36                
37                if visited[adj_row][adj_col]:
38                    continue
39
40                visited[adj_row][adj_col] = True
41                queue.append([adj_row, adj_col, dist + 1])
42                matrix[adj_row][adj_col] = dist + 1
43    
44        return matrix
45        
46
47
48
49
50
51        