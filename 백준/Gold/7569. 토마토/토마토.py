import sys
from collections import deque

m, n, h = map(int, sys.stdin.readline().split())

# grid = [[[0 for _ in range(m)] for _ in range(n)] for _ in range(h)] -> 모든 항목을 0으로 채운 3차원 배열

grid = []
queue = deque() # 토마토의 위치 큐

for i in range(h):
    layer = []
    for j in range(n):
        row = list(map(int, sys.stdin.readline().split()))
        for k in range(m):
            # 처음부터 익어있는 토마토(1)를 찾으면 큐에 미리 넣음
            # 위치 정보: (층, 행, 열)
            if row[k] == 1:
                queue.append((i, j, k))
        layer.append(row)
    grid.append(layer)

# print(grid)

dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]

while queue:
    z, y, x = queue.popleft()
    for i in range(6):
        nx = x + dx[i]
        ny = y + dy[i]
        nz = z + dz[i]
        if 0 <= nx < m and 0 <= ny < n and 0 <= nz < h:
            if grid[nz][ny][nx] == 0:
                # 토마토가 익고, 날짜가 1 증가함
                grid[nz][ny][nx] = grid[z][y][x] + 1
                queue.append((nz, ny, nx))

# print(grid)

day = 0
for layer in grid:
    for row in layer:
        for tomato in row:
            if tomato == 0:
                print(-1)
                exit()
        day = max(day, max(row))

print(day - 1)