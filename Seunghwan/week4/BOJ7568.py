# 입력
#   첫 줄에는 전체 사람의 수 N이 주어진다. 
#   그리고 이어지는 N개의 줄에는 각 사람의 몸무게와 키를 나타내는 양의 정수 x와 y가 하나의 공백을 두고 각각 나타난다.
# 출력
#   여러분은 입력에 나열된 사람의 덩치 등수를 구해서 그 순서대로 첫 줄에 출력해야 한다. 
#   단, 각 덩치 등수는 공백문자로 분리되어야 한다.



n = int(input()) # n 입력
data_list = [] # 키와 몸무게 

for i in range(n): # 입력한 n만큼 
    x,y = map(int, input().split()) # x,y 값을 각각 받는다
    data_list.append((x,y)) # 만들어놓은 리스트에 넣기

# print(data_list)

for i in data_list: 
    num = 1
    for j in data_list: #각각 키와 몸무게를 하나씩 비교해서 카운트해준다
        if i[0] < j[0] and i[1] < j[1]:
            num += 1
    print(num, end = " ") # 띄어쓰기