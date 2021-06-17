//랜선 자르기

const { log } = require('console');
const fs = require('fs');
const { format } = require('path');
const stdin = (process.platform === 'linux'
  ? fs.readFileSync('/dev/stdin').toString()
  : `4 11
802
743
457
539
`
).split('\n');

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

let lan = input().split(' ').map(Number);
let haveLan = lan[0];
let needLan = lan[1];
let i = 0;
let lanLangth = [];

while(i<haveLan)
{
  lanLangth[i++] = input().split('\n').map(Number);
}

let start = 1;
let end = Math.max.apply(null,lanLangth);


//이분탐색
while(start <= end) {
  let mid = Math.floor((start + end)/2);
  let makeLan = 0;

  for(i=0;i<haveLan;i++)
  {
    makeLan += Math.floor(lanLangth[i]/mid);
  }

  if(makeLan >= needLan)
  {
    start = mid + 1;
  }
  else
  {
    end = mid - 1;
  }
}

console.log(Math.floor(end));

