import sys
input = sys.stdin.readline

money = int(input())

cash = list(map(int, input().split()))

jmoney, smoney = money, money
jstock, sstock = 0, 0

for i in cash:
    if jmoney >= i:  # 현금으로 살 수 있을때
        jstock += jmoney // i  # 산다.
        jmoney %= i  # 현금에 저장

for i in range(len(cash)-3):
    # Decreased compared to the previous day (All buy)
    if cash[i] > cash[i+1] > cash[i+2]:
        sstock += smoney // cash[i+3]
        smoney %= cash[i+3]

    # Increased compared to the previous day (All sell)
    elif cash[i] < cash[i+1] < cash[i+2]:
        smoney += smoney * cash[i+3]
        sstock = 0


jtotal = [jmoney + (money[-1] * jstock)]  # 준현이 수익
stotal = [smoney + (money[-1] * sstock)]  # 준현이 수익

if jtotal > stotal:
    print("BNP")
elif jtotal < stotal:
    print("TIMING")
else:
    print("SAME")
