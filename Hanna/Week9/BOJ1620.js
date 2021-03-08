//나는야 포켓몬 마스터 이다솜

const { log } = require('console');
const fs = require('fs');
const { endianness } = require('os');
const { format } = require('path');
const { start } = require('repl');
const stdin = (process.platform === 'linux'
  ? fs.readFileSync('/dev/stdin').toString()
  : `26 5
  Bulbasaur
  Ivysaur
  Venusaur
  Charmander
  Charmeleon
  Charizard
  Squirtle
  Wartortle
  Blastoise
  Caterpie
  Metapod
  Butterfree
  Weedle
  Kakuna
  Beedrill
  Pidgey
  Pidgeotto
  Pidgeot
  Rattata
  Raticate
  Spearow
  Fearow
  Ekans
  Arbok
  Pikachu
  Raichu
  25
  Raichu
  3
  Pidgey
  Kakuna
`
).split('\n');

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

let [N,M] = input().split(' ').map(Number);
let i = 0;
let poketmon = [];

while(i < N)
{
    poketmon[i] = input();
    i++;
}

// 25
// Raichu
// 3
// Pidgey
// Kakuna

for(let j=0; j<M; j++)
{
    let question = input();

    //log(typeof(question));

    if(isNaN(question) === true)
    {
        log(poketmon.indexOf(question,0)+1);
    }

    if(isNaN(question) === false)
    {
        log(poketmon[(question*1)-1]);
    }
    
}
