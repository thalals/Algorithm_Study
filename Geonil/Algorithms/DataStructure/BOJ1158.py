'''
problem : 요세푸스 문제 (BOJ 1158)
comment : 
'''
import sys

In = sys.stdin.readline


class Node:
    def __init__(self, x):
        self.data = x
        self.next = None
        self.prev = None


class Circle:
    def __init__(self):
        self.root = Node(1)

    def insert(self, n):
        cur = self.root

        for i in range(1, n):
            cur.next = Node(i+1)
            cur.next.prev = cur
            cur = cur.next

        cur.next = self.root
        cur.next.prev = cur

    def delete(self, prev):
        cur_node = prev.next
        prev.next = cur_node.next
        cur_node.next.prev = prev

        return cur_node.data

    def josephus(self, k):
        cur = self.root.prev

        josephus_list = []
        while True:
            if cur == cur.next:
                break

            for i in range(k-1):
                cur = cur.next

            josephus_list.append(self.delete(cur))
        josephus_list.append(cur.data)

        return josephus_list


def main():
    circle = Circle()
    n, k = map(int, In().split())

    circle.insert(n)
    answer = circle.josephus(k)
    answer = map(str, answer)

    print('<', end='')
    print(', '.join(answer), end='>')


if __name__ == "__main__":
    main()
