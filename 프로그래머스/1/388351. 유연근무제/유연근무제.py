def solution(schedules, timelogs, startday):
    
    answer = 0
    
    num_employees = len(schedules)
    
    for i in range(num_employees):
        # 1. 목표 시간(분) 계산: (시간 * 60) + 분 + 10분 여유
        target_minutes = (schedules[i] // 100) * 60 + (schedules[i] % 100) + 10
        
        isEnable = True
        
        for day in range(7):
            # 월 1, 화 2, 수 3, 목 4, 금 5, 토 6, 일 7
            current_day = (startday + day - 1) % 7 + 1
            
            if current_day == 6 or current_day == 7: # 토, 일은 검사 x
                continue
                
            actual_minutes = (timelogs[i][day] // 100) * 60 + (timelogs[i][day] % 100)
            
            if actual_minutes > target_minutes:
                isEnable = False
                break
                
        if isEnable:
            answer += 1           
    
    return answer