#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int F[50][50];
int V[50], f[50], nf[50];

int main()
{
    F[1][6] = 1;F[2][6] = 1;F[3][4] = 1;F[4][3] = 1;F[5][3] = 1;F[6][1] = 1;F[7][6] = 1;F[8][7] = 1;F[9][8] = 1; F[10][9] = 1; F[11][10] = 1;F[12][9] = 1; F[13][12] = 1;F[14][13] = 1;F[15][3] = 1; F[16][17] = 1;F[17][16] = 1;F[18][16] = 1;
                            F[3][5] = 1;F[4][5] = 1;F[5][4] = 1;F[6][2] = 1;F[7][8] = 1;F[8][9] = 1;F[9][10] = 1;F[10][11] = 1;F[11][12] = 1;F[12][11] = 1;F[13][14] = 1;              F[15][13] = 1;F[16][18] = 1;F[17][18] = 1;F[18][17] = 1;
                            F[3][6] = 1;F[4][6] = 1;F[5][6] = 1;F[6][3] = 1;                        F[9][12] = 1;                            F[12][13] = 1;F[13][15] = 1;
                            F[3][15] = 1;                       F[6][4] = 1;
                                                                F[6][5] = 1;
                                                                F[6][7] = 1;
    
    while (1) {
        char c;
        char in[2];
        scanf("%s", &in);
        c = in[0];
        // printf("---: %c\n", c);
        if (c == 'q') break;
        int x, y;
        if (c == 'i') {
            scanf("%d %d", &x, &y);
            F[x][y] = 1;
            F[y][x] = 1;
        }
        else if (c == 'd') {
            scanf("%d %d\n", &x, &y);
            F[x][y] = 0;
            F[y][x] = 0;
        }
        else if (c == 'n') {
            scanf("%d\n", &x);
            int count = 0;
            for (int i : F[x]) {
                if (i) count ++;
            }
            printf("%d\n", count);
        }
        else if (c == 'f') {
            scanf("%d\n", &x);
            int count = 0;
            for (int i = 1; i < 50; i ++) {
                for (int j = 1; j < 50; j ++) {
                    if (F[x][j] && F[j][i] && !F[x][i] && x != i) {
                        count ++;
                        // printf ("%d\n", i);
                        break;
                    }
                }
            }
            printf("%d\n", count);
        }
        else {
            scanf("%d %d\n", &x, &y);
            memset(V, 0, sizeof(V));
            memset(f, 0, sizeof(f));
            int count = 0;
            int found = 0;
            f[0] = x;
            while (1) {
                memset(nf, 0, sizeof(nf));
                int idx = 0;
                for (int i = 0; i < 50; i ++) {
                    if (!f[i]) break;
                    for (int j = 0; j < 50; j ++) {
                        if (F[f[i]][j] && j == y) {
                            idx = 0;
                            found = 1;
                            goto endSearch;
                        }
                        if (F[f[i]][j] && !V[j]) {
                            nf[idx ++] = j;
                            V[j] = 1;
                        }
                    }
                }
                memcpy(f, nf, sizeof(f));
                endSearch:;
                count ++;
                if (idx == 0) break;
            }
            if (found)
                printf("%d\n", count);
            else
                printf("Not connected\n");
        }
        // printf("%d %d\n", x, y);
    }
    
    
    
    
    
    return 0;
}