import sys
input=sys.stdin.readline

money=int(input())
arr=list(map(int,input().split()))

def BNP(arr,money):
    cnt=0
    for i in range(len(arr)):
        if arr[i] <= money:
            cnt+=(money//arr[i])
            money=money%arr[i]
    return money+(cnt*arr[-1])

def TIMING(arr,money):
    cnt=0
    for i in range(len(arr)-3):
        if arr[i]>arr[i+1]>arr[i+2]:
            cnt+=money//arr[i+3]
            money%=arr[i+3]
        elif arr[i]<arr[i+1]<arr[i+2]:
            money+=cnt*arr[i+3]
            cnt=0
    return money+(arr[-1]*cnt)

if BNP(arr,money)> TIMING(arr,money):
    print("BNP")
elif BNP(arr,money)< TIMING(arr,money):
    print("TIMING")
else:
    print("SAMESAME")