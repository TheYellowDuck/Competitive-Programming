#include <stdio.h>
#include <stdlib.h>

int A[12][12];
int X = 5, Y = 5;
int D = 2;

int main()
{
    for (int i = 0; i <= 99; i ++)
    {
        A[Y][X] = i;
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
    int T;
    scanf("%d", &T);
    for (int i = 0; i < T; i ++) {
        int a, b;
        scanf("%d %d", &a, &b);
        int c = b - a;
        int L = 5, R = 5, U = 5, B = 5;
        for (int j = 1; j < 12; j ++) {
            for (int k = 1; k < 12; k ++) {
                
            }
        }
    }
    return 0;
}