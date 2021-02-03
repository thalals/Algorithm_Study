n = int(input())

_end= 666


while(n):
    if '666' in str(_end): # 666이 있다면
        n -= 1 # n에서 하나씩 빠짐
    _end += 1 # 666 이 없으면 하나씩증가

print(_end-1)