/* 
[문제 - 수 찾기]
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때,
안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

[입력]
첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다.
다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
다음 줄에는 M개의 수들이 주어지는데, 
이 수들이 A안에 존재하는지 알아내면 된다.
모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

[출력]
M개의 줄에 답을 출력한다. 존재하면 1을,
존재하지 않으면 0을 출력한다.

5
4 1 5 2 3
5
1 3 7 9 5

1
1
0
0
1

*/

'use strict';

const fs = require('fs');
const stdin = (process.platform === 'linux'
  ? fs.readFileSync('/dev/stdin').toString()
  : `5
4 1 5 2 3
5
1 3 7 9 5
`
).split('\n');

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

let n = input()*1;
let data = input().split(' ').map(Number);
let m = input()*1;
let data2 = input().split(' ').map(Number);

for(let i=0;i<m;i++)
{
  const binarySearch = (data, data2[i]) => {
    let left=0;
    
  }
}

