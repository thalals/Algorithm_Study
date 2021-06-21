#Problem : https://www.acmicpc.net/problem/1935
#Comment : 해결

import sys
input=sys.stdin.readline


#def postfix():

def main():
    n=int(input())
    notation=input()
    stack=[]
    li=[]
    for i in range(n):
        num=int(input())
        li.append(num)

    for j in notation:
        if j.isupper():
            stack.append(li[ord(j)-ord('A')])
        else:
            if j == '+':
                b,a=stack.pop(),stack.pop()
                stack.append(a+b)
            if j == '-':
                b,a=stack.pop(),stack.pop()
                stack.append(a-b)
            if j == '*':
                b,a=stack.pop(),stack.pop()
                stack.append(a*b)
            if j == '/':
                b,a=stack.pop(),stack.pop()
                stack.append(a/b)

    print("%.2f" %stack[0])
        


if __name__ == '__main__':
    main()