# 1158

n, k = map(int,input().split())
my_list = []
result = []
count = 0

for i in range(n):
    my_list.append(i+1)

while len(my_list) >0:
    count = (count + (k-1)) % len(my_list) # 넘어버린 K를 인원수로 나눈 나머지 값으로 바꿈
    pop_count = my_list.pop(count) # 삭제
    result.append(str(pop_count)) # str 주의



print("<%s>" %(", ".join(result)))
