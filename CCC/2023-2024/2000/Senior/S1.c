#include <stdio.h>
#include <stdlib.h>

int N;
int A = 35, B = 100, C = 10;
int P1 = 30, P2 = 60, P3 = 9;

int main() {

    int a, b, c;
    int count = 0;
    scanf("%d %d %d %d", &N, &a, &b, &c);

    while (N > 0) {

        if (count % 3 == 0) {
            a ++;
            if (a == A) {
                N += P1;
                a = 0;
            }
        }
        else if (count % 3 == 1) {
            b ++;
            if (b == B) {
                N += P2;
                b = 0;
            }
        }
        else {
            c ++;
            if (c == C) {
                N += P3;
                c = 0;
            }
        }

        N --;
        count ++;
    }

    printf("Martha plays %d times before going broke.\n", count);

    return 0;
}