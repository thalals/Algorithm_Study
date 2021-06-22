import sys
input=sys.stdin.readline

t_h,t_m,t_s=map(int,input().split(':'))
g_h,g_m,g_s=map(int,input().split(':'))

time=t_h*60*60+t_m*60+t_s
goal=g_h*60*60+g_m*60+g_s

if goal > time:
    result=goal-time
else:
    result=goal-time+(24*60*60)

h=result//60//60
m=result//60%60
s=result%60

print("%02d:%02d:%02d" %(h,m,s))

