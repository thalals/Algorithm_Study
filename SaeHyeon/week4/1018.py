import sys
input=sys.stdin.readline

M,N=map(int,input().split())
li=[]
for i in range(N):
    li.append(list(input().rstrip()))

cnt=0

for i in range(0,M-1):
    for j in range(0,N-1):
        if li[i][j] == "B":
            if li[i][j+1] != "W":
                cnt+=1
                li[i][j+1] = "W"
            if li[i+1][j] != "W":
                cnt+=1
                li[i+1][j] = "W"
        elif li[i][j] == "W":
            if li[i][j+1] != "B":
                cnt+=1
                li[i][j+1] = "B"
            if li[i+1][j] != "B":
                cnt+=1
            li[i+1][j] = "B"
        
# for i in range(0,M-1):
#     for j in range(0,N-1):
#         if li[i][j] == li[i+1][j]:
#             cnt+=1
#             if li[i+1][j] == "B":
#                 li[i+1][j] = "W"
#             elif li[i+1][j] == "W":
#                 li[i+1][j] = "B"
#         if li[i][j] == li[i][j+1]:
#             cnt+=1
#             if li[i][j+1] == "B":
#                 li[i][j+1] = "W"
#             elif li[i][j+1] == "W":
#                 li[i][j+1] = "B"
        

print(cnt)