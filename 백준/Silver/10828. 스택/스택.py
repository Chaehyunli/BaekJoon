import sys

# 명령의 수 N 입력
n = int(sys.stdin.readline())

# 스택으로 사용할 리스트 선언
stack = []

for _ in range(n):
    # 명령어를 한 줄씩 읽어와 공백으로 분리
    command = sys.stdin.readline().split()
    
    cmd_type = command[0]
    
    if cmd_type == 'push':
        # push X: 리스트의 맨 뒤에 X 추가
        stack.append(int(command[1]))
        
    elif cmd_type == 'pop':
        # pop: 가장 위에 있는 수를 빼고 출력 (없으면 -1)
        if not stack:
            print(-1)
        else:
            print(stack.pop())
            
    elif cmd_type == 'size':
        # size: 스택에 들어있는 정수의 개수
        print(len(stack))
        
    elif cmd_type == 'empty':
        # empty: 비어있으면 1, 아니면 0
        print(1 if not stack else 0)
        
    elif cmd_type == 'top':
        # top: 가장 위에 있는 정수 출력 (없으면 -1)
        if not stack:
            print(-1)
        else:
            print(stack[-1])