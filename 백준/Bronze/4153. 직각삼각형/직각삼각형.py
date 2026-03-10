while(True):
    sides = list(map(int, input().split()))

    if sides[0] == 0 and sides[1] == 0 and sides[2] == 0:
        break

    sides.sort()
    a = sides[0]
    b = sides[1]
    c = sides[2]

    if c*c == a*a + b*b:
        print("right")
    else:
        print("wrong")