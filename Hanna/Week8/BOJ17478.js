const { log } = require('console');
const fs = require('fs');
const { format } = require('path');
const stdin = (process.platform === 'linux'
  ? fs.readFileSync('/dev/stdin').toString()
  : `2`).split('\n');

  const input = (() => {
    let line = 0;
    return () => stdin[line++];
  })();

  let rec_cnt = input()*1;
  let question = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
  let whatRec = "\"재귀함수가 뭔가요?\"";
  let listen1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
  let listen2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
  let listen3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
  let rec_mean = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
  let ask = "라고 답변하였지.";
  let underbar = "____";
  let i = 0;

  console.log(question);

  function recursion (rec_cnt, i){
    let ub = underbar.repeat(i);
    console.log(ub+whatRec);

    if(rec_cnt != 0)
    {
        console.log(ub+listen1);
        console.log(ub+listen2);
        console.log(ub+listen3);
    }
    else{
        console.log(ub+rec_mean);
    }

    if(0 < rec_cnt)
    {
        recursion(rec_cnt-1, i+1);
    }
    console.log(ub+ask);
  }

  recursion(rec_cnt, i);

