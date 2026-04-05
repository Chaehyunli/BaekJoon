import sys
from collections import deque

def solve():
    n = int(sys.stdin.readline())  # 편의점 개수
    
    # 집, 편의점, 페스티벌 좌표 순서대로 입력
    home = list(map(int, sys.stdin.readline().split()))
    conv = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
    festival = list(map(int, sys.stdin.readline().split()))
    
    # 모든 목적지 후보 (편의점 + 페스티벌)
    destinations = conv + [festival]
    visited = [False] * (n + 1)
    
    queue = deque([home])
    
    while queue:
        curr_x, curr_y = queue.popleft()
        
        # 현재 위치에서 페스티벌에 바로 갈 수 있는지 먼저 확인해도 좋지만,
        # 루프 내에서 처리하는 게 깔끔합니다.
        if [curr_x, curr_y] == festival:
            print("happy")
            return

        for i in range(n + 1):
            if not visited[i]:
                nx, ny = destinations[i] # 모든 목적지로부터의 거리를 계산해야함
                # 맨해튼 거리 계산
                dist = abs(curr_x - nx) + abs(curr_y - ny)
                
                # 1,000m 이내라면 이동 가능
                if dist <= 1000:
                    visited[i] = True
                    queue.append([nx, ny])
                    
    print("sad")

t = int(sys.stdin.readline())
for _ in range(t):
    solve()