const { log } = require('console');
const fs = require('fs');
const { format } = require('path');
const stdin = (process.platform === 'linux'
  ? fs.readFileSync('/dev/stdin').toString()
  : `0001100
`
).split('\n');

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

let s = input();
let zeroToOne = 0;
let oneToZero = 0;
// log(s);

//모두 0으로 바꿀 경우

// log(s.indexOf(1,0));

//1을 0으로로 바꿀때
for(let i=0;i<s.length;i++)
{
  let lastOne;

    while(s[i] === '1')
    {
      i++;
      lastOne = i;
    }
    if(s[lastOne + 1] === '0')
    {
      oneToZero += 1;
    }
}

//0을 1로 바꿀때
// for(i=0;i<s.length;i++)
// {
//   let lastZero;

//     while(s[i] === '0')
//     {
//       i++;
//       lastZero = i;
//     }

//     if(s[lastZero + 1] === '1')
//     {
//       zeroToOne += 1;
//       log(zeroToOne);
//     }
// }

log(oneToZero);