#Problem : https://www.acmicpc.net/problem/10828
#Comment : 해결

import sys
input=sys.stdin.readline


def stack(arr,str):
    if str[0] == "push":
        arr.append(str[1])
    if str[0] == "pop":
        if not arr:
            print(-1)
        else:
            print(arr.pop())
    if str[0] == "size":
        print(len(arr))
    if str[0] == "empty":
        if len(arr) == 0:
            print(1)
        else:
            print(0)
    if str[0] == "top":
        if len(arr) == 0:
            print(-1)
        else:
            print(arr[len(arr)-1])


def main():
    n=int(input())
    arr=[]
    for i in range(n):
        s=input().split()
        stack(arr,s)

if __name__ == "__main__":
    main()