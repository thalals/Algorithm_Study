import sys

input = sys.stdin.readline
n, m = map(int , input().split())

data = []

for i in range(n):
    data.append(list(map(str, input())))

count = 0
tmp = 0
result = ''
for i in range(m):
    a, c, g, t = 0, 0, 0, 0
    for j in range(n):
        if data[j][i] == 'T':
            t += 1
        elif data[j][i] == 'A':
            a += 1    
        elif data[j][i] == 'G':
            g += 1    
        elif data[j][i] == 'C':
            c += 1    
    if max(a,c,g,t) == a:
        result += 'A'
        tmp += c + g + t
    elif max(a,c,g,t) == c:
        result += 'C'
        tmp += a + g + t
    elif max(a,c,g,t) == g:
        result += 'G'
        tmp += c + c + t
    elif max(a,c,g,t) == t:
        result += 'T'
        tmp += c + g + a

print(result)
print(tmp)


