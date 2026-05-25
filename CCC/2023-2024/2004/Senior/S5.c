#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int M, N;
char map[100][101];
int max[100][100];
int temp[100];

inline void find_max(int i, int j, int k, int v) {
    if (map[k][i] == '*') return;
    int p = 0;
    if (map[k][i] != '.') p = map[k][i] - '0';
    if (max[k][i] < v + p) max[k][i] = v + p;
    if (k <= j && k - 1 >= 0 && i != N - 1) find_max(i, j, k - 1, v + p);
    if (k >= j && k + 1 < M && i != 0) find_max(i, j, k + 1, v + p);
}

int main()
{
    while (1) {
        scanf("%d %d", &M, &N);
        if (M == 0) break;
        for (int i = 0; i < M; i ++) {
            scanf("%s", map[i]);
            memset(max[i], 0, N * sizeof(int));
        }
        if (map[M - 1][0] == '.') map[M - 1][0] = '1';
        else map[M - 1][0] ++;
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < M; j ++) {
                int p = 0;
                if (i > 0 && map[j][i - 1] != '*') p = max[j][i - 1];
                if (i == 0 || (map[j][i - 1] != '*' && max[j][i - 1] != 0)) find_max(i, j, j, p);
            }
        }
        // printf("\n");
        // for (int i = 0; i < M; i ++) {
        //     for (int j = 0; j < N; j ++) {
        //         if (map[i][j] != '*') printf("%3d ", max[i][j]);
        //         else printf("%3c ", '*');
        //     }
        //     printf("\n");
        // }
        printf("%d\n", max[M - 1][N - 1] - 1);
    }
    return 0;
}