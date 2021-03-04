import sys
In = sys.stdin.readline


def main():
    coins = [500, 100, 50, 10, 5, 1]
    pay = 1000
    price = int(In())

    cnt = 0
    change = pay - price

    for coin in coins:
        n = change // coin
        cnt += n
        change -= n*coin
        print(coin, n, change)

    print(cnt)


if __name__ == "__main__":
    main()
