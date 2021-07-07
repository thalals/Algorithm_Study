N=int(input())
li=[]
for i in range(N):
    li.append(int(input()))
# sort 함수 
li.sort()

#sort 구현해보기
# for i in range(0,N):
#     for j in range(0,N):
#         if li[i] < li[j]:
#             li[i],li[j] = li[j],li[i]

for i in range(N):
    print(li[i])