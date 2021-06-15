// 좌표압축

const { log } = require('console');
const fs = require('fs');
const { format } = require('path');
const stdin = (process.platform === 'linux'
  ? fs.readFileSync('/dev/stdin').toString()
  : `6
1000 999 1000 999 1000 999
`
).split('\n');

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

let num = input()*1;
let i = 0;
let location = input().split(' ').map(Number);
let compre = [];
let cnt = 0;
let k = 0;

for(i=0; i<num; i++)
{
    cnt = 0;
    for(let j=0; j<num; j++)
    {
        if(location[i]>location[j])
        {
            cnt++;
        }
    }
    compre[k++] = cnt;
}

let constr = compre.join(' ');

log(constr);