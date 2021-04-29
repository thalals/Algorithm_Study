# disjoint-set
# 서로 중복되지 않는 부분 집합들로 나눠진 원소들에 대한 정보를 조작하는 자료구조

class DisjointSet:
    def __init__(self, n):
        # n : Number of elements
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
