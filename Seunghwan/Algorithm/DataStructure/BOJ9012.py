import sys

t = int(sys.stdin.readline())

for _ in range(t):
    data = list(sys.stdin.readline())

    value = 0

    for i in data:
        if i == "(":
            value += 1
        elif i == ")":
            value -= 1
        if value < 0: # 애초에 괄호가 잘못된 경우를 체크
            print("NO")
            break
     
    if value > 0:
        print("NO")    
    elif value == 0:
        print("YES")
      
    
