# 입력
#   첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다.
#   합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.
# 출력
#   첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.


from itertools import combinations 
# 조합 : 서로다른 n개에서 서로다른 r개 (순서상관없이)



n, m = map(int,input().split()) # n, m 입력

data = list(map(int,input().split())) # 카드 입력
# print(list(combinations(data,3)))
answer = 0 # 정답 초기화
for num in combinations(data,3): # data에서 서로다른 3개 뽑는 조합
    data_sum = sum(num) # 해당 조합의 합
    if answer < data_sum <= m: # 최대한 근접하게 식을 짜준다
        answer = data_sum

print(answer)

