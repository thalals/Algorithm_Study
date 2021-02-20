import sys
input=sys.stdin.readline

n1=int(input())
li1=sorted(map(int,input().split())) # 찾아야 될 리스트
n2=int(input())
li2=map(int,input().split()) # 찾을 값


def binarySearch(j,li1,left,right):
    if left > right:
        return 0
    mid = (left+right)//2
    if j == li1[mid]:
        return 1
    elif j > li1[mid]:
        return binarySearch(j,li1,left,mid-1)
    else:
        return binarySearch(j,li1,mid+1,right)

for i in li2:
    left=0
    right=len(li1)-1
    print(binarySearch(i,li1,left,right))
