#include <stdio.h>
#include <stdlib.h>

int A[50][50];
int X = 25, Y = 25;
int L = 25, U = 25, R = 25, B = 25;
int D = 2;

int main()
{
    int a, b;
    scanf("%d %d", &a, &b);
    for (int i = a; i <= b; i++)
    {
        A[Y][X] = i;
        if (X < L)
            L = X;
        if (Y < U)
            U = Y;
        if (X > R)
            R = X;
        if (Y > B)
            B = Y;
        if (D == 0) {
            Y --;
            if (A[Y][X - 1] == 0)
                D = (D + 3) % 4;
        }
        else if (D == 1) {
            X ++;
            if (A[Y - 1][X] == 0)
                D = (D + 3) % 4;
        }
        else if (D == 2) {
            Y ++;
            if (A[Y][X + 1] == 0)
                D = (D + 3) % 4;
        }
        else if (D == 3) {
            X --;
            if (A[Y + 1][X] == 0)
                D = (D + 3) % 4;
        }
    }
    for (int i = U ; i <= B; i ++) {
        for (int j = L; j <= R; j ++) {
            if (A[i][j] == 0) printf("   ");
            else printf("%2d ", A[i][j]);
        }
        printf("\n");
    }
    return 0;
}