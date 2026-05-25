#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int N;
int Y = 2007, M = 2, D = 27;
int y, m, d;

int main()
{
    scanf("%d", &N);
    for (int i = 0; i < N; i ++) {
        scanf("%d %d %d", &y, &m, &d);
        if (Y - y > 18) printf("Yes\n");
        else if (Y - y == 18) {
            if (m < M) printf("Yes\n");
            else if (m == M) {
                if (d <= D) printf("Yes\n");
                else printf("No\n");
            }
            else printf("No\n");
        }
        else printf("No\n");
    }
    return 0;
}