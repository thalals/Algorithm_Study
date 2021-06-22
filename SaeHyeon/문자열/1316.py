import sys
input=sys.stdin.readline

t=int(input())
cnt=0
for _ in range(t):
    s=input().rstrip()
    for i in range(len(s)):
        if i != len(s)-1:
            if s[i] == s[i+1]:
                pass
            elif s[i] in s[i+1:]:
                break
        else:
            cnt+=1

print(cnt)