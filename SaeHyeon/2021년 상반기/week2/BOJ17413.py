import sys
input=sys.stdin.readline

testcase=input().strip('\n')
li=''
num=0
result=''
for j in testcase:
    if j == "<":
        result += li
        li='<'
        num=1
    elif j==">":
        result += (li+'>')
        li=''
        num=0
    elif j==" ":
        result+=(li+' ')
        li=''        
    else:
        if num==1:
            li+=j
        else:
            li=j+li

#4번 입출력 결과/ 마지막 단어가 추가가 안됐을때
if li:
    result += li
print(result)