#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int N;
int S;

int main()
{
    while (1) {
        scanf("%d", &N);
        if (N == 0) break;
        S = N * N;
        int c = 0;
        for (int i = 0; i < N; i ++) {
            c += sqrt(S - i * i);
        }
        c *= 4;
        c ++;
        printf("%d\n", c);
    }
    return 0;
}