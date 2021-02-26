import sys
In = sys.stdin.readline
sys.setrecursionlimit(10**6)

n = int(In())

tab = '____'

start = '어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.'
question = '"재귀함수가 뭔가요?"'
story1 = '"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.'
story2 = '마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.'
story3 = '그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."'
answer = '"재귀함수는 자기 자신을 호출하는 함수라네"'
said = '라고 답변하였지.'


def recursion(n, k):
    print(tab*k+question)
    if n == 0:
        print(tab*k+answer)
        print(tab*k+said)
        return
    print(tab*k+story1)
    print(tab*k+story2)
    print(tab*k+story3)
    recursion(n-1, k+1)
    print(tab*k+said)


def main():
    print(start)
    recursion(n, 0)


if __name__ == "__main__":
    main()
