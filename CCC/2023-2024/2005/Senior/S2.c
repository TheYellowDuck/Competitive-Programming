#include <stdio.h>
#include <stdlib.h>

int X = 0, Y = 0;
int C, R;

int main()
{
    scanf("%d %d", &C, &R);
    while (1) {
        int x, y;
        scanf("%d %d", &x, &y);
        if (x == 0 && y == 0) break;
        X += x;
        Y += y;
        if (X < 0) X = 0;
        if (Y < 0) Y = 0;
        if (X > C) X = C;
        if (Y > R) Y = R;
        printf("%d %d\n", X, Y);
    }
    return 0;
}