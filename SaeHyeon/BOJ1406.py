# 1차는 시간초과

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
    elif ins[0] == "D":
        if not index == len(text):
            index=index+1
    elif ins[0] == "B":
        text=text[0:index-1] + text[index:]
    elif ins[0] == "P":
        text=text[0:index] + ins[1] + text[index:]
        index+=1
print(text)