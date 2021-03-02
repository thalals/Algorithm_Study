const fs = require('fs');
const { format } = require('path');
const stdin = (process.platform === 'linux'
  ? fs.readFileSync('/dev/stdin').toString()
  : `3 4
3 7 5
`
).split('\n');

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

//케이스 입력 받기
let [n,k] = input().split(' ').map(Number);
let weight = 500;
let weightPlus = [];
weightPlus = input().split(' ').map(Number);
let cases;

//모든 경우의 수 계산하는 순열 함수 
function permute(permutation) { 
    var length = permutation.length,
        result = [permutation.slice()],
        c = new Array(length).fill(0),
        i = 1, k, p;
    while (i < length) {
      if (c[i] < i) {
        k = i % 2 && c[i];
        p = permutation[i];
        permutation[i] = permutation[k];
        permutation[k] = p;
        ++c[i];
        i = 1;
        result.push(permutation.slice());
      } else {
        c[i] = 0;
        ++i;
      }
    }
    return result;
  }

cases = permute(weightPlus);

//중량 계산 
function calWeight(weight, n, k, cases){
    let num = 0;
    //운동 키트 경우의 수만큼
    for(let i=0; i<cases.length; i++)
    {
        weight = 500;

        //n일간 운동키트 사용
        for(let j=0; j<n; j++)
        {
            weight = weight + cases[i][j] - k;

            if(weight < 500)
            {
                break;
            }
            else if(weight >= 500 && j === n-1)
            {
                num++;
            }
        }
    }
    return num;
}

console.log(calWeight(weight, n, k, cases));