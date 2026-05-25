#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int N;
int A, B, C, D;
int M[31][31][31][31][2];

int nukit(int a, int b, int c, int d, int p) {
    if (a < 0 || b < 0 || c < 0 || d < 0) return !p;
    if (M[a][b][c][d][p] != 0) return M[a][b][c][d][p] - 1;
    // printf("%d %d %d %d %d\n", a, b, c, d, p);
    int win = 0;
    if (p == 0) {
        win = 0;
        win |= nukit(a - 2, b - 1, c, d - 2, !p);
        win |= nukit(a - 1, b - 1, c - 1, d - 1, !p);
        win |= nukit(a, b, c - 2, d - 1, !p);
        win |= nukit(a, b - 3, c, d, !p);
        win |= nukit(a - 1, b, c, d - 1, !p);
    }
    else {
        win = 1;
        win &= nukit(a - 2, b - 1, c, d - 2, !p);
        win &= nukit(a - 1, b - 1, c - 1, d - 1, !p);
        win &= nukit(a, b, c - 2, d - 1, !p);
        win &= nukit(a, b - 3, c, d, !p);
        win &= nukit(a - 1, b, c, d - 1, !p);
    }
    M[a][b][c][d][p] = win + 1;
    return win;
}

int main()
{
    scanf("%d", &N);
    for (int i = 0; i < N; i ++) {
        scanf("%d %d %d %d", &A, &B, &C, &D);
        int winner = nukit(A, B, C, D, 0);
        if (winner) printf("Patrick\n");
        else printf("Roland\n");
    }
    return 0;
}