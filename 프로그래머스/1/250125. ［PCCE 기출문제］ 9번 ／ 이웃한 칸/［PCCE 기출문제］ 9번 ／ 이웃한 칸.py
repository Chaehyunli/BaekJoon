def solution(board, h, w):
    size = len(board) # 보드의 길이
    
    count = 0 # 색칠된 칸의 개수
    
    color = board[h][w]
    
    dh = [0, 0, -1, 1]
    dw = [1, -1, 0 , 0]
    
    for i in range(4):
        nh = h + dh[i]
        nw = w + dw[i]
        
        if 0 <= nh < size and 0 <= nw < size:
            if board[nh][nw] == color:
                count += 1
    
    return count