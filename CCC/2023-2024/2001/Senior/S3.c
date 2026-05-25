#include <stdio.h>
#include <stdlib.h>

int connections[26][26];
int connected = 0;

int main()
{
    char P1 = '.', P2 = '.';
    while (P1 != '*' && P2 != '*') {
        scanf("%c%c", &P1, &P2);
        connections[P1 - 'A'][P2 - 'A'] = 1;
        connections[P2 - 'A'][P1 - 'A'] = 1;
    }
    
    for (int i = 0; i < 26; i ++) {
        for (int j = i + 1; j < 26; j ++) {
            if (connections[i][j] == 0) continue;

        }
    }
    return 0;
}