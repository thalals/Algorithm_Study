import sys
from math import sqrt
input=sys.stdin.readline().rstrip


def solve(n):
    # ret가 횟수제한(자연수를 넷 홋은 그 이하의 제곱수 합으로 나타내는 것이기 때문)
    ret=4
    for a in range(1,sqrtN+1):
        if a*a==n:
            ret=1

        if ret==1:
            break
        for b in range(1,sqrtN+1):
            if a*a+b*b>n:
                break
            if a*a+b*b==n:
                ret=2
            
            if ret <=2:
                break
            for c in range(1,sqrtN+1):
                if a*a+b*b+c*c>n:
                    break
                if a*a+b*b+c*c==n:
                    ret=3
                    break
    return ret

n=int(input())
sqrtN=int(sqrt(n))
print(solve(n))