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

console.log(s);

//모두 0으로 바꿀 경우

for(let i=s.indexOf(1,0);i<s.length;i++)
{
    
}



//모두 1로 바꿀 경우