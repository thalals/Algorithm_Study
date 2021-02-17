import sys
sys.setrecursionlimit(10**6)
In = sys.stdin.readline

n = int(In())
m = int(In())


class DisjointSet():
    def __init__(self, n):
        self.parent = {}
        self.rank = {}
        for i in range(n):
            self.parent[i] = i
            self.rank[i] = 0

    def find(self, v):
        if self.parent[v] != v:
            self.parent[v] = self.find(self.parent[v])

        return self.parent[v]

    def union(self, root1, root2):
        if self.rank[root1] > self.rank[root2]:
            self.parent[root2] = root1
        else:
            self.parent[root1] = root2

            if self.rank[root1] == self.rank[root2]:
                self.rank[root2] += 1


def kruskal(n, data):
    disjoint_set = DisjointSet(n)
    minium_weight = 0

    for d in sorted(data, key=lambda w: w[2]):
        v1, v2, weight = d

        v1_parent = disjoint_set.find(v1-1)
        v2_parent = disjoint_set.find(v2-1)

        if v1_parent != v2_parent:
            disjoint_set.union(v1_parent, v2_parent)
            minium_weight += weight

    return minium_weight


def main():
    data = []
    for _ in range(m):
        d = list(map(int, In().split()))
        data.append(d)
    mst_result = kruskal(n, data)
    print(mst_result)


if __name__ == "__main__":
    main()
