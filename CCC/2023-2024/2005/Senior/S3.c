#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int N;
int M[1024][1024];
int T[1024][1024];
int W, H;

int main()
{
    scanf("%d", &N);
    scanf("%d %d", &H, &W);
    for (int i = 0; i < H; i ++) {
        for (int j = 0; j < W; j ++) {
            scanf("%d", &M[i][j]);
        }
    }
    for (int i = 1; i < N; i ++) {
        int r, c;
        scanf("%d %d", &r, &c);

        for (int j = 0; j < r; j ++) {
            for (int k = 0; k < c; k ++) {
                int v;
                scanf("%d", &v);
                for (int a = 0; a < H; a ++) {
                    for (int b = 0; b < W; b ++) {
                        T[j * H + a][k * W + b] = M[a][b] * v;
                    }
                }
                
            }
        }
        H *= r;
        W *= c;
        memcpy(M, T, sizeof(T));
    }

    // for (int i = 0; i < H; i ++) {
    //     for (int j = 0; j < W; j ++) {
    //         printf("%d ", M[i][j]);
    //     }
    //     printf("\n");
    // }

    int min = 2e9, max = -2e9;
    int minr = 2e9, maxr = -2e9;
    int minc = 2e9, maxc = -2e9;

    for (int i = 0; i < H; i ++) {
        int sum = 0;
        for (int j = 0; j < W; j ++) {
            sum += M[i][j];
            if (M[i][j] < min) min = M[i][j];
        }
        if (sum < minr) minr = sum;
        if (sum > maxr) maxr = sum;
    }
    for (int i = 0; i < W; i ++) {
        int sum = 0;
        for (int j = 0; j < H; j ++) {
            sum += M[j][i];
            if (M[j][i] > max) max = M[j][i];
        }
        if (sum < minc) minc = sum;
        if (sum > maxc) maxc = sum;
    }

    printf("%d\n%d\n%d\n%d\n%d\n%d\n", max, min, maxr, minr, maxc, minc);

    return 0;
}