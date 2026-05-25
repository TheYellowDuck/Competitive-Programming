#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char N[257];
char n[257];
int m = 2e9;

int main()
{
    while (1) {
        int t;
        scanf("%s %d", n, &t);
        if (t < m) {
            memcpy(N, n, sizeof(n));
            m = t;
        }
        if (strcmp(n, "Waterloo") == 0) break;
    }
    printf("%s\n", N);
    return 0;
}