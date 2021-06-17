const { count } = require('console');
const fs = require('fs');
const { format } = require('path');
const stdin = (process.platform === 'linux'
  ? fs.readFileSync('/dev/stdin').toString()
  : `10 5000
1
5
10
50
100
500
1000
5000
10000
50000
`
).split('\n');

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

let [n,k] = input().split(' ').map(Number);
let kind = n;
let won = k;
let kindOf = [];
let i=0;
let min=0;

while(n--)
{
    kindOf[i++] = parseInt(input());
}

for(i = kind-1; i >= 0; i--)
{
    if(kindOf[i] > won){
        continue;
    }else{
        min += Math.floor(won / kindOf[i]);
        won -= (Math.floor(won / kindOf[i]) * kindOf[i]);
    }
}

console.log(min);