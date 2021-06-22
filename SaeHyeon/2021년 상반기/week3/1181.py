import sys

n=int(sys.stdin.readline())
li=[]
for i in range(n):
    text=str(sys.stdin.readline().strip())
    li.append([len(text),text])

for i in range(len(li)):
    for j in range(i,len(li)):
        if li[i] > li[j]:
             li[i],li[j] = li[j],li[i]

new_li=[]
for v in li:
    if v not in new_li:
        new_li.append(v)

for i in range(len(new_li)):
    print(new_li[i][1])


#시간 초과
