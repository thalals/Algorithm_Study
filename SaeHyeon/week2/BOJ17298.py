import sys
input=sys.stdin.readline

n=int(input())
li=list(map(int,input().split()))

#print(li)
result=[-1 for i in range(0,n)]
max=[]
#print(result)

for i in range(0,n):
    #print(max[-1])
    #print(li[max[-1]],li[i])
    print(i)
    print(max)
    print('-----------')
    while max and li[max[-1]] < li[i]:
        print(max[-1],i)
        print(li[max[-1]], li[i])
        result[max.pop()]=li[i]
    
    max.append(i)
    print(max)

for i in range(n):
    print(result[i],end=" ")

# print(max)