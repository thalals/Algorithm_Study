const { log } = require('console');
const fs = require('fs');
const { endianness } = require('os');
const { format } = require('path');
const { start } = require('repl');
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
let zero = 0;
let one = 0;

if(s[0] === '0')
{
  zero++;
}
else
{
  one++;
}

for(let i=1; i<s.length; i++)
{
  if(s[i]!=s[i-1])
  {
    if(s[i] === '0')
    {
      zero++;
    }
    else
    {
      one++;
    }
  }
}

log(zero < one ? zero : one);