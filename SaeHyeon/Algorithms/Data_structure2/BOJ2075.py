import heapq

n=int(input())
heap=[]

for i in range(n):
    num=list(map(int,input().split()))

    if not heap:
        for j in num:
            heapq.heappush(heap,j)
        print(heap)
    else:
        for j in num:
            print(heap)
            if heap[0] < j:
                heapq.heappush(heap,j)
                heapq.heappop(heap)

print(heap[0])