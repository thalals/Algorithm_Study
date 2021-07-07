import sys
input=sys.stdin.readline

stack=[]

it=input()
cnt=0

for i in range(len(it)):
    if it[i]=='(':
        stack.append(i)
    elif it[i]==')':
        stack.pop()
        if it[i-1]== '(':
            cnt+=len(stack)
        else:
            cnt+=1
        

print(cnt)


#( ) ( ( ( ( ) ( ) ) ( ( ) ) ( ) ) ) ( ( ) )
#( ( ( ( ) ( ( ) ( ) ) ) ( ( ) ) ( ) ) ) ( ( ) ( ) )