import sys
input=sys.stdin.readline

book=[[0]*15 for i in range(5)]

for i in range(5):
    s=list(input().rstrip())
    ls=len(s)
    for j in range(ls):
        book[i][j] = s[j]


for j in range(15):
    for i in range(5):
        if book[i][j] == 0:
            continue
        else:
            print(book[i][j],end='')