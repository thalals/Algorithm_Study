import sys
input=sys.stdin.readline

n=int(input())
state=list(input().rstrip())
hope=list(input().rstrip())

def change1(array):
    # 첫번째 전구를 눌렀을 경우
    cnt=1
    array[0] = str(1-int(array[0]))
    array[1] = str(1-int(array[1]))

    for i in range(1,len(array)):
        if array[i-1] == hope[i-1]:
            continue
        else:
            cnt+=1
            array[i-1] = str(1-int(array[i-1]))
            array[i] = str(1-int(array[i]))

            if i < len(array)-1:
                array[i+1] = str(1-int(array[i+1]))
    
    if hope==array:
        return cnt
    else:
        return -1

def change2(array):
    # 첫번째 전구를 눌렀을 경우
    cnt=0

    for i in range(1,len(array)):
        if array[i-1] == hope[i-1]:
            continue
        else:
            cnt+=1
            array[i-1] = str(1-int(array[i-1]))
            array[i] = str(1-int(array[i]))

            if i < len(array)-1:
                array[i+1] = str(1-int(array[i+1]))
    
    if hope==array:
        return cnt
    else:
        return -1


cnt1=change1(state[:])
cnt2=change2(state[:])


if cnt1>=0 and cnt2>=0:
    print(min(cnt1,cnt2))
elif cnt1>=0 and cnt2<0:
    print(cnt1)
elif cnt1<0 and cnt2>=0:
    print(cnt2)
else:
    print(-1)