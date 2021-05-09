# 단어 뒤집기 2 (BOJ 17413)
import sys
In = sys.stdin.readline


def main():
    string = In().rstrip()

    length: int = len(string)
    rev_string: str = ''
    idx: int = 0

    while True:
        if idx == length:
            break

        if string[idx] == '<':
            rev_string += string[idx]
            while True:
                idx += 1
                rev_string += string[idx]
                if string[idx] == '>':
                    idx += 1
                    break
            continue

        sub = ''
        while not string[idx] == ' ' and not string[idx] == '<':
            sub += string[idx]
            idx += 1
            if idx == length:
                break

        rev_string += ''.join(reversed(sub))

        if idx == length:
            break

        if string[idx] == ' ':
            rev_string += ' '
            idx += 1

    print(rev_string)


if __name__ == "__main__":
    main()
