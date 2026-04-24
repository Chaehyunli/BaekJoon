def solution(cards1, cards2, goal):
    
    n1 = 0
    n2 = 0
    
    for word in goal:
        if n1 < len(cards1) and word == cards1[n1]:
            n1 += 1
            
        elif n2 < len(cards2) and word == cards2[n2]:
            n2 += 1
            
        else:
            return "No"
        
    return "Yes"