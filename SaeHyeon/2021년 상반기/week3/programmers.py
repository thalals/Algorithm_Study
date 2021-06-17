def solution(new_id):
    answer = ''
    new_id = new_id.lower()

    for i in new_id:
        if i.isalnum() or i == '-' or i == '.' or i == '_':
            answer+=i
    #try:
        #while True:
            #cp=False
            #if answer[0] == '.':
                cp=True
                answer = answer[1:]
            if answer[-1] == '.':
                cp=True
                answer = answer[:-1]
            for i in range(1,len(answer) - 1):
                if answer[i] == '.' and answer[i + 1] == '.':
                    cp=True
                    answer = answer[:i] + answer[i + 1:]
                    break
            if cp==False:
                break
    except:
        pass
    
    if len(answer) == 0:
        answer = 'a'
    if len(answer) > 15:
        answer = answer[:15]
        if answer[-1] == '.':
            answer = answer[:-1]
    if len(answer) < 3:
        answer += answer[-1] * (3 - len(answer))


    return ''.join(answer)