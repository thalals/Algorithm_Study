from union_find import DisjointSet


def kruskal(n, data):
    '''
    n : number of vertices
    data : vertex1, vertex2, weight
    '''
    disjointset = DisjointSet(n)
    result = []
    minimum = 0

    for d in sorted(data, key=lambda w: w[2]):
        v1, v2, weight = d
        v1_parent = disjointset.find(v1)
        v2_parent = disjointset.find(v2)

        if v1_parent != v2_parent:
            disjointset.union(v1_parent, v2_parent)
            result.append(d)
            minimum += weight

    return result, minimum


def main():
    data = [[0, 5, 12],
            [0, 2, 28],
            [0, 1, 67],
            [0, 4, 17],
            [1, 3, 24],
            [1, 4, 62],
            [2, 4, 20],
            [2, 5, 37],
            [3, 6, 13],
            [4, 5, 45],
            [4, 6, 73]]
    rst, minimum = kruskal(7, data)
    print(rst)
    print(minimum)


if __name__ == "__main__":
    main()
