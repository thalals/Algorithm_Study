n = int(input())
a = list(map(int,input().split()))
m = int(input())
b = list(map(int,input().split()))

a.sort()

def Binary(arr, val, low, high):
    if low > high:
        return False
    
    mid = (low + high) // 2
    if arr[mid] > val:
        return Binary(arr, val, low, mid - 1)
    elif arr[mid] < val:
        return Binary(arr, val, mid + 1, high)
    else:
        return True


for m in b:
    if Binary(a, m, 0, n-1):
        print(1)
    else:
        print(0)


