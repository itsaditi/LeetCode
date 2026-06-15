# Last updated: 6/15/2026, 4:42:58 PM
1from collections import deque
2
3
4class Solution:
5    TOTAL_ROW: int = 0
6    TOTAL_COL: int = 0
7    DIRECTIONS = [[0, 1], [1, 0], [-1, 0], [0, -1]]
8
9    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
10        self.TOTAL_ROW = len(mat)
11        self.TOTAL_COL = len(mat[0])
12
13        matrix = [row[:] for row in mat]
14        queue = deque()
15        visited = [[False for _ in range(self.TOTAL_COL)] for _ in range(self.TOTAL_ROW)]
16
17        for sr in range(self.TOTAL_ROW):
18            for sc in range(self.TOTAL_COL):
19                if mat[sr][sc] == 0:
20                    queue.append([sr, sc, 0])
21                    visited[sr][sc] = True     
22
23        while len(queue) != 0 :
24            row, col, dist = queue.popleft()
25            print(row, col)
26
27            for direction in self.DIRECTIONS:
28                adj_row = row + direction[0]
29                adj_col = col + direction[1]
30                
31                if (adj_row < 0 or adj_row >= self.TOTAL_ROW) or (adj_col < 0 or adj_col >= self.TOTAL_COL):
32                    continue
33                
34                if visited[adj_row][adj_col]:
35                    continue
36
37                visited[adj_row][adj_col] = True
38                queue.append([adj_row, adj_col, dist + 1])
39                matrix[adj_row][adj_col] = dist + 1
40    
41        return matrix
42        
43
44
45
46
47
48        