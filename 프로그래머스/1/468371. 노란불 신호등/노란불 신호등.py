import math

def solution(signals):
    
    periods = [sum(s) for s in signals]
    
    max_time = periods[0] # 모든 신호등의 주기의 최소공배수 계산
    for i in range(1, len(periods)):
        max_time = (max_time * periods[i]) // math.gcd(max_time, periods[i])
    
    for t in range(1, max_time + 1):
        all_yellow = True
        
        for i in range(len(signals)):
            g, y, r = signals[i]
            cycle = g + y + r
            
            offset = t % cycle # 1 ~ t-1
            
            if not (g < offset <= g + y): # 노란 범위에 있지 않으면
                all_yellow = False
                break
                
        if all_yellow:
            return t

    return -1