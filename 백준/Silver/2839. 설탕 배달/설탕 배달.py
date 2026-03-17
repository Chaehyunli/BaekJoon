n = int(input())

count = 0

while n >= 0: # n이 0이되어는 경우(3개 짜리로만 구성된 경우)에도 if문 안으로 들어와야 함
    if(n % 5 == 0):
        count += n // 5
        print(count)
        break

    n -= 3
    count += 1
else:
    print(-1)