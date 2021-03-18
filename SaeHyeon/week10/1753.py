import sys
import heapq
input=sys.stdin.readline

INF=sys.maxsize

def Dijkstra(di,k):
    dist=[INF]*len(di)
    #print(dist)
    queue=[]
    dist[k]=0
    heapq.heappush(queue,[0,k])
    #print(queue)

    while queue:
        #current는 현재까지의 거리, here는 지금 있는곳의 정점
        current,here=heapq.heappop(queue)

        #items함수는 key,value쌍 얻음
        for there,length in di[here].items():
            #print(there,length)
            next_di=dist[here]+length
            
            if next_di <dist[there]:
                dist[there]=next_di
                heapq.heappush(queue,[next_di,there])
    
    return dist


v,e=map(int,input().split())
k=int(input())
di = [{} for _ in range(v+1)]

for i in range(e):
    u,v,w=map(int,input().split())
    if v in di[u]:
        di[u][v] = min(di[u][v],w)
    else:
        di[u][v] = w
#print(di)
dist=Dijkstra(di,k)

for i in dist[1:]:
    print(i if i!=INF else "INF")


