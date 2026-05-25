#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int S[1001][30001];
int M, N, K;
int m = 0, count = 0;

inline void checkMax(int rate) {
    // printf("check: %d %d %d\n", m, count, rate);
    if (rate > m) {
        m = rate;
        count = 1;
    }
    else if (rate == m) count ++;
}

int main()
{
    scanf("%d %d %d", &M, &N, &K);
    for (int i = 0; i < K; i ++) {
        int a, b, c, d;
        scanf("%d %d %d %d", &a, &b, &c, &d);
        if (b - c >= 1) 
            S[a][b - c] += d;
        else
            S[a][1] += d;
        if (b + c + 1 <= M)
            S[a][b + c + 1] -= d;
        // S[a][b] += d;
        // checkMax(S[a][b]);
        // for (int j = 1; j <= c; j ++) {
        //     if (a + j <= N) {
        //         S[a + j][b] += d;
        //         checkMax(S[a + j][b]);
        //     }
        //     if (a - j >= 1) {
        //         S[a - j][b] += d;
        //         checkMax(S[a - j][b]);
        //     }
        //     if (b + j <= M) {
        //         S[a][b + j] += d;
        //         checkMax(S[a][b + j]);
        //     }
        //     if (b - j >= 1) {
        //         S[a][b - j] += d;
        //         checkMax(S[a][b - j]);
        //     }
        // }
        for (int j = 1; j <= c; j ++) {
            int r = sqrt(c * c - j * j);
            if (b - r >= 1) {
                if (a - j >= 1)
                    S[a - j][b - r] += d;
                if (a + j <= N)
                    S[a + j][b - r] += d;
            }
            else {
                if (a - j >= 1)
                    S[a - j][1] += d;
                if (a + j <= N)
                    S[a + j][1] += d;
            }
            if (b + r + 1 <= M) {
                if (a - j >= 1)
                    S[a - j][b + r + 1] -= d;
                if (a + j <= N)
                    S[a + j][b + r + 1] -= d;
            }
            // for (int k = 1; k <= r; k ++) {
            //     if (a + j <= N) {
            //         if (b + k <= M) {
            //             S[a + j][b + k] += d;
            //             checkMax(S[a + j][b + k]);
            //         }
            //         if (b - k >= 1) {
            //             S[a + j][b - k] += d;
            //             checkMax(S[a + j][b - k]);
            //         }
            //     }
            //     if (a - j >= 1) {
            //         if (b + k <= M) {
            //             S[a - j][b + k] += d;
            //             checkMax(S[a - j][b + k]);
            //         }
            //         if (b - k >= 1) {
            //             S[a - j][b - k] += d;
            //             checkMax(S[a - j][b - k]);
            //         }
            //     }
            // }
        }
        
    }
    // for (int i = 1; i <= N; i ++) {
    //     printf("%d\t", S[i][1]);
    //         checkMax(S[i][j]);
    //     for (int j = 2; j <= M; j ++) {
    //         // S[i][j] += S[i][j - 1];
    //         checkMax(S[i][j]);
    //         printf("%d\t", S[i][j]);
    //     }
    //     printf("\n");
    // }
    // printf("\n");
    for (int i = 1; i <= N; i ++) {
        // printf("%d\t", S[i][1]);
        checkMax(S[i][1]);
        for (int j = 2; j <= M; j ++) {
            S[i][j] += S[i][j - 1];
            checkMax(S[i][j]);
            // printf("%d\t", S[i][j]);
        }
        // printf("\n");
    }
    printf("%d\n%d\n", m, count);
    return 0;
}