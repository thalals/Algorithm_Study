n=1000-int(input())
li=[500,100,50,10,5,1]
cnt=0
for i in li:
    cnt+=n//i
    n%=i

print(cnt)