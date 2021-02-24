n, k = list(map(int, input().split())) 
coin_types = [] # 종류들
count = 0

for i in range(n):
    coin_types.append(int(input()))

for coin in reversed(range(n)):
    count += k // coin_types[coin] # 카운트 값 + k를 동전으로 나눈 몫
    k %= coin_types[coin]
    # 동전으로 나눈 나머지로 반복

print(count)