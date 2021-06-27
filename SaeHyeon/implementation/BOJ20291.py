# def main():
#     n=int(input())
#     file=[]
#     name=[]
#     for i in range(0,n):
#         file.append(input().split('.'))
#         name.append(file[-1][1])

#     name=list(set(name))
#     name.sort()

#     for i in range(len(name)):
#         cnt=0
#         for j in range(len(file)):
#             if name[i] == file[j][1]:
#                 cnt+=1
#         print(name[i],end=' ')
#         print(cnt)
# if __name__ == '__main__':
#     main()

import sys
input=sys.stdin.readline

n=int(input())
file=dict()
for i in range(n):
    name=input().split('.')
    a=name[1]
    if not a in file:
        file[a] = 1
    else:
        file[a] += 1

sort_file=sorted(file.items())

for x,y in sort_file:
    print(x.rstrip(),y)
