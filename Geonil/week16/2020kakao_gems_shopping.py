# 2020 카카오 공채 - 보석 쇼핑
# 효율성 낮음
import sys
In = sys.stdin.readline

gems = list(map(str, In().rstrip().split()))


def check_gems(gem_dict: dict) -> bool:
    for key in gem_dict:
        if gem_dict[key] == 0:
            return False
    return True


def main():
    gem = set(gems)
    gem_dict = dict()
    for jewelry in gem:
        gem_dict[jewelry] = 0

    length = len(gems)

    left = 0
    right = 0
    gem_dict[gems[left]] = 1
    min_section = None

    if len(gem) == 1:
        print("[1, 1]")
    else:
        while True:
            if right == length:
                break

            if check_gems(gem_dict):
                if min_section:
                    min_section = min(min_section, [left+1, right+1],
                                      key=lambda x: x[1]-x[0])
                else:
                    min_section = [left+1, right+1]

                gem_dict[gems[left]] -= 1
                left += 1
            else:
                right += 1

                if right == length:
                    break

                gem_dict[gems[right]] += 1

        print(min_section)


if __name__ == "__main__":
    main()
