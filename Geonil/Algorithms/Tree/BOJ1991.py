# 트리 순회 (BOJ 1991)
import sys
In = sys.stdin.readline


class Node:
    def __init__(self, data):
        self.data = data
        self.left, self.right = None, None


class Tree:
    def __init__(self, root):
        self.root = root
        self.s = None
        self.traversal = ''

    def search(self, node, value):
        if node == None:
            return
        if node.data == value:
            self.s = node

        self.search(node.left, value)
        self.search(node.right, value)

    def insert(self, parent, left, right):
        self.search(self.root, parent)
        node = self.s
        if not left == '.':
            node.left = Node(left)
        if not right == '.':
            node.right = Node(right)

    def preorder(self, node):
        if node == None:
            return
        self.traversal += node.data
        self.preorder(node.left)
        self.preorder(node.right)

    def inorder(self, node):
        if node == None:
            return
        self.inorder(node.left)
        self.traversal += node.data
        self.inorder(node.right)

    def postorder(self, node):
        if node == None:
            return
        self.postorder(node.left)
        self.postorder(node.right)
        self.traversal += node.data

    def reset(self):
        self.traversal = ''


def main():
    n = int(In())
    root = Node('A')
    tree = Tree(root)

    for _ in range(n):
        p, l, r = map(str, In().rstrip().split())
        tree.insert(p, l, r)

    tree.preorder(tree.root)
    print(tree.traversal)
    tree.reset()
    tree.inorder(tree.root)
    print(tree.traversal)
    tree.reset()
    tree.postorder(tree.root)
    print(tree.traversal)


if __name__ == "__main__":
    main()
