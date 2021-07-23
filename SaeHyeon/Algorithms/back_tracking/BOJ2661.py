import sys
input=sys.stdin.readline

N=int(input())
arr=[]

#좋은 순열인지 나쁜 순열인지 검사하는 함수
def checking(arr,idx):
    for k in range(idx):
        s=arr[k:]
        for j in range(1,len(arr)//2+1):
            check=s[:j]
            if check==s[j:j+j]:
                return False
    return True

def backtracking(idx):

    if not checking(arr,idx):
        return -1

    # 인덱스가 N이랑 같아지면 종료
    if idx==N:
        print(*arr,sep='')
        return 0

    # 1부터 3까지의 수를 넣어야 함
    for i in range(1,4):
        arr.append(i)
        # 좋은 순열이면 다음으로
        if backtracking(idx+1)==0:
            return 0
        arr.pop()

backtracking(0)