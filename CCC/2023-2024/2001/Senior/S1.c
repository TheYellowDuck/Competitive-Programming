#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int CS[4][20];

int main()
{
    char C[18];
    int index = -1;
    scanf("%s", &C);
    int L = 41, T = 0;
    printf("Cards Dealt                        Points\n");
    for (int i = 0; i <= 17; i++)
    {
        if (C[i] == 'C' || C[i] == 'D' || C[i] == 'H' || C[i] == 'S' || i == 17)
        {
            if (index != -1)
            {
                if (CS[index][1] == 0)
                    CS[index][0] += 3;
                if (CS[index][1] == 1)
                    CS[index][0] += 2;
                if (CS[index][1] == 2)
                    CS[index][0] += 1;
            }
            index++;
            continue;
        }
        CS[index][CS[index][1]++ + 2] = C[i];
        if (C[i] - '0' <= 9 && C[i] - '0' >= 0)
            CS[index][0] += 0;
        else if (C[i] == 'T')
            CS[index][0] += 0;
        else if (C[i] == 'A')
            CS[index][0] += 4;
        else if (C[i] == 'K')
            CS[index][0] += 3;
        else if (C[i] == 'Q')
            CS[index][0] += 2;
        else if (C[i] == 'J')
            CS[index][0] += 1;
    }
    for (int i = 0; i < 4; i++)
    {
        int l = 0;
        if (i == 0)
        {
            printf("Clubs");
            l += 5;
        }
        if (i == 1)
        {
            printf("Diamonds");
            l += 8;
        }
        if (i == 2)
        {
            printf("Hearts");
            l += 6;
        }
        if (i == 3)
        {
            printf("Spades");
            l += 6;
        }
        for (int j = 0; j < CS[i][1]; j++)
        {
            printf(" %c", CS[i][j + 2]);
            l += 2;
        }
        if (CS[i][0] == 0)
            l += 1;
        else
            l += floor(log10(CS[i][0])) + 1;
        for (int j = 0; j < L - l; j++)
            printf(" ");
        printf("%d\n", CS[i][0]);
        T += CS[i][0];
    }
    int l = 6;
    if (T == 0)
        l += 1;
    else
        l += floor(log10(T)) + 1;
    for (int j = 0; j < L - l; j++)
        printf(" ");
    printf("Total %d\n", T);
    return 0;
}