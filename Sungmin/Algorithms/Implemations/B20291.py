n=int(input())
dict={}
for i in range(n):
    A,B=map(str,input().split('.'))
    if B in dict:
        dict[B]+=1
    else:
        dict[B]=1
sdict=sorted(dict.items())
for x,y in sdict:
    print(x,y)