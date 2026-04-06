import sys
from collections import deque

input = sys.stdin.readline

n,m = map(int, input().split()) # n(행), m(열) 입력받기

grid = []

for i in range(n):
    row = list(map(int, input().split()))
    grid.append(row)

# grid = [list(map(int, input().split())) for _ in range(n)] # 리스트 컴프리헨션
       
# print(grid)

queue = deque()

dx = [-1,1,0,0]
dy = [0,0,-1,1]

visited = [[False] * m for _ in range(n)]

count = 0
max_area = 0

for i in range(n):
    for j in range(m):
        if grid[i][j] == 1 and visited[i][j] == False:
            queue.append((i,j))
            count += 1
            visited[i][j] = True  
            area = 0 # 이번 그림의 넓이
            
            while queue:
                x, y = queue.popleft()
                area += 1
                for k in range(4):
                    nx = x + dx[k]
                    ny = y + dy[k]
                    if(0<= nx < n and 0 <= ny < m):
                        if(grid[nx][ny] == 1 and visited[nx][ny] == False):
                            visited[nx][ny] = True
                            queue.append((nx,ny))
            max_area = max(area, max_area)
                        
                
print(count)
print(max_area)      
# print(queue)
