# 모든 경우의 수를 파악하는 알고리즘이므로 탐색한 부분에 있어서
# 마저 탐색했는지 표시를 해줘야 함

import sys
input = sys.stdin.readline

N, M = map(int, input().split())

num_list = [i + 1 for i in range(N)] 
check_list = [False] * N              

arr = []

def dfs(cnt):
    if(cnt == M):
        print(*arr)
        return
    
    for i in range(0, N):
        if(check_list[i]):
            continue
        
        check_list[i] = True
        arr.append(num_list[i])
        dfs(cnt + 1)
        arr.pop()
        #print(arr)
        #print(check_list)
        check_list[i] = False  
        
dfs(0)