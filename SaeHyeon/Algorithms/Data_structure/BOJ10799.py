#Problem : https://www.acmicpc.net/problem/10799
#Comment : 해결

import sys
input=sys.stdin.readline

def lazor(s):
    stack=[]
    cnt=0
    for i in range(len(s)):
        if s[i]=="(":
            stack.append(i)
        if s[i]==")":
            stack.pop()
            if s[i-1]=='(':
                cnt+=len(stack)
            else:
                cnt+=1    
    return cnt
    
def main():
    iron_stick=input().rstrip()
    print(lazor(iron_stick))

if __name__ == '__main__':
    main()