# 문제 : BOJ21608
# 내용 : 예시는 맞췄으나 틀림

import sys
input=sys.stdin.readline

N=int(input())
student=[]

for _ in range(N**2):
    student.append(list(map(int,input().split())))

position=[[0]*N for _ in range(N)]

dir_y=[0,0,1,-1]
dir_x=[-1,1,0,0]

r_y,r_x=0,0

dic={}

for i in range(N**2):
    flag=False
    count=[[0]*N for _ in range(N)]
    max_result=0
    # 좋아하는 학생이 position에 있을 시
    # 그 학생과 인접한 자리 검색
    
    for j in range(1,5):
        if student[i][j] in dic.keys():
            flag=True
            r_y,r_x=dic[student[i][j]]
            for k in range(4):
                ny=r_y+dir_y[k]
                nx=r_x+dir_x[k]
                if ny>=0 and ny<N and nx>=0 and nx<N:
                    if position[ny][nx]==0:
                        count[ny][nx]+=1

    # 좋아하는 학생이 자리에 다 없을떄
    if not flag:
        for j in range(N):
                for k in range(N):
                    cnt=0
                    for z in range(4):
                        nj=j+dir_y[z]
                        nk=k+dir_x[z]
                        if nj>=0 and nj<N and nk>=0 and nk<N:
                            if position[nj][nk]==0:
                                cnt+=1
                    if max_result<cnt:
                        max_result=cnt
                        r_y,r_x=j,k
        position[r_y][r_x]=student[i][0] 
        dic[student[i][0]]=[r_y,r_x]
    
    if flag:
        value=0
        result=[]
        for j in range(N):
            for k in range(N):
                if count[j][k]>value:
                    value=count[j][k]
        for j in range(N):
            for k in range(N):
                if count[j][k] == value:
                    result.append([j,k])
        
        if len(result)==1:
            r_y,r_x=result.pop()
            position[r_y][r_x]=student[i][0]
            dic[student[i][0]]=[r_y,r_x]
        else:
            for j in range(len(result)):
                a,b=result[j][0],result[j][1]
                cnt=0
                for k in range(4):
                    na=a+dir_y[k]
                    nb=b+dir_x[k]
                    if na>=0 and na<N and nb>=0 and nb<N:
                        if position[na][nb]==0:
                            cnt+=1
                result[j].append(cnt)
            result.sort(key=lambda x:(-x[2],x[0],x[1]))
            r_y,r_x=result[0][0],result[0][1]    
            position[r_y][r_x]=student[i][0]
            dic[student[i][0]]=[r_y,r_x]

# 만족도 구하기
sum_value=0
for i in range(N**2):
    value=0
    for j in range(N):
        for k in range(N):
            if student[i][0] == position[j][k]:
                for z in range(4):
                    nj=j+dir_y[z]
                    nk=k+dir_x[z]
                    if 0<=nj<N and 0<=nk<N:
                        if position[nj][nk] in student[i]:
                            value+=1
    if value==0:
        sum_value+=0
    elif value==1:
        sum_value+=1
    elif value==2:
        sum_value+=10
    elif value==3:
        sum_value+=100
    else:
        sum_value+=1000
print(sum_value)