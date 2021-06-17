#include <stdio.h>
#include <string.h>
#include <ctype.h>
#define SIZE 100000

// char arr[SIZE];
char arr[26][11] = { "Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard", "Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree", "Weedle",
               "Kakuna", "Beedrill", "Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate", "Spearow", "Fearow", "Ekans", "Arbok", "Pikachu", "Raichu" };

int main(void) {
    char s;
    // int N, M;
    // scanf("%d %d", &N, &M);

    // for(int i = 0; i < N; i++){
    //     scanf("%s", arr[i]);
    // }

    for (int i = 0; i < 5; i++) {
        scanf("%s", &s);
        if (isdigit(s)) printf("%s", arr[s][11]);
        else {
            for (int j = 0; j < 26; j++) {
                if (arr[j][11] == s) {
                    printf("%d", j);
                    break;
                }
            }
        }
    }
}