import sys
In = sys.stdin.readline
sys.setrecursionlimit(10**6)

n, m = map(int, In().split())


class DisjoinsSet:
    def __init__(self, n):
        self.parent = {}
        self.rank = {}
        for i in range(n+1):
            self.parent[i] = i
            self.rank[i] = 0

    def find(self, v):
        if self.parent[v] != v:
            self.parent[v] = self.find(self.parent[v])

        return self.parent[v]

    def union(self, e1, e2):
        e1_parent = self.find(e1)
        e2_parent = self.find(e2)

        if e1_parent != e2_parent:
            self.parent[e1_parent] = e2_parent


def main():
    disjoinset = DisjoinsSet(n)
    for _ in range(m):
        cmd, a, b = map(int, In().split())
        if cmd == 0:
            disjoinset.union(a, b)
        else:
            if disjoinset.find(a) == disjoinset.find(b):
                print('YES')
            else:
                print('NO')


if __name__ == "__main__":
    main()
