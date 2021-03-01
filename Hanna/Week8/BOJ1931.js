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

while(i < conf)
{
        confTime[i++] = input().split(' ').map(Number);
}

console.log(conf);
console.log(confTime);