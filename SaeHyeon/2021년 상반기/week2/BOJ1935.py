import sys
input=sys.stdin.readline

N=int(input())
line=input()
stack=[]
li=[]
for i in range(0,N):
    t=int(input())
    li.append(t)

for j in line:
    if j.isupper():
        stack.append(li[ord(j)-ord('A')])
    else:
        if j == '+':
            n2=stack.pop()
            n1=stack.pop()
            stack.append(n1+n2)
        elif j == '-':
            n2=stack.pop()
            n1=stack.pop()
            stack.append(n1-n2)
        elif j == '*':
            n2=stack.pop()
            n1=stack.pop()
            stack.append(n1*n2)
        elif j == '/':
            n2=stack.pop()
            n1=stack.pop()
            stack.append(n1/n2)

print("%.2f" %stack[0])
