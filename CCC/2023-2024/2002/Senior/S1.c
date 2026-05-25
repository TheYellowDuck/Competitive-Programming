#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int P, R, G, O;
int C;

int main()
{
    scanf("%d %d %d %d %d", &P, &R, &G, &O, &C);
    int count = 0, min = 2e9;
    for (int i = 0; i * P <= C; i ++) {
        for (int j = 0; i * P + j * R <= C; j ++) {
            for (int k = 0; i * P + j * R + k * G <= C; k ++) {
                for (int l = 0; i * P + j * R + k * G + l * O <= C; l ++) {
                    if (i * P + j * R + k * G + l * O == C) {
                        printf("# of PINK is %d # of GREEN is %d # of RED is %d # of ORANGE is %d\n", i, j, k, l);
                        if (i + j + k + l < min) min = i + j + k + l;
                        count ++;
                    }
                }
            }
        }
    }
    printf("Total combinations is %d.\nMinimum number of tickets to print is %d.", count, min);
    return 0;
}