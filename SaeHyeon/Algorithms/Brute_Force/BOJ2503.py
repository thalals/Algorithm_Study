import sys
from itertools import permutations

input=sys.stdin.readline

n=int(input())
num=list(permutations([1,2,3,4,5,6,7,8,9],3))
#print(num)

for i in range(n):
    t_num,strike,ball=map(int,input().split())
    t_num=list(str(t_num))
    remove=0

    for j in range(len(num)):
        s_cnt,b_cnt=0,0
        j -= remove

        for k in range(3):
            t_num[k] = int(t_num[k])
            if t_num[k] in num[j]:
                if k==num[j].index(t_num[k]):
                    s_cnt+=1
                else:
                    b_cnt+=1

        if s_cnt !=strike or b_cnt!=ball:
            num.remove(num[j])
            remove+=1

print(len(num))