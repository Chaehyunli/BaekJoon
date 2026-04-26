def solution(today, terms, privacies):
    
    ty, tm, td = map(int, today.split("."))
    today_total = ty * 12 * 28 + tm * 28 + td
    
    type_dict = {s.split()[0]: int(s.split()[1]) * 28 for s in terms}
    
    answer = []
    
    for i in range(len(privacies)):
        day, p_type = privacies[i].split()
        py, pm, pd = map(int, day.split("."))
        
        # 개인정보 수집 일자를 총 일수로 변환
        privacy_total = py * 12 * 28 + pm * 28 + pd
        
        # 파기되어야 할 날짜 계산
        expire_date = privacy_total + type_dict[p_type]
        
        # 오늘 날짜와 비교
        # 파기일이 오늘보다 작거나 같다면 파기 대상
        if expire_date <= today_total:
            answer.append(i + 1) # i는 0부터 시작하므로 +1
            
    return answer