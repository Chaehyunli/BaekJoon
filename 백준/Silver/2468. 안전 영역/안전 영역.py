import sys
from collections import deque

# sys.stdin.read().splitlines() 대신 readline을 사용합니다.
input = sys.stdin.readline

# 1. 데이터 입력 받기
line = input().strip()
if not line:
    exit()

n = int(line) # 첫 번째 줄: 격자 크기 N
grid = []
max_height = 0

# 한 줄씩 읽어서 grid 생성 및 최고 높이 파악
for _ in range(n):
    row = list(map(int, input().split()))
    grid.append(row)
    for h in row:
        if h > max_height:
            max_height = h

# 상하좌우 이동 방향 정의
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

max_safe_zones = 1 # 비가 오지 않아 아무도 안 잠길 때 기본 영역은 1개

# 2. 물의 높이(h)를 1부터 max_height까지 바꿔가며 탐색
for h in range(1, max_height + 1):
    visited = [[False] * n for _ in range(n)]
    current_safe_zones = 0
    
    for i in range(n):
        for j in range(n):
            # 물의 높이 h보다 높고, 아직 방문하지 않은 육지 발견!
            if grid[i][j] > h and not visited[i][j]:
                current_safe_zones += 1
                
                # BFS 탐색 시작
                queue = deque([(i, j)])
                visited[i][j] = True
                
                while queue:
                    r, c = queue.popleft()
                    for k in range(4):
                        nr, nc = r + dr[k], c + dc[k]
                        
                        if 0 <= nr < n and 0 <= nc < n:
                            if not visited[nr][nc] and grid[nr][nc] > h:
                                visited[nr][nc] = True
                                queue.append((nr, nc))
    
    # 최댓값 갱신
    if current_safe_zones > max_safe_zones:
        max_safe_zones = current_safe_zones

# 3. 결과 출력
print(max_safe_zones)