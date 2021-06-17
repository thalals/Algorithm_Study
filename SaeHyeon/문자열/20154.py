import sys
input=sys.stdin.readline

#알파벳 대문자로만 이루어진 문자열
#각 문자의 획수로 문자를 변환
#단어의 짝기리 획을 더하고 짝이 안지어지면 다음 단계로 스킵
#그렇게 마지막 수가 홀수면은 이기고 짝수면은 지는 게임

alpha=[3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1]

s=list(input().rstrip())
value=[]

#ord('A') == 65

for i in range(len(s)):
    value.append(alpha[(ord(s[i])-65)]) 

result=0
for i in value:
    result+=i

if result%2==0:
    print("You're the winner? ")
else:
    print("I'm a winner! ")

