def solution(name, yearning, photo):
    
    score_dict = dict(zip(name, yearning))
    
    answer = []
    
    for p in photo:
        score = 0;
        for each in p:
            score += score_dict.get(each, 0)
        answer.append(score)

    return answer