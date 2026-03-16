n = int(input())

members = []

for i in range(n):
    age, name = input().split()
    age = int(age)
    members.append((age, name))

# members.sort(key=lambda x: (x[0], x[1])) # x[0] 인 age로 먼저 정렬, age가 같으면 name으로 정렬

members.sort(key=lambda x: x[0]) # x[0] 인 age로 먼저 정렬, age가 같으면 먼저 가입한 사람이 우선

for member in members:
    print(member[0], member[1]) # 각 member의 age와 name을 뽑음