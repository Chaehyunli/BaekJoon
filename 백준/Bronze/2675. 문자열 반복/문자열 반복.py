n = int(input())

for _ in range(n):
    R, words = input().split()
    R = int(R)

    P = ""
    for word in words:
        P += word * R

    print(P)
