# dp를 찾아보던 중 브루트포스로 푼 정답을 찾음
# 이해만 하면 상당히 괜찮다고 생각함

n = int(input())
time = []
pay = []
ans = 0

for _ in range(n):
    t,p = map(int,input().split())
    time.append(t)
    pay.append(p)


def sol(index, profit):
    global ans

    if index > n: # index 가 n을 넘은 경우 종료
        return
    if index == n: # index+t[i]가 n보다 작은 경우 계속
        ans = max(ans, profit)
        return
    sol(index + 1, profit)
    sol(index + time[index], profit + pay[index])

sol(0, 0)
print(ans)
