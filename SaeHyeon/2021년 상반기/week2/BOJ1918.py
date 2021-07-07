import sys
input=sys.stdin.readline

line=input().rstrip()
stack=[]
result=''

for i in range(len(line)):
    if line[i].isalpha():
        result+=line[i]
    else:
        if line[i] == '(':
            stack.append(line[i])
        elif line[i] == '*' or line[i] == '/':
            while stack and (stack[-1] == '*' or stack[-1] =='/'):
                result+=stack.pop()
            stack.append(line[i])
        elif line[i] == '+' or line[i] == '-':
            while stack and stack[-1] != '(':
                result+=stack.pop()
            stack.append(line[i])
        elif line[i] == ')':
            while stack and stack[-1] != '(':
                result+=stack.pop()
            stack.pop()

while stack:
    result+=stack.pop()
print(result)
