#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int A, B;
int C = 0;

int main()
{
    scanf("%d %d", &A, &B);
    int x = ceil(sqrt(A)), y = ceil(pow(A, 1.0/3));
    while (x * x <= B && y * y * y <= B) {
        if (x * x == y * y * y)  {
            C ++;
            x ++;
            y ++;
        }
        else if (x * x < y * y * y) x ++;
        else y ++;
    }
    printf("%d\n", C);
    return 0;
}