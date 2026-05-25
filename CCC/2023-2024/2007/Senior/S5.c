#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int T;
int N, K, W;
int P[30001][2];
int C[30001];
int D[30001];

int compare(const void * a, const void * b) {
    return b[0] < a[0];
}

int main()
{
    scanf("%d", &T);
    for (int t = 0; t < T; t ++) {
        scanf("%d %d %d", &N, &K, &W);
        memset(P, 0, 2 * (N + 1) * sizeof(int));
        memset(C, 0, (N + 1) * sizeof(int));
        // memset(D, 0, (N + 1) * sizeof(int));
        // for (int i = 0; i <= N; i ++) 
        //     printf("%d ", P[i]);
        // printf("\n");
        // for (int i = 0; i <= N; i ++) 
        //     printf("%d ", C[i]);
        // printf("\n");
        // for (int i = 0; i <= N; i ++) 
        //     printf("%d ", D[i]);
        // printf("\n");
        for (int i = 0; i < N; i ++) {
            P[i][1] = i;
            int v;
            scanf("%d", &v);
            P[i + 1][0] -= v;
            if (i - W + 1>= 0) 
                P[i - W + 1][0] += v;
            else 
                P[0][0] += v;
            // for (int i = 0; i <= N; i ++) 
            //     printf("%d ", P[i]);
            // printf("\n");
        }
        // D[0] = P[0][0];
        for (int i = 1; i <= N; i ++) {
            P[i][0] += P[i - 1][0];
            // D[i] = P[i][0];
        }
        qsort()
        for (int i = 0; i <= N - W; i ++) 
            printf("\t%d ", P[i][0]);
        printf("\n");
        int max = 0;
        for (int i = 0; i <= N - W; i ++) {
            for (int j = i + W; j <= N - W; j ++) {
                if ((C[i] + 1 < K && P[j] + D[i] > D[j]) || (P[j] + D[i] == D[j] && C[i] + 1 < C[j])) {
                    D[j] = P[j] + D[i];
                    C[j] = C[i] + 1; 
                }
            }
            if (D[i] > max) max = D[i];
            for (int i = 0; i <= N - W; i ++) 
                printf("\t%d ", D[i]);
            printf("\n");
            for (int i = 0; i <= N - W; i ++) 
                printf("\t\t%d ", C[i]);
            printf("\n\n");
        }
        printf("%d\n", max);
    }
    return 0;
}