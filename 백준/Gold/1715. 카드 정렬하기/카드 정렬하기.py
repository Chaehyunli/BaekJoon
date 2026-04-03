import heapq
n = int(input()) # 카드 묶음 수

cards = [] # 카드 묶음 수 힙

for _ in range(n):
    heapq.heappush(cards, int(input())) # heap은 매 순간 가장 작은 것을 반환함

sum = 0

while len(cards) > 1:
    a = heapq.heappop(cards)
    b = heapq.heappop(cards)
    sum += a + b
    
    pre_sum = a + b # 이전까지의 합을 합에 넣음
    
    heapq.heappush(cards, pre_sum) # 이전까지의 합도 힙에 넣어서 오른차순으로 정렬

print(sum)