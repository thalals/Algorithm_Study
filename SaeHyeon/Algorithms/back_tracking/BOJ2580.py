# 문제 : BOJ2580
# 내용 : 첫번째는 틀림, 틀린 뒤로 다른 사람 코드를 참고하여 
#       부족한 부분을 채워서 해결했음

import sys
input=sys.stdin.readline

sdoku=[]
for _ in range(9):
    sdoku.append(list(map(int,input().split())))

ex=[]
for i in range(9):
    for j in range(9):
        if sdoku[i][j]==0:
            ex.append([i,j])

def checking(a,b):
    number=[1,2,3,4,5,6,7,8,9]
    
    for i in range(9):
        # 가로
        if sdoku[a][i] in number:
            number.remove(sdoku[a][i])
        # 세로
        if sdoku[i][b] in number:
            number.remove(sdoku[i][b])

    # 3x3
    a=a//3
    b=b//3
    
    for i in range(a*3,(a+1)*3):
        for j in range(b*3,(b+1)*3):
            if sdoku[i][j] in number:
                number.remove(sdoku[i][j])

    return number
flag=False
# 참고
def backtracking(idx):
    global flag

    # 이 부분을 참고하지 않았을 때는 틀렸음
    # 아래 idx값이 len(ex)값과 같았을 때는 return을 해주지만
    # 저 부분을 나온 뒤로는 return하는 부분이 없어서 틀린거로 생각
    # 그렇기 때문에 출력시킨 뒤로 boolean변수를 써서 
    # 0인 부분을 다 확인했다면 나머지도 다 return하게 해준다.
    if flag:
        return 

    if idx==len(ex):
        for i in sdoku:
            print(*i)
        flag=True
        return
    a,b=ex[idx]
    li_number=checking(a,b)

    for num in li_number:
        sdoku[a][b]=num
        backtracking(idx+1)
        sdoku[a][b]=0

backtracking(0)
