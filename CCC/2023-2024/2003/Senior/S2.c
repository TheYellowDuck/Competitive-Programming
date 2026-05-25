#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int N;
char P[5][4][81];

int main()
{
    scanf("%d\n", &N);
    for (int i = 0; i < N; i ++) {
        for (int j = 0; j < 4; j ++) {
            char c = '0';
            int index = 0;
            while (c != '\n') {
                scanf("%c", &c);
                if (c == ' ') {
                    index = 0;
                    continue;
                }
                if ('A' <= c && c <= 'Z') 
                    c += ('a' - 'A');
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                    index = 0;
                P[i][j][index ++] = c;
            }
            P[i][j][-- index] = '\0'; 
            // printf("%s\n", P[i][j]);
        }
        int perfect = 1;
        for (int j = 1; j < 4; j ++) {
            if (strcmp(P[i][0], P[i][j]) != 0) {
                perfect = 0;
                break;
            }
        }
        if (perfect == 1) {
            printf("perfect\n");
            continue;
        }
        if (strcmp(P[i][0], P[i][1]) == 0 && strcmp(P[i][2], P[i][3]) == 0) {
            printf("even\n");
            continue;
        }
        if (strcmp(P[i][0], P[i][2]) == 0 && strcmp(P[i][1], P[i][3]) == 0) {
            printf("cross\n");
            continue;
        }
        if (strcmp(P[i][0], P[i][3]) == 0 && strcmp(P[i][1], P[i][2]) == 0) {
            printf("shell\n");
            continue;
        }
        printf("free\n");
    }

    return 0;
}