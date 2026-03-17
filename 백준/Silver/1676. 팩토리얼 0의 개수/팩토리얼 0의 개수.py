import sys

n = int(sys.stdin.readline())

five = 0 # 소인수 분해 결과 5개 몇개인지 세면 됨

while(n >= 5):
    five += n // 5
    n //= 5 # n을 5로 나눠서 다음 차수(25, 125...)를 준비함

print(five)