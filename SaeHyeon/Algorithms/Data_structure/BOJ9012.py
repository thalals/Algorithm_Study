#Problem : https://www.acmicpc.net/problem/9012
#Comment : 

import sys
input=sys.stdin.readline

def yes_no(s):
    stack=[]
    cnt=0
    for i in s:
        if i=='(':
            stack.append(i)
            cnt+=1
        if i == ')':
            if stack:
                stack.pop()
            cnt-=1
            if cnt == -1:
                return 'NO'
    if cnt == 0:
        return 'YES'
    else:
        return 'NO'

def main():
    t=int(input())
    for i in range(t):
        s=input().rstrip()
        print(yes_no(s))

if __name__ == "__main__":
    main()