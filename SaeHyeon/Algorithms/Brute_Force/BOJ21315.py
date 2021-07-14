import sys
from itertools import permutations
input=sys.stdin.readline

N=int(input())
number=[i for i in range(1,N+1)]
card=list(map(int,input().split()))

def solve(dumy_card,k):
    #첫번쨰 단계
    for i in range(2**k):
        dumy_card.insert(0,dumy_card.pop())
    
    #print(dumy_card)
    for i in range(2,k+2):
        for j in range(2**(k-i+1)):
            try:
            #print(i,j)
                dumy_card.insert(0,dumy_card.pop(2*(2**(k-i+1))-1))
            except IndexError:
                continue
    #print(dumy_card)
    return dumy_card
    

def shuffle():
    for i in permutations(number,2):
        dumy_card=[i for i in range(1,N+1)]
        if card == solve(solve(dumy_card,i[0]),i[1]):
            print(i[0],end=' ')
            print(i[1])
            break

shuffle()