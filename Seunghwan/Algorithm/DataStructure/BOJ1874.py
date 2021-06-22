import sys

n = int(sys.stdin.readline())
stack = []
result = []
count = 0
temp = 1

for i in range(n):
    num = int(sys.stdin.readline())

    while count < num:
        count += 1
        stack.append(count)
        result.append("+")

    if stack[-1] == num:
            stack.pop()
            result.append["-"]
    else:
        temp = 0
        break
if temp == 0:
    print("NO")    
else:
    for i in result:
        print(i)

