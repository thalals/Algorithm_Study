n=input()
li=[]
for x in n:
    li.append(int(x))

li.sort()
li.reverse()

for i in range(len(li)):
    print(li[i],end='')