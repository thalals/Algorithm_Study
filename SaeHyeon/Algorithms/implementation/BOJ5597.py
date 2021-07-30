import sys
input=sys.stdin.readline

arr=[i for i in range(1,31)]

for _ in range(28):
    n=int(input())
    arr.remove(n)

for i in range(len(arr)):
    print(arr[i])