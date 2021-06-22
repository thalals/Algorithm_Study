import sys
input=sys.stdin.readline

t=int(input())
word=[]

for _ in range(t):
    s=input().rstrip()
    word.append(s)

new_word=list(set(word))

# new_word.sort(key=lambda x:len(x))
# new_word.sort(key=lambda x: x)

e=sorted(new_word, key=lambda x: (len(x),x))

for i in e:
    print(i)


