#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int B[101];
int P = 1;

int main()
{
    B[54] = 19;
    B[90] = 48;
    B[99] = 77;
    B[9] = 34;
    B[40] = 64;
    B[67] = 86;
    
    while (1) {
        int R;
        scanf("%d", &R);
        if (R == 0) {
            printf("You Quit!\n");
            break;
        }
        if (P + R <= 100) {
            P += R;
            if (B[P] != 0) P = B[P];
        }
        printf("You are now on square %d\n", P);
        if (P == 100) {
            printf("You Win!\n");
            break;
        }
    }

    return 0;
}