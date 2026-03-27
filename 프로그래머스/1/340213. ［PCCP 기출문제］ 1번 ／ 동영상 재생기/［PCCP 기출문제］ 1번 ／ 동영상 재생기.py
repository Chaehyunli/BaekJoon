def to_seconds(time_str):
    minutes, seconds = map(int, time_str.split(":"))
    return minutes * 60 + seconds

def solution(video_len, pos, op_start, op_end, commands):
    # 1. 모든 시간을 미리 초 단위 숫자로 변환
    video_limit = to_seconds(video_len)
    pos_times = to_seconds(pos)
    op_start_sec = to_seconds(op_start)
    op_end_sec = to_seconds(op_end)
    
    if op_start_sec <= pos_times <= op_end_sec:
        pos_times = op_end_sec

    for command in commands:
        if command == "prev":
            if pos_times >= 10:
                pos_times -= 10
            else:
                pos_times = 0
        
        elif command == "next":
            if pos_times <= video_limit - 10:
                pos_times += 10
            else:
                pos_times = video_limit
        
        if op_start_sec <= pos_times <= op_end_sec:
            pos_times = op_end_sec
                
    # 3. 결과 포맷팅
    answer_minutes = pos_times // 60
    answer_seconds = pos_times % 60
    
    # f-string 사용 (이미 결과는 문자열)
    answer = f"{answer_minutes:02d}:{answer_seconds:02d}"
    
    return answer