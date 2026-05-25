#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int M, N;
char A[40][21];
char B[40][21];
int ans[41];

int findPattern(int m, int i, char s1[200], char s2[200]) {
    // printf("%s  %s\n", s1, s2);
    if (m != 1) {
        for (; i < 200; i ++) {
            if (s1[i] == '\0' && s2[i] == '\0') return m;
            if (s1[i] == '\0' || s2[i] == '\0') break;
            if (s1[i] != s2[i]) return 0;
        }
    }
    if (m == M) return 0;
    for (int j = 0; j < N; j ++) {
        char newS1[200];
        memcpy(newS1, s1, (strlen(s1) + 1) * sizeof(char));
        memcpy(&newS1[strlen(newS1)], A[j], (strlen(A[j]) + 1) * sizeof(char));
        char newS2[200];
        memcpy(newS2, s2, (strlen(s2) + 1) * sizeof(char));
        memcpy(&newS2[strlen(newS2)], B[j], (strlen(B[j]) + 1) * sizeof(char));
        int v = findPattern(m + 1, i, newS1, newS2);
        if (v != 0) {
            ans[m] = j + 1;
            return v;
        } 
    }
    return 0;
}

char a[200], b[200];
int main()
{
    scanf("%d %d", &M, &N);
    for (int i = 0; i < N; i ++) {
        scanf("%s", &A[i]);
    }
    for (int i = 0; i < N; i ++) {
        scanf("%s", &B[i]);
    }

    

    int v = findPattern(1, 0, a, b);
    if (v == 0) printf("No solution.\n");
    else {
        printf("%d\n", v - 1);
        for (int i = 1; i < v; i ++) {
            printf("%d\n", ans[i]);
        }
    }
    return 0;
}