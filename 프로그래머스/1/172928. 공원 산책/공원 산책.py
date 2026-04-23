def solution(park, routes):
    
    curr_r, curr_c = 0, 0
    
    h = len(park)
    w = len(park[0])
    
    for i in range(h):
        for j in range(w):
            if park[i][j] == "S":
                curr_r, curr_c = i, j
                break
                
    move = {'N': (-1, 0), 'S': (1, 0), 'W': (0, -1), 'E': (0, 1)}
    
    for route in routes:
        direction, distance = route.split()
        distance = int(distance)
        
        dr,dc = move[direction]
        
        temp_r, temp_c = curr_r, curr_c
        possible = True
        
        # 한 칸씩 이동하며 장애물/경계 확인
        for _ in range(distance):
            nr = temp_r + dr
            nc = temp_c + dc
            
            # 1. 경계를 벗어나는지 확인
            # 2. 장애물('X')을 만나는지 확인
            if 0 <= nr < h and 0 <= nc < w and park[nr][nc] != 'X':
                temp_r, temp_c = nr, nc
            else:
                possible = False
                break
        
        # 모든 이동이 가능하다면 위치 갱신
        if possible:
            curr_r, curr_c = temp_r, temp_c
        
    return [curr_r, curr_c]