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

//poketmon Array -> Object 변환
let mapPoketmon = Object.entries(Object.assign({}, poketmon));

log(mapPoketmon);

for(let j=0; j<M; j++)
{
    let question = input();

    //문자일 경우
    if(isNaN(question) === true)
    {
        log(mapPoketmon.get(question));
    }

    //숫자일 경우
    if(isNaN(question) === false)
    {
        log(poketmon[(question*1)-1]);
    }
    
}