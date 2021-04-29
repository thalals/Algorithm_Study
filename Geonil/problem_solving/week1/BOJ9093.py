import sys
In = sys.stdin.readline


def main():
    num = int(In())
    sentences = []

    for _ in range(num):
        sentence = In().rstrip().split()
        sentences.append(sentence)

    for sentence in sentences:
        print_sentence = ''
        for word in sentence:
            for i in range(len(word)-1, -1, -1):
                print_sentence += word[i]
            print_sentence += ' '
        print(print_sentence)


main()
