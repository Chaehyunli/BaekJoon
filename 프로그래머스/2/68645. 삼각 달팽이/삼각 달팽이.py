def solution(n):
    
    triangle = []
    for i in range(1, n + 1):
        row = [0] * i
        triangle.append(row)
        
    row = -1
    col = 0
    num = 1
    
    for i in range(n):
        for j in range(i, n):
            # i % 3에 따라 방향 결정
            if i % 3 == 0:    # 아래로 이동
                row += 1
            elif i % 3 == 1:  # 오른쪽으로 이동
                col += 1
            elif i % 3 == 2:  # 대각선 위로 이동
                row -= 1
                col -= 1
            
            triangle[row][col] = num
            num += 1
    
    answer = []
    for row_list in triangle:      
        for value in row_list:     
            answer.append(value)   
            
    # answer = [value for row_list in simple_list for value in row_list]
    
    return answer