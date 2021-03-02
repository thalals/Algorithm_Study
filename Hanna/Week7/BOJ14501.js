const fs = require('fs');
const { format } = require('path');
const stdin = (process.platform === 'linux'
  ? fs.readFileSync('/dev/stdin').toString()
  : `7
3 10
5 20
1 10
1 20
2 15
4 40
2 200
`
).split('\n');

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

let n = input()*1;
console.log(n);
let t = [];
let p = [];
let i = 0;

while(n--)
{
    let[a,b] = input().split(' ').map(Number);
    t[i] = a;
    p[i] = b;
    i++;
}

function solution(n,t,p){
    let dp = [];
    for(let day = 1; day <= n+1; day++)
    {
        end = day + t[day];
        if(end > (n+1)){
            continue;
        }
        for(let j = end; j <= n+1; j++)
        {
            if(dp[j]<(dp[day]+p[day]))
            {
                dp[j] = (dp[day]+p[day]);
            }
            else{
                dp[j]=dp[j];
            }
        }
    }
    console.log(dp[n+1]);
}

solution(n,t,p);