#include <stdio.h>
#include <stdlib.h>

int R, L;
int lights[30];
int change;
int V[256];
int C = 1;

int main()
{
    scanf("%d %d", &R, &L);
    for (int i = 0; i < R; i ++) {
        for (int j = 0; j < L; j ++) {
            int v;
            scanf("%d", &v);
            lights[i] = (lights[i] << 1) + v;
            // printf("%d %d\n", lights[i], v);
        }
        // printf("%d\n", lights[i]);
    }
    V[lights[R - 1]] = 1;
    for (int i = R - 1; i > 0; i --) {
        change = lights[i - 1];
        for (int j = i; j < R; j ++) {
            change ^= lights[j];
            // printf("%d\n", change);
        }
        if (V[change] == 0) {
            C ++;
            V[change] = 1;
        }
        // printf("\n");
    }
    printf("%d\n", C);
    return 0;
}