#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char S[3][26];

int main()
{
    int N;
    scanf("%d", &N);

    for (int i = 0; i < N; i ++) {
        scanf("%s", &S[0]);
        scanf("%s", &S[1]);
        scanf("%s", &S[2]);
        int s1 = strlen(S[0]), s2 = strlen(S[1]), s3 = strlen(S[2]);

        if (s1 < s2 && (memcmp(S[0], S[1], s1) == 0 || memcmp(S[0], &S[1][s2 - s1], s1) == 0)) {
            printf("No\n");
            continue;
        }
        else if (memcmp(S[0], S[1], s2) == 0 || memcmp(&S[0][s1 - s2], S[1], s2) == 0) {
            printf("No\n");
            continue;
        }
        else if (s1 < s3 && (memcmp(S[0], S[2], s1) == 0 || memcmp(S[0], &S[2][s3 - s1], s1) == 0)) {
            printf("No\n");
            continue;
        }
        else if (memcmp(S[0], S[2], s3) == 0 || memcmp(&S[0][s1 - s3], S[2], s3) == 0) {
            printf("No\n");
            continue;
        }
        else if (s2 < s3 && (memcmp(S[1], S[2], s2) == 0 || memcmp(S[1], &S[2][s3 - s2], s2) == 0)) {
            printf("No\n");
            continue;
        }
        else if (memcmp(S[1], S[2], s3) == 0 || memcmp(&S[1][s2 - s3], S[2], s3) == 0) {
            printf("No\n");
            continue;
        }
        printf("Yes\n");
    }

    return 0;
}