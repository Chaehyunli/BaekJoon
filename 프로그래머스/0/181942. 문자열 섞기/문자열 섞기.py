def solution(str1, str2):
    answer = []
    
    for i in range(len(str1) * 2):
        if i % 2 == 0:
            answer.append(str1[i // 2])
        else:
            answer.append(str2[i // 2])
    
    return "".join(answer)