//여행 가자

const { log } = require('console');
const fs = require('fs');
const { format } = require('path');
const stdin = (process.platform === 'linux'
  ? fs.readFileSync('/dev/stdin').toString()
  : `3
3
0 1 0
1 0 1
0 1 0
1 2 3
`
).split('\n');

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

let cityNum = input()*1;
let planNum = input()*1;
let connectInfo = [];
let i = 0;
let planCity = [];

console.log(cityNum);
console.log(planNum);

while(i<cityNum)
{
  connectInfo[i++] = input().split(' ').map(Number);
}

planCity[0] = input().split(' ').map(Number)-1;
console.log(connectInfo);
console.log(planCity);

function yesOrNo(){
  i = 0;


}
