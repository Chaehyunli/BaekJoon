def solution(n, w, num):
    
    m = (n - 1) // w + 1 # 상자의 최대 높이
    
    grid = [[0] * w for _ in range(m)]
    
    # print(grid)
    
    current_box = 1 # 현재 박스의 번호
    target = (0,0) # 꺼내려는 박스의 위치를 저장할 변수
    
    for r in range(m):
        if r % 2 == 0:
            for c in range(w): # 0 ~ w-1 까지
                if current_box <= n:
                    grid[r][c] = current_box
                    if current_box == num:
                        target = (r,c)
                    current_box += 1
        else:
            for c in range(w - 1, -1, -1): # w-1 ~ 0 까지
                if current_box <= n:
                    grid[r][c] = current_box
                    if current_box == num:
                        target = (r,c)
                    current_box += 1
    
    target_r,target_c = target
    answer = 0
    
    for i in range(target_r,m):
        if grid[i][target_c]:
            answer += 1
    
    return answer