#include <stdio.h>
#include <stdlib.h>

int A, B, C;
int X1, Y1, X2, Y2;
int A2, B2, C2;

int intersect (int x, int y, int a, int b) {
    A2 = y - b;
    B2 = a - x;
    C2 = x * b - a * y;
    double xint = (double) (B * C2 - B2 * C) / (A * B2 - A2 * B);
    double yint = (double) (C * A2 - C2 * A) / (A * B2 - A2 * B);

    if ( !( ( ( (X1 <= xint && xint <= X2) || (X2 <= xint && xint <= X1) ) && 
        ( (x <= xint && xint <= a) || (a <= xint && xint <= x) ) ) && 
        ( ( (Y1 <= yint && yint <= Y2) || (Y2 <= yint && yint <= Y1) ) && 
        ( (y <= yint && yint <= b) || (b <= yint && yint <= y) ) ) ) ) {
            return 0;
        }
    return 1;
}

int main() {
    scanf("%d %d %d %d", &X1, &Y1, &X2, &Y2);
    A = Y1 - Y2;
    B = X2 - X1;
    C = X1 * Y2 - X2 * Y1;
    int N;
    scanf("%d", &N);
    int count = 0;
    for (int i = 0; i < N; i ++) {
        int P;
        scanf("%d", &P);
        int inter = 0;
        int x, y, a, b;
        for (int j = 0; j < P; j ++) {
            scanf ("%d %d", &x, &y);
            if (j != 0)
                inter = (inter || intersect(x, y, a, b));
            a = x;
            b = y;
        }
        count += inter;
    }
    printf("%d\n", count);
    return 0;
}
