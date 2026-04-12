from collections import deque
import sys

input = sys.stdin.readline

n = int(input()) # 지도의 크기
grid = [list(map(int, input().split())) for _ in range(n)] # 지도 grid
visited = [[False] * n for _ in range(n)] # 방문했는지

# print(grid)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 섬 구분하기
def color_islands(x,y,count): # (x,y) : bfs 시작 노드, count: bfs로 찾은 섬들을 count를 숫자로 표시(구분)
    queue = deque([(x,y)])
    visited[x][y] = True
    grid[x][y] = count # 해당 (x,y) 칸을 count로 색칠
    
    while queue:
        cx, cy = queue.popleft()
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if grid[nx][ny] == 1 and visited[nx][ny] == False:
                    visited[nx][ny] == True
                    grid[nx][ny] = count
                    queue.append((nx,ny))

islands_count = 2
for i in range(n): # 모든 땅(1)에 대해서 섬 구분해서 숫자 칠하기 
    for j in range(n):
        if grid[i][j] == 1 and visited[i][j] == False:
            color_islands(i,j,islands_count)
            islands_count += 1


# print(grid) # 섬들이 숫자 2,3,4.. 로 구분되어 있음(1은 없음)

#  가장 짧은 다리 찾기
def get_shorest_bridge(island_num): # island_num : 섬의 숫자(2,3,4..)
    dist = [[-1] * n for _ in range(n)] # n * n 의 거리 grid
    queue = deque()
    
    for i in range(n):
        for j in range(n):
            if grid[i][j] == island_num:
                queue.append((i,j)) 
                dist[i][j] = 0 # 섬의 땅에는 0으로 거리 표시
                
    while queue:
        cx, cy = queue.popleft()
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                # 다른 숫자의 섬을 만나면
                if grid[nx][ny] > 0 and grid[nx][ny] != island_num:
                    return dist[cx][cy]
                
                # 바다이면
                if grid[nx][ny] == 0 and dist[nx][ny] == -1:
                    dist[nx][ny] = dist[cx][cy] + 1
                    queue.append((nx,ny))
                    
    return float('inf')

# 모든 섬에서 최단 거리를 찾아서 최솟값 찾기
answer = float('inf')
for i in range(2, islands_count): # 섬이 3개일 경우 , islands_count는 4였음
    answer = min(answer, get_shorest_bridge(i))
    
print(answer)
                
    