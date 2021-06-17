import sys
input=sys.stdin.readline
result=[]
while(True):
    sen=input().rstrip()
    if sen == 'END':
        break
    result.append(sen[::-1])

for i in range(len(result)):
    print(result[i])