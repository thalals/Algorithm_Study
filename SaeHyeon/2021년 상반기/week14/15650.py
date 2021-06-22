# 모든 경우의 수를 파악하는 알고리즘이므로 탐색한 부분에 있어서
# 마저 탐색했는지 표시를 해줘야 함

import sys
input = sys.stdin.readline

N, M = map(int, input().split())

num_list = [i + 1 for i in range(N)]  #1부터 N까지 값으로 리스트 안을 초기화
check_list = [False] * N              #check_list란 리스트를 입력받은n만큼 false로 초기화

arr = []

def dfs(cnt):
    # 주어진 개수만큼 채워지면 출력한다
    if(cnt == M):
        print(*arr)
        return
    
    for i in range(0, N):
        if(check_list[i]):
            continue
        
        # i번째는 거쳐갈거라서 True로 바꾼다.
        check_list[i] = True
        arr.append(num_list[i])
        dfs(cnt + 1)
        arr.pop()
        #print(arr)
        #print(check_list)
        #check_list[i] = False   #check_list를 초기화 해줘야 함
        for j in range(i+1,N):
            check_list[j]=False
        
dfs(0)