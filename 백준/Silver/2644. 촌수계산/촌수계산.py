import sys
input = sys.stdin.readline

n = int(input()) # 전체 사람의 수
a, b = map(int, input().split())
e = int(input()) # 전체 관계의 수

# 1. 인덱스로 접근 가능한 그래프 초기화 (1번부터 n번까지)
graph = [[] for _ in range(n + 1)]

for _ in range(e):
    u, v = map(int, input().split())
    # 무방향 그래프라면 양쪽 다 인덱스에 추가
    graph[u].append(v)
    graph[v].append(u)

# print(graph)
visited = [False] * (n + 1)

path = []

def dfs(now, target):
    visited[now] = True
    path.append(now) # 일단 경로에 추가

    # 목적지(b)를 찾았다면?
    if now == target:
        return True # 찾았다고 신호를 보냄

    for neighbor in graph[now]:
        if not visited[neighbor]:
            # 다음 사람을 찾아봤는데 거기서 target이 나왔다면?
            if dfs(neighbor, target):
                return True # 나도 True를 리턴하며 재귀 종료

    # 이 길로 갔는데 target이 안 나오면? 
    path.pop() # 경로에서 빼버림 (Backtracking)
    return False

dfs(a, b)

# print(path) -> a에서 b까지의 경로가 없으면 path가 []로 len(path) 가 0임
print(len(path) - 1)