import sys
from collections import deque

input = sys.stdin.readline

n,m = map(int, input().split()) # 2차원 지역의 가로, 새로 

# grid = [list(map(int, input().split())) for _ in range(n)] # 2차원 지역을 입력받음

grid = []
queue = deque() # 값이 0이 아닌 초기 빙산의 목록

for i in range(n):
    row = list(map(int, input().split()))
    grid.append(row)
            
# print(queue)
    
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def melt():
    """빙산을 한 번 녹이는 함수"""
    melt_list = [] # (x, y, 녹을 높이) 저장
    for x in range(n):
        for y in range(m):
            if grid[x][y] > 0:
                sea_count = 0
                for i in range(4):
                    nx, ny = x + dx[i], y + dy[i]
                    if 0 <= nx < n and 0 <= ny < m:
                        if grid[nx][ny] == 0:
                            sea_count += 1
                melt_list.append((x, y, sea_count))
    
    # 한꺼번에 녹이기 (실시간 반영 방지)
    for x, y, count in melt_list:
        grid[x][y] = max(0, grid[x][y] - count) # 빙산이 녹아서 0보다 작아지먄, 0을 저장
        

def get_island_count():
    """덩어리 개수를 세는 함수 (BFS 사용)"""
    visited = [[False] * m for _ in range(n)]
    count = 0
    
    for i in range(n):
        for j in range(m):
            # 빙산이 있고 아직 방문하지 않은 경우 = 새로운 덩어리 발견
            if grid[i][j] > 0 and visited[i][j] == False:
                count += 1
                # BFS로 연결된 모든 빙산 방문 처리
                queue = deque([(i, j)])
                visited[i][j] = True
                while queue:
                    cx, cy = queue.popleft()
                    for d in range(4):
                        nx = cx + dx[d]
                        ny = cy + dy[d]
                        if 0 <= nx < n and 0 <= ny < m:
                            if grid[nx][ny] > 0 and visited[nx][ny] == False:
                                visited[nx][ny] = True
                                queue.append((nx, ny))
    return count

year = 0

while True:
    island_cnt = get_island_count()
    
    # 덩어리가 2개 이상이면 종료
    if island_cnt >= 2:
        print(year)
        break
    
    # 빙산이 다 녹을 때까지 분리되지 않으면 0 출력 후 종료
    if island_cnt == 0:
        print(0)
        break
    
    # 아직 한 덩어리라면 녹이고 1년 추가
    melt()
    year += 1