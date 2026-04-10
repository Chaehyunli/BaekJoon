import sys

input = sys.stdin.readline

# 입력 받기
n = int(input())

# 홀수면 상근(SK), 짝수면 창영(CY)
if n % 2 == 1:
    print("SK")
else:
    print("CY")