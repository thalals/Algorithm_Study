import sys
input=sys.stdin.readline

def BNP(money,today):
    cnt=0
    for i in today:
        if money >= i:
            cnt+=money//i
            money%=i
    return money+(today[-1]*cnt)
def threethree(money,today):
    cnt=0
    for i in range(len(today)-3):
        if today[i]>today[i+1]>today[i+2]:
            cnt+=money//today[i+3]
            money%=today[i+3]
        elif today[i]<today[i+1]<today[i+2]:
            money+=cnt*today[i+3]
            cnt=0
    return money+(today[-1]*cnt)

money=int(input())
today_value=[*map(int,input().split())]

if BNP(money,today_value) > threethree(money,today_value):
    print('BNP')
elif BNP(money,today_value) < threethree(money,today_value):
    print('TIMING')
else:
    print('SAMESAME')