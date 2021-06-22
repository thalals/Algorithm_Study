import sys
input=sys.stdin.readline

class Node:
    def __init__(self,data):
        self.data=data
        self.child=None
        self.parent=None
    
# 루트 노드가 하나여야 함
# 들어오는 간선이 2개면 안됨
# 노드의 개수가 간선의 개수보다 하나 적어야함

def Tree_Check():
    isInput=True
    tree={}

    li=[]
    while True:
        buf=input().rstrip().split()
        #print(buf)
        for i in range(0,len(buf),2):
            a,b=int(buf[i]),int(buf[i+1])
            #print(a,b)
            if a==0 and b==0:
                break
            elif a<0 and b<0:
                isInput=False
                break
            

        if isInput ==False:
            break
        #         print(temp)
        #     if a == 0 and b == 0:
        #         isInput=False
        #         break

check=Tree_Check()
print(check)