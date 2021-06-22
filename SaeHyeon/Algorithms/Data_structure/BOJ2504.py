#Problem : https://www.acmicpc.net/problem/2504
#Comment : IndexError뜸

import sys
input=sys.stdin.readline

# 입력이 올바른 괄호열인지 확인하는 함수
def correct(s):
    stack=[]
    cnt=0
    for i in range(len(s)):
        if s[i]=='(' or s[i] == '[':
            stack.append(s[i])
            cnt+=1
        if s[i] == ')':
            if s[i-1] == '[':
                return False
            else:
                stack.pop()
                cnt-=1
        if s[i] == ']':
            if s[i-1] == '(':
                return False
            else:
                stack.pop()
                cnt-=1
    if cnt == 0:
        return True
    else:
        return False

def parentheses(s):
    stack=[]
    cnt=0
    result=[0]
    for i in range(len(s)):
        if s[i] == '(':
            stack.append(2)
            cnt+=1
        elif s[i] == '[':
            stack.append(3)
            cnt+=1
        elif s[i] == ')' or s[i] == ']':
            cnt-=1
        if cnt == 0:
            while stack:
                if len(stack)==1:
                    result[-1]+=stack.pop()
                    break 
                if len(stack)%2 == 0:
                    result[-1] += stack.pop()
                elif len(stack)%2 == 1:
                    result[-1] *= stack.pop()
            result.append(0)
    #print(result)
    return sum(result)


def main():
    st=input().rstrip()
    
    if not correct(st):
        print(0)
    else:
        print(parentheses(st))

if __name__ == '__main__':
    main()