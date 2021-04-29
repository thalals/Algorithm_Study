import time

# before
before = time.time()

for _ in range(1000):
    for j in range(1000):
        cnt = 0
after = time.time()

print('time : {}'.format(
    after-before
))
