import sys
In = sys.stdin.readline


class NewId:
    def __init__(self, new_id):
        self.new_id = new_id
        self.result = ''

    def step_1(self):
        self.result = self.new_id.lower()

    def step_2(self):
        tmp = ''
        for c in self.result:
            if c.isalpha() or c.isdigit() or isdot(c) or isunder(c) or isminus(c):
                tmp += c
        self.result = tmp

    def step_3(self):
        cnt = 0
        tmp = ''
        for c in self.result:
            if isdot(c):
                cnt += 1
                if cnt <= 1:
                    tmp += c
            else:
                cnt = 0
                tmp += c

        self.result = tmp

    def step_4(self):
        if len(self.result) > 1:
            if isdot(self.result[0]):
                self.result = self.result[1:]
            if isdot(self.result[len(self.result)-1]):
                self.result = self.result[:-1]
        elif len(self.result) == 1:
            if isdot(self.result[0]):
                self.result = ''

    def step_5(self):
        if self.result == '':
            self.result = 'a'

    def step_6(self):
        if len(self.result) >= 16:
            self.result = self.result[:15]
        self.step_4()

    def step_7(self):
        if len(self.result) <= 2:
            token = self.result[-1]
            while len(self.result) != 3:
                self.result += token

    def get_newid(self):
        self.step_1()
        self.step_2()
        self.step_3()
        self.step_4()
        self.step_5()
        self.step_6()
        self.step_7()
        return self.result


def isdot(c):
    if c == '.':
        return True
    return False


def isunder(c):
    if c == '_':
        return True
    return False


def isminus(c):
    if c == '-':
        return True
    return False


def main():
    new_id = In().rstrip()

    recommend = NewId(new_id)
    print(recommend.get_newid())


main()
