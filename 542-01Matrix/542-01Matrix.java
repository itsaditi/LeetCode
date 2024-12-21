class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        nrow, ncol = len(mat), len(mat[0])
        queue = deque([])
        visited = set()
        for i in range(nrow):
            for j in range(ncol):
                if mat[i][j] == 0:
                    queue.append((i, j))
                    visited.add((i, j))


        while queue:
            i, j = queue.popleft()
            for di, dj in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
                if 0 <= i + di < nrow and 0 <= j + dj < ncol and (i+di, j+dj) not in visited:
                    visited.add((i+di, j+dj))
                    queue.append((i+di, j+dj))
                    mat[i+di][j+dj] = mat[i][j] + 1

        return mat        