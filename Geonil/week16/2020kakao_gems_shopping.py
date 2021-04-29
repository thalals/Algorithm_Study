# 2020 카카오 공채 - 보석 쇼핑
# 효율성 낮음
import sys
In = sys.stdin.readline

gems = list(map(str, In().rstrip().split()))


def main():
    gem = set(gems)
    gem_dict = dict()   # dict for count each gem

    size = len(gem)     # number of gems
    length = len(gems)  # length of gems list

    left = 0
    right = 0
    gem_dict[gems[left]] = 1
    min_section = [0, 100000]   # max size of answer

    if size == 1:
        print("[1, 1]")
    else:
        while True:
            # if number of gem == size of gem
            if size == len(gem_dict):
                # check section length
                min_section = min(min_section, [left+1, right+1],
                                  key=lambda x: x[1]-x[0])

                gem_dict[gems[left]] -= 1

                if gem_dict[gems[left]] == 0:
                    del gem_dict[gems[left]]
                left += 1
            else:
                right += 1

                # if right pointer == length of gems list, break loop
                if right == length:
                    break
                # if right pointer's gem is not in gems_dict
                if gems[right] not in gem_dict:
                    gem_dict[gems[right]] = 1
                else:
                    gem_dict[gems[right]] += 1

        print(min_section)


if __name__ == "__main__":
    main()
