#include <stdio.h>
#include <stdlib.h>

int N;
int A[101][101];
// int V[101];

int main() {

    while (1) {
        scanf("%d", &N);
        if (N == 0) break;

        for (int i = 1; i <= N; i ++) {
            for (int j = 1; j <= N; j ++) {
                scanf("%d", &A[i][j]);
            }
        }

        int AS = 1, ID = 0, IN = 1;
        for (int i = 1; i <= N; i ++) {
            int C = N;
            for (int j = 1; j <= N; j ++) {
                if (A[i][j] == j && A[j][i] == j) C --;
                // if (i == j && V[i] == 1) continue;
                // else if (i == j) V[i] = 1;
                for (int k = 1; k <= N; k ++) {
                    if (A[A[i][j]][k] != A[i][A[j][k]])
                        AS = 0;
                }
            }
            if (C == 0) ID = i;
        }
        for (int i = 1; i <= N; i ++) {
            int found = 0;
            for (int j = 1; j <= N; j ++) {
                if (A[i][j] == ID) {
                    found = 1;
                    break;
                }
            }
            if (!found) {
                IN = 0;
                break;
            }
        }
        if (AS == 1 && ID != 0 && IN == 1) printf("yes\n");
        else printf("no\n");
    }
    
    return 0;
}
