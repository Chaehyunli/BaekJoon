import sys

# N: 현재 리스트 점수 개수, new_score: 태수의 점수, P: 랭킹 제한 수
n, new_score, p = map(int, sys.stdin.readline().split())

# 리스트가 비어있을 경우 바로 1등
if n == 0:
    print(1)
else:
    scores = list(map(int, sys.stdin.readline().split()))
    
    # 1. 랭킹 진입 가능 여부 확인
    # 리스트가 꽉 찼는데 마지막 점수보다 태수 점수가 낮거나 같으면 진입 불가
    if n == p and scores[-1] >= new_score:
        print(-1)
    else:
        # 2. 등수 계산
        rank = 1
        for s in scores:
            if s > new_score:
                rank += 1
            else:
                break
        print(rank)