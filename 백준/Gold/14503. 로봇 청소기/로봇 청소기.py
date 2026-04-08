import sys

input = sys.stdin.readline

def solve():
    # 입력 처리
    n, m = map(int, input().split())
    r, c, d = map(int, input().split())
    
    # 전체 방 상태 입력
    board = [list(map(int, input().split())) for _ in range(n)]
    
    # 북(0), 동(1), 남(2), 서(3) 방향 정의
    dr = [-1, 0, 1, 0]
    dc = [0, 1, 0, -1]
    
    cleaned_count = 0
    
    while True:
        # 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        if board[r][c] == 0:
            board[r][c] = 2  # 청소 완료 표시 (2로 설정)
            cleaned_count += 1
            
        # 주변 4칸 중 청소되지 않은 빈 칸이 있는지 확인
        has_dirty_spot = False
        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            if 0 <= nr < n and 0 <= nc < m:
                if board[nr][nc] == 0:
                    has_dirty_spot = True
                    break
        
        if not has_dirty_spot:
            # 2. 청소되지 않은 빈 칸이 없는 경우
            # 바라보는 방향을 유지한 채로 한 칸 후진
            back_d = (d + 2) % 4
            br, bc = r + dr[back_d], c + dc[back_d]
            
            # 후진할 수 있다면(벽이 아니라면) 한 칸 후진
            if 0 <= br < n and 0 <= bc < m and board[br][bc] != 1:
                r, c = br, bc
                continue # 1번으로 돌아가기
            else:
                # 뒤쪽이 벽이라 후진할 수 없다면 작동 멈춤
                break
        else:
            # 3. 청소되지 않은 빈 칸이 있는 경우
            # 반시계 방향으로 90도 회전
            d = (d + 3) % 4
            
            # 바라보는 방향의 앞쪽 칸 확인
            forward_r, forward_c = r + dr[d], c + dc[d]
            
            # 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
            if 0 <= forward_r < n and 0 <= forward_c < m:
                if board[forward_r][forward_c] == 0:
                    r, c = forward_r, forward_c
            
            # 1번으로 돌아가기 (while문의 처음으로)
            continue

    print(cleaned_count)

solve()