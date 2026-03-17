def solution(id_list, report, k):
    answer = []
    
    report = set(report)
    
    reported_count = {id: 0 for id in id_list} # 신고당한 횟수 리스트(0으로 초기화)

    user_report_list = {id: [] for id in id_list} # 신고한 사람 리스트
    
    for r in report: # 신고 정보 넣기
        from_ = r.split()[0]
        to_ = r.split()[1]
        reported_count[to_] += 1
        user_report_list[from_].append(to_)
        
    for user_id in id_list:
        mail_count = 0
        
        for reported_user in user_report_list[user_id]: # 내가 신고한 사람들 중에
            if reported_count[reported_user] >= k: # 그 사람이 k번 이상 신고당했다면
                mail_count += 1
                
        answer.append(mail_count)      
    
    return answer