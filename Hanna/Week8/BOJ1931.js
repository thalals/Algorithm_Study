const { log } = require('console');
const fs = require('fs');
const { format } = require('path');
const stdin = (process.platform === 'linux'
  ? fs.readFileSync('/dev/stdin').toString()
  : `11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
`
).split('\n');

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

let conf = input()*1;
let confTime = [];
let i = 0;
let max_conf = 1;  //최대 가능한 회의 수
let n = 0;

while(i < conf)
{
        confTime[i++] = input().split(' ').map(Number);
}

while(n < conf)
{
    let cnt = 1;
    let j = 1;
    let k = 1;
    let l = 0;
    i=0;

      //그 다음 회의 가능
      while(k < conf)
      {
       if(confTime[i][j] <= confTime[k][l])
        {
         cnt++;
         i = k;
         k++;
        }
      //그 다음 회의 불가능
        else{
          k++;
        }

        if(cnt > max_conf)
       {
         max_conf = cnt;
       }
    }

    n++;
}

console.log(max_conf);