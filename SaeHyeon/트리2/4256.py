# 이진 트리 순회
# 전위 순회와 중위 순회를 통해서 후위 순회를 구하는 문제
import sys
input=sys.stdin.readline


def Postorder(preorder,inorder):
    if len(preorder) == 0:
        return
    elif len(preorder) == 1:
        print(preorder[0],end=' ')
        return
    elif len(preorder) == 2:
        print(preorder[1],preorder[0], end= ' ')
        return

    #전위순회에서 이진트리의 루트노드는 맨 첫번쨰
    pre_root=preorder[0]
    # 중위순회에서 루트의 위치를 찾는다
    root_index=inorder.index(pre_root)
    in_left=inorder[0:root_index]
    pre_left=preorder[1:1+len(in_left)]
    
    Postorder(pre_left,in_left)

    in_right=inorder[root_index+1:]
    pre_right=preorder[len(pre_left)+1:]
    
    Postorder(pre_right,in_right)

    print(preorder[0], end= ' ')

T=int(input())

for i in range(T):
    n=int(input())
    preorder=list(map(int,input().split()))
    inorder=list(map(int,input().split()))

    Postorder(preorder,inorder)
    print()
