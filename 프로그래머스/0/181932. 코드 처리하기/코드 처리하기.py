def solution(code):
    answer = []
    
    mode = True # True -> 0, False -> 1
    
    for i in range(len(code)):
        
        if code[i] == "1":
            mode = not mode
            continue
        
        if mode:
            if i % 2 == 0:
                answer.append(code[i])
        else:
            if i % 2 == 1:
                answer.append(code[i])
                
    if not answer:
        return "EMPTY"
    
    return "".join(answer)