n = int(input())

words = set() # 중복, 순서 없음

for i in range(n):
    words.add(input())

words = list(words) # set은 순서가 없기 때문에, list로 변환
words.sort(key=lambda x: (len(x), x))

for word in words:
    print(word)