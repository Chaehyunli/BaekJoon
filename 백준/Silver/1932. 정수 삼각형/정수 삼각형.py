import sys

input = sys.stdin.readline

n = int(input()) # 삼각형의 크기

triangle = [list(map(int,input().split())) for _ in range(n)]

dp = [[0] * (n) for _ in range(n)] # dp[i][j] : i행 j열 위치에 도착했을 때 가질 수 있는 경로의 최대 합

dp[0][0] = triangle[0][0] # 시작점까지의 거리는 삼각형의 꼭짓점의 값과 같음

for i in range(1, n):
    for j in range(0, i+1): # i행의 숫자의 수는 i개임
        if j == 0: # 왼쪽 첫 값일 때
            dp[i][j] = dp[i-1][j] + triangle[i][j]
        elif j == i: # 오른쪽 끝 값일 때
            dp[i][j] = dp[i-1][j-1] + triangle[i][j]
        else:
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]
            
# print(dp)
print(max(dp[n-1]))