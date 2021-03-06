import sys

In = sys.stdin.readline

def reversing(s, flag):
    cnt = 0
    while True:
        start_idx = 0
        for c in s:
            if c != flag:
                break
            start_idx += 1
            
        if start_idx == len(s):
            break
        
        finish_idx = start_idx
        for idx in range(start_idx, len(s)):
            if s[idx] == flag:
                break
            finish_idx += 1
        duration = max(1, finish_idx - start_idx)
        s="".join((s[:start_idx],flag*duration,s[finish_idx:]))
        
        cnt += 1
        
    return cnt
    
        

def main():
    s = In().rstrip()
    print(min(reversing(s, '1'),reversing(s,'0')))
    
    
if __name__=="__main__":
    main()
