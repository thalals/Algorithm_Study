import sys
from collections import deque
In = sys.stdin.readline


def main():
    string = In().rstrip()
    num = int(In())

    dq_l = deque(string)
    dq_r = deque()

    for _ in range(num):
        cmd = In().rstrip().split()
        if cmd[0] == 'L':
            if len(dq_l) == 0:
                continue
            dq_r.appendleft(dq_l.pop())
        elif cmd[0] == 'D':
            if len(dq_r) == 0:
                continue
            dq_l.append(dq_r.popleft())
        elif cmd[0] == 'B':
            if len(dq_l) == 0:
                continue
            dq_l.pop()
        elif cmd[0] == 'P':
            dq_l.append(cmd[1])

    result = ''.join(dq_l + dq_r)

    print(result)


main()
