#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int N;
char C[20];
char K[20][21];
char S[251];

inline int checkEqual(char* A, char* B) {
    int i = 0;
    while (1) {
        if (B[i] == '\0') break;
        if (A[i] == '\0') return 0;
        if (A[i] != B[i]) return 0;
        i ++;
    }
    return i + 1;
}

int main()
{
    scanf("%d\n", &N);
    for (int i = 0; i < N; i ++) {
        char c[2];
        scanf("%s %s", c, K[i]);
        C[i] = c[0];
    }
    scanf("%s", S);
    int L = strlen(S);
    int s = 0;
    int in = 0;
    while (s < L) {
        for (int i = 0; i < N; i ++) {
            int r = checkEqual(&S[s], K[i]);
            if (r) {
                S[in ++] = C[i];
                s += r - 1; 
                break;
            }
        }
    }
    S[in] = '\0';
    printf("%s\n", S);
    return 0;
}