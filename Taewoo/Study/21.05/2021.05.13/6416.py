import sys
input = sys.stdin.readline


def is_tree():
    is_root = False
    for i in range(1, len(tree)):
        if is_root and node_check[i] and len(tree[i]) == 0:
            return False
        if not is_root and node_check[i] and len(tree[i]) == 0:
            is_root = True
        if node_check[i] and len(tree[i]) > 1:
            return False

    if not is_root:
        return False

    return True


# main
k = 1
while True:
    nodes = []
    is_end = False

    while True:
        numbers = list(map(int, input().split()))
        if len(numbers) != 0 and numbers[-1] == 0 and numbers[-2] == 0:
            nodes.extend(numbers)
            break
        if len(numbers) != 0 and numbers[-1] == -1 and numbers[-2] == -1:
            sys.exit(0)
        if len(numbers) == 0:
            continue
        nodes.extend(numbers)

    tree = [[] for _ in range(max(nodes) + 1)]
    node_check = [False for _ in range(max(nodes) + 1)]
    for i in range(0, len(nodes) - 1, 2):
        tree[nodes[i + 1]].append(nodes[i])
        node_check[nodes[i]] = True
        node_check[nodes[i + 1]] = True

    if len(tree) == 1 or is_tree():
        print(f'Case {k} is a tree.')
    else:
        print(f'Case {k} is not a tree.')

    k += 1