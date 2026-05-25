#include <stdio.h>
#include <stdlib.h>

int D[5];
int R[5];
int X;

int main()
{
    for (int i = 0; i < 5; i ++) {
        char c1, c2;
        scanf("%c%c", &c1, &c2);
        // printf("%c%c\n", c1, c2);
        if ('A' <= c1 && c1 <= 'E') D[i] = 1;
        else R[i] = 1;
        if ('A' <= c2 && c2 <= 'E') D[i] = 1;
        else R[i] = 1;
    }
    scanf("\n");
    for (int i = 0; i < 5; i ++) {
        char c1, c2;
        scanf("%c%c", &c1, &c2);
        // printf("%c%c\n", c1, c2);
        int v = 0;
        if ('A' <= c1 && c1 <= 'E') D[i] = 1;
        else v = 1;
        if ('A' <= c2 && c2 <= 'E') D[i] = 1;
        else v = 1;
        R[i] &= v;
    }
    scanf("%d\n", &X);
    for (int i = 0; i < X; i ++) {
        int p = 1;
        for (int j = 0; j < 5; j ++) {
            char c;
            scanf("%c", &c);
            // printf("%d %d %c\n", i, j, c);
            if ('A' <= c && c <= 'E' && D[j] == 0) {
                p = 0;
            }
            else if ('a' <= c && c <= 'e' && R[j] == 0) {
                p = 0;
            }
        }
        if (p)
            printf("Possible baby.\n");
        else
            printf("Not their baby!\n");
        scanf("\n");
    }
    return 0;
}