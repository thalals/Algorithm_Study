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

while(i<haveLan){
    lanLangth[i++] = input().split('\n').map(Number);
}

console.log(haveLan,needLan,lanLangth);

