import sys
input = sys.stdin.readline


def is_tree(pairs: list, c_num: int) -> str:
    if len(pairs) == 1:
        if pairs[0][0] == pairs[0][1]:
            return f"Case {c_num} is not a tree."
        return f"Case {c_num} is a tree."
    if len(pairs) == 0:
        return f"Case {c_num} is a tree."
    childs = dict()
    nodes = set()
    for pair in pairs:
        u, v = pair[0], pair[1]
        if pair[1] in childs:
            return f"Case {c_num} is not a tree."
        childs[v] = u
        nodes.add(u)
        nodes.add(v)
    if len(nodes) == len(pairs) + 1:
        return f"Case {c_num} is a tree."
    else:
        return f"Case {c_num} is not a tree."


k = 0
while True:
    case = []
    flag = 1
    k += 1
    while flag:
        for c in input().rstrip().split('  '):
            if c == "":
                continue
            c = tuple(map(int, c.split()))
            if c[0] == -1 and c[1] == -1:
                sys.exit()
            if c[0] == 0 and c[1] == 0:
                print(is_tree(case, k))
                flag = 0
                break
            case.append(c)
