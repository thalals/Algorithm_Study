import sys
input=sys.stdin.readline

#모음 하나를 포함하는지 확인하는 함수
def check_vowel(s):
    for i in s:
        if i in 'aeiou':
            return True
    return False

#모음이 3개 혹은 자음이 3개 연속으로 오는지 확인하는 함수

def check_3word(s):
    if len(s) < 3:
        return True
    elif len(s) == 3:
        result=''
        for i in range(3):
            if s[i] in 'aeiou':
                result+='v'
            else:
                result+='c'
        if result == 'vvv' or result == 'ccc':
            return False
        else:
            return True
    for i in range(len(s)-2):
        result=''
        for j in range(3):
            if s[i+j] in 'aeiou':
                result+='v'
            else:
                result+='c'
    if 'vvv' in result or 'ccc' in result:
        return False
    return True

#같은 글자가 연속적으로 두번 오면 안되나, e나 o는 허용하는 함수
def check_eo(s):
    for i in range(len(s)-1):
        if s[i] == s[i+1]:
            if s[i]=='e' or s[i]=='o':
                return True
            else:
                return False



while(True):
    s=input().rstrip()
    if s == 'end':
        break
    if check_vowel(s) and check_eo(s) and check_3word(s):
        print('<'+s+'> is acceptable')
    else:
        print('<'+s+'> is not acceptable')