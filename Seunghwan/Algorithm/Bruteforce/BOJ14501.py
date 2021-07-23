import sys

input = sys.stdin.readline

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

    if index > n:
        return
    if index == n:
        ans = max(ans, profit)
        return
    sol(index + 1, profit)
    sol(index + time[index], profit + pay[index])

sol(0, 0)
print(ans)