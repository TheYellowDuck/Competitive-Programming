#include <stdio.h>
#include <stdlib.h>

int N;
int F[10000];

int main()
{
    scanf("%d", &N);
    for (int i = 0; i < N; i ++) {
        int a, b;
        scanf("%d %d", &a, &b);
        F[a] = b;
    }
    while (1) {
        int a, b;
        scanf("%d %d", &a, &b);
        if (a == 0) break;
        int S = -1, C = 0;
        int x = F[a];
        for (int i = 0; i < N; i ++) {
            if (x == b) S = i;
            if (x == a && S != -1) {
                C = 1;
                break;
            }
            x = F[x];
        }
        if (C == 0) printf("No\n");
        else printf("Yes %d\n", S);
    }
    return 0;
}