import sys
from collections import deque

input = sys.stdin.readline

floor, start, goal, up, down = map(int, input().split()) # 전체 층수, 시작 층, 목표 층, 올라감 버튼, 내려감 버튼

dv = [up, -down]

queue = deque([start])

visited = [-1] * (floor + 1) # 방문 안했으면 -1, 아니면 이동 횟수 저장
visited[start] = 0

while queue:
    current = queue.popleft()
    
    if current == goal:
        print(visited[current])
        break
    
    for i in range(2):
        new_floor = current + dv[i]
        if 1<= new_floor <= floor and visited[new_floor] == -1:
            visited[new_floor] = 1 + visited[current]
            queue.append(new_floor)
            
else:
    print("use the stairs")