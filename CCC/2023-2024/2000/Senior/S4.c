#include <stdio.h>
#include <stdlib.h>

int N, M;
int C[32];
int D[5381];

int main()
{
    scanf("%d\n%d", &N, &M);
    for (int i = 0; i < M; i++)
        scanf("%d", &C[i]);

    D[0] = 1;
    for (int i = 0; i < N; i++)
    {
        if (D[i] == 0)
            continue;
        for (int j = 0; j < M; j++)
        {
            int c = C[j];
            if (D[i + c] == 0)
                D[i + c] = D[i] + 1;
            else if (D[i] + 1 < D[i + c])
                D[i + c] = D[i] + 1;
        }
    }
    if (D[N] == 0)
        printf("Roberta acknowledges defeat.");
    else
        printf("Roberta wins in %d strokes.", D[N] - 1);

    return 0;
}