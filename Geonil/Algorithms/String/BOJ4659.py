# 비밀번호 발음하기 (BOJ 4659)
import sys
In = sys.stdin.readline

'''
1. 모음 하나 (a, e, i, o, u)
2. 모음 or 자음 연속 3개 x
3. e, o 제외 같은 글자 연속 2 x
'''

consonants: tuple = ('a', 'e', 'i', 'o', 'u')
exceptions: tuple = ('e', 'o')


def check_pw(password: str) -> bool:
    con_flag: bool = False    # consonants flag : at least 1 consonants
    con_cnt: int = 0         # continious consonants counts
    vow_cnt: int = 0         # continious vowels counts

    for idx in range(len(password)):
        if not idx == len(password)-1:
            if password[idx] not in exceptions and password[idx] == password[idx+1]:
                return False

        if password[idx] in consonants:
            con_flag = True
            con_cnt += 1
            vow_cnt = 0
        else:
            vow_cnt += 1
            con_cnt = 0

        if vow_cnt == 3 or con_cnt == 3:
            return False

    if con_flag:
        return True
    return False


def main():
    while True:
        password = In().rstrip()
        if password == 'end':
            break

        if check_pw(password):
            print(f'<{password}> is acceptable.')
        else:
            print(f'<{password}> is not acceptable.')


if __name__ == "__main__":
    main()
