# Last updated: 6/9/2026, 9:45:44 PM
1from collections import deque
2
3class Solution:
4    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
5        starting_pixel = image[sr][sc]
6        total_row = len(image)
7        total_col = len(image[0])
8        DIRECTIONS = [[-1, 0], [0, -1], [1, 0], [0, 1]]
9
10        queue = deque()
11        seen: List[List[boolean]] = [[False for _ in range(total_col)] for _ in range(total_row)]
12
13        queue.append([sr, sc])
14
15        while len(queue) != 0:
16            [row, col] = queue.popleft()
17
18            if image[row][col] == starting_pixel:
19                image[row][col] = color
20                seen[row][col] = True
21            else:
22                continue
23
24            for direction in DIRECTIONS:
25                adj_row = row + direction[0]
26                adj_col = col + direction[1]
27
28                if (adj_row < 0 or adj_row >= total_row) or (adj_col < 0 or adj_col >= total_col):
29                    continue
30
31                if not seen[adj_row][adj_col]:
32                    queue.append([adj_row, adj_col])
33
34        return image
35        