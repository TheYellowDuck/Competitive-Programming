#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int M, Q;
char N[101][20];
int T[101];

int time[101];
int grp[101];

inline void print(int i) {
    if (i == 0) return;
    print(i - grp[i]);
    for (int j = i - grp[i] + 1; j <= i; j ++) {
        printf("%s ", N[j]);
    }
    printf("\n");
}

int main()
{
    scanf("%d %d", &M, &Q);
    for (int i = 1; i <= Q; i ++) {
        scanf("%s %d", N[i], &T[i]);
        time[i] = 2e9;
    }

    for (int i = 0; i <= Q; i ++) {
        int cur = 0;
        for (int j = 1; j <= M && i + j <= Q; j ++) {
            cur = cur > T[i + j] ? cur : T[i + j];
            // printf("%d %d %d\n", cur, time[i] + cur, time[i + j]);
            if (time[i] + cur < time[i + j]) {
                time[i + j] = time[i] + cur;
                grp[i + j] = j;
            }
        }
        // for (int j = 0; j <= Q; j ++) printf("%d ", time[j]);
        // printf("\n");
    }
    printf("Total Time: %d\n", time[Q]);
    print(Q);
    return 0;
}