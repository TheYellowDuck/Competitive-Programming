#include <stdio.h>
#include <stdlib.h>

int N;
char S[41];
int M[26];

int main()
{
    M['A' - 'A'] = 2;
    M['D' - 'A'] = 1;
    M['G' - 'A'] = 1;
    M['J' - 'A'] = 1;
    M['M' - 'A'] = 1;
    M['P' - 'A'] = 1;
    M['T' - 'A'] = 1;
    M['W' - 'A'] = 1;
    for (int i = 1; i < 26; i ++) {
        M[i] += M[i - 1]; 
    }
    scanf("%d", &N);
    for (int i = 0; i < N; i ++) {
        scanf("%s", S);
        int c = 0;
        for (int i = 0; i <= 40; i ++) {
            if (S[i] == '-') continue;
            c ++;
            if (S[i] <= '9') printf("%c", S[i]);
            else printf("%d", M[S[i] - 'A']);
            if (c == 3 || c == 6) printf("-");
            if (c == 10) break;
        }
        printf("\n");
    }

    return 0;
}