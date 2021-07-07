import sys
from collections import deque

card = deque([])

n = int(sys.stdin.readline())

for i in range(n):
    card.append(i+1)

while (1):

    if(len(card)== 1):
        break

    card.popleft()
    card.rotate(-1)


print(card[0])

    
