// 거스름돈

const { log } = require('console');
const fs = require('fs');
const { format } = require('path');
const stdin = (process.platform === 'linux'
  ? fs.readFileSync('/dev/stdin').toString()
  : `380
`
).split('\n');

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

let price = input().split(' ').map(Number);
const changes = [500, 100, 50, 10, 5, 1];
let change = 1000-price;
let count = 0;
let n;
for(i=0;i<6;i++)
{
  n = Math.floor(change/changes[i]);
  count+=n;
  change -= n*changes[i];
}

console.log(count);