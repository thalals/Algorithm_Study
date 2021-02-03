# 입력
#   첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
# 출력
#   첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.

n = int(input())


result = 0

# 아래식을 활용하면 for문의 범위를 효율적으로 만들 수 있다.(특이해서 긁어옴) 
# 어떤 자리든 한 자리는 최대 9의 수를 가지므로 자리값 * 9를 
# n에서 빼준 수부터 검사하면 됨
# range에 _min부터 시작
"""
_min = n - len(str(n)) * 9 
_min = 1 if _min < 1 else _min 
"""
for i in range(1, n+1): # 1부터 n까지

   data = list(map(int,str(i))) # 각 자리 수를 분해한다
   result = i + sum(data) # 분해합 구하기
   if result == n: # 분해합이 n과 같으면 
       print(i) # i 출력
       break # 종료

   if i == n: # 같을경우 0 출력
       print(0)
