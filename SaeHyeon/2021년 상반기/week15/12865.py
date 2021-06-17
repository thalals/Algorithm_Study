import sys
input=sys.stdin.readline

n,k=map(int,input().split())
weight=[]
value=[]

def knapsack():
    array=[[0]*k+1 for i in range(n)]
    
    # for i in range(n):
    #     for j in range(k+1):
    #         if j==weight[i]:
    #             array[i][j]==value[i]
    
    print(array)

for i in range(n):
    a,b=map(int,input().split())
    weight.append(a)
    value.append(b)

knapsack()
