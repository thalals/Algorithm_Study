import sys

n=int(sys.stdin.readline())

li=[]
for i in range(n):
    li.append(int(sys.stdin.readline()))

def a(li):
    print(round(sum(li)/len(li)))

def b(li):
    li.sort()
    mid=li[len(li)//2]
    print(mid)

def c(li):
    mi=[]
    be=[[0] for i in range(4001)]
    for i in range(len(li)):
        be[li[i]]=li.count(li[i])
        mi.append(li[i])
    
    

def d(li):
    print(max(li)-min(li))

a(li)
b(li)
#c(li)
d(li)