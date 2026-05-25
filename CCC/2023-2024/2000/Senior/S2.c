#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

int N;
double S[101];


int main() {

    scanf("%d", &N);
    for (int i = 1; i <= N; i ++) 
        scanf("%lf", &S[i]);

    int Q = 0;
    while (Q != 77) {
        scanf("%d", &Q);
        if (Q == 99) {
            int s, p;
            scanf("%d %d", &s, &p);
            if (N - s != 0)
                memcpy(&S[s + 2], &S[s + 1], (N - s) * sizeof(double));
            S[s + 1] = S[s] * ((100 - p) / 100.0);
            S[s] -= S[s + 1];
            N ++;
        }
        if (Q == 88) {
            int s;
            scanf("%d", &s);
            S[s] += S[s + 1];
            if (N - s - 1 != 0)
                memcpy(&S[s + 1], &S[s + 2], (N - s - 1) * sizeof(double));
            N --;
        }
    }

    for (int i = 1; i <= N; i ++)
        printf("%d ", (int) round(S[i]));
    printf("\n");

    return 0;
}