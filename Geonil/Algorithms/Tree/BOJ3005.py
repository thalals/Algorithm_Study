import sys

In = sys.stdin.readline


class Node:
    def __init__(self, key):
        self.key = key
        self.child = {}


class Trie:
    def __init__(self):
        self.root = Node(None)

    def insert(self, word):
        cur = self.root

        for c in word:
            if c not in cur.child:
                cur.child[c] = Node(c)
            cur = cur.child[c]
        cur.child['*'] = True

    def search_first(self):
        cur = self.root
        word = ''
        while True:
            if '*' in cur.child:
                break
            keys = list(cur.child.keys())
            keys.sort()
            word += keys[0]
            cur = cur.child[keys[0]]

        return word


def main():
    trie = Trie()
    r, c = map(int, In().split())

    # left to right
    l2r = []
    for i in range(r):
        l2r.append(In().rstrip())

    # top to bottom
    t2b = []
    for j in range(c):
        string = ''
        for i in range(r):
            c = l2r[i][j]
            string += c
        t2b.append(string)

    # concat puzzle
    puzzle = l2r + t2b

    for p in puzzle:
        words = list(p.split('#'))
        for w in words:
            if len(w) < 2:
                continue
            trie.insert(w)

    print(trie.search_first())


if __name__ == "__main__":
    main()
