import sys

# N: 웅덩이 개수, L: 널빤지 길이
n, l = map(int, sys.stdin.readline().split())
pools = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

# 1. 시작 위치 기준 정렬
pools.sort()

count = 0     # 필요한 널빤지 개수
last_pos = 0  # 현재 널빤지가 덮고 있는 마지막 위치

for start, end in pools:
    # 2. 이미 이전 널빤지가 이 웅덩이를 다 덮었다면 건너뜀
    if last_pos >= end:
        continue
    
    # 3. 널빤지를 시작할 위치 결정 (웅덩이 시작점 vs 현재 널빤지 끝점 중 더 뒤에 있는 곳)
    curr_start = max(start, last_pos)
    
    # 4. 남은 웅덩이 길이를 덮기 위해 필요한 널빤지 개수 계산
    dist = end - curr_start
    
    # 올림 계산 (널빤지는 잘라 쓸 수 없으므로)
    needed = (dist + l - 1) // l # 필요한 널빤지 개수
    
    count += needed
    last_pos = curr_start + (needed * l)

print(count)