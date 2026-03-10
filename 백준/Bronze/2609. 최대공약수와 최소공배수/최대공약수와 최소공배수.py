import math

a, b = map(int, input().split())

# math 라이브러리 사용
# print(math.gcd(a,b))
# print(math.lcm(a,b))

# 유클리드 호재법

def gcd(a,b):
    while b > 0:
        a, b = b, a % b
    return a

def lcm(a,b):
    return a * b // gcd(a,b) # 정수 연산을 위해 몫연산자 // 사용

print(gcd(a,b))
print(lcm(a,b))