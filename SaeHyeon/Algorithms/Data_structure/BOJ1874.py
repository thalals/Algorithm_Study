#Problem : https://www.acmicpc.net/problem/1874
#Comment : 해결

import sys
input=sys.stdin.readline

def main():
    n=int(input())
    idx=1
    arr=[]
    result=[]
    tf=True
    for i in range(n):
        a=int(input())
        while idx <= a:
            arr.append(idx)
            idx+=1
            result.append("+")
        if arr[-1] == a:
            arr.pop()
            result.append("-")
        else:
            tf=False
    
    if tf==False:
        print("NO")
    else:
        for i in range(len(result)):
            print(result[i])


if __name__ == "__main__":
    main()