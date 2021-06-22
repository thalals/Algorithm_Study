# 1차는 시간초과
# 2차 수정방향 -> 리스트 2개 사용해서 붙이기
import sys
input=sys.stdin.readline

text=input().strip()
M=int(input())
index=len(text)

for i in range(0,M):
    ins=input().split()
    if ins[0] == "L":
        if not index == 0:
            index=index-1
            print(text)
    elif ins[0] == "D":
        if not index == len(text):
            index=index+1
            print(text)
    elif ins[0] == "B":
        if not index == 0:
            text=text[0:index-1] + text[index:]
            print(text)
        else:
            continue
    elif ins[0] == "P":
        text=text[0:index] + ins[1] + text[index:]
        print(text)
        index+=1
print(text)