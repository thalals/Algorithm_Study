import sys

n = int(input())
data = input()
temp = [0] * n


for i in range(n):
    temp[i] = int(input())

stack = []

for i in data:
    if i.isupper(): # 피연산자 처리
        stack.append(temp[ord(i) - ord('A')]) # 저장 # ord(A)값을 빼면 몇번째인지 체크가 가능하므로 위처럼 사용
    else: #     연산자처리

        alpha2 = stack.pop()
        alpha1 = stack.pop()
        # 스택에 저장된 피연산자 pop
        if i == '+':
            stack.append(alpha1 + alpha2)
        elif i == '-':
            stack.append(alpha1 - alpha2)
        elif i == '*':
            stack.append(alpha1 * alpha2)
        elif i == '/':
            stack.append(alpha1 / alpha2)

# 소수점 둘째자리까지 출력
print('%.2f' %stack[0])
        