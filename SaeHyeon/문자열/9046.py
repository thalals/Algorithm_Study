import sys
input=sys.stdin.readline

t=int(input())

for _ in range(t):
    s=input()
    alpha=[0]*26

    for c in s:
        #isalpha는 알파벳인지 확인하는 함수
        #ord는 아스키 코드로 변환
        #chr는 숫자에 맞는 아스키 코드를 변환
        if c.isalpha():
            alpha[ord(c)-ord('a')] += 1
    top=max(alpha)
    
    if alpha.count(top) < 2:
        print(chr(ord('a')+alpha.index(top)))
    else:
        print('?')