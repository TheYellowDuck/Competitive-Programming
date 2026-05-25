#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int A[10][10];
int R[10][10][20];
int C[10][10];

void update(int i, int j) {
    for (int k = 1; k <= R[i][j][0]; k ++) {
        int x = R[i][j][k] / 10;
        int y = R[i][j][k] % 10;
        A[x][y] += A[i][j];
        C[x][y] ++;
        if (C[x][y] == 0) {
            C[x][y] = 1;
            update(x, y);
        }
    }
}

int main()
{
    for (int i = 0; i < 10; i ++) {
        for (int j = 1; j < 10; j ++) {
            char v[40];
            scanf("%s", v);
            if (v[0] <= '9') {
                sscanf(v, "%d", &A[i][j]);
                C[i][j] = 1;
                update(i, j);
            }
            else {
                for (int k = 0;; k += 3) {
                    int x = v[k] - 'A';
                    int y = v[k + 1] - '0';
                    if (C[x][y] == 1) A[i][j] += A[x][y];
                    else {
                        R[x][y][++ R[x][y][0]] = i * 10 + j;
                        C[i][j] --;
                    }
                    if (v[k + 2] != '+') break;
                }
                if (C[i][j] == 0) {
                    C[i][j] = 1;
                    update(i, j);
                }
            }
        }
    }

    for (int i = 0; i < 10; i ++) {
        for (int j = 1; j < 10; j ++) {
            if (C[i][j] == 1) printf ("%d ", A[i][j]);
            else printf("* ");
        }
        printf("\n");
    }
    
    return 0;
}