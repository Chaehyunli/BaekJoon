n = int(input())

# s, m, l, xl, xxl, xxxxl
sizes = list(map(int, input().split()))

t, p = map(int, input().split())

T = int(0)
P = int(0)

for size in sizes:
    T += (size - 1) // t + 1

P1 = n // p 
P2 = n % p

print(T)
print(P1, P2)