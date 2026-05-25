#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int A, B;

int main()
{
    scanf("%d %d", &A, &B);
    if (A == 0) {
        printf("0\n");
        return 0;
    }
    if (A >= B) {
        printf("%d", (int) (A / B));
        A %= B;
        if (A != 0) printf(" ");
        else {
            printf("\n");
            return 0;
        }
    }
    for (int i = 2; i <= A; i ++) {
        if (A % i == 0 && B % i == 0) {
            A /= i;
            B /= i;
            i --;
        }
    }
    printf("%d/%d\n", A, B);
    return 0;
}