def solution(progresses, speeds):
    
    days = []
    answer = []
    
    for i in range(len(progresses)):
        remain = 100 - progresses[i]
        remain_day = (remain - 1) // speeds[i] + 1
        
        days.append(remain_day)
        
    # 기준일
    max_day = days[0] 
    num = 0
    
    for day in days:
        if day <= max_day:
            # 기준일보다 일찍 끝나면 같은 그룹에 포함
            num += 1
        else:
            # 기준일보다 오래 걸리는 작업을 만나면
            # 1. 지금까지 쌓인 작업 개수(num)를 저장
            answer.append(num)
            # 2. 기준일을 현재 작업일로 교체
            max_day = day
            # 3. 새로운 그룹의 첫 번째 작업이므로 num을 1로 초기화
            num = 1
            
    answer.append(num)
            
    return answer