def solution(mats, park):
    answer = 0
    r = len(park) # park의 행의 개수
    c = len(park[0]) # park의 열의 개수
    
    # print(r,c)
    
    # 돗자리를 깔 수 있는가?
    def check_square(park, start_r, start_c, m):
        for i in range(start_r, start_r + m):
            for j in range(start_c, start_c + m):
                if park[i][j] != "-1":
                    return False # 하나라도 -1이 아니면 실패
        return True

    mats.sort(reverse=True) # mats를 큰 것부터 정렬
    
    for m in mats:
        for i in range(r - m + 1):
            for j in range(c - m + 1):
                if check_square(park,i,j,m):
                    return m
    
    return -1