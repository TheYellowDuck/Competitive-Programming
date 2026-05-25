#include <stdio.h>
#include <stdlib.h>

int N, M;
int B[1000][3];

inline int checkFit(int a, int b, int c) {
    int i = N - 1;
    for (; i >= 0; i --) {
        if (B[i][0] >= a && B[i][1] >= b && B[i][2] >= c) return i;
    }
    return -1;
}

int comparator(const void* p, const void* q)
{
   int l = *((int*) p);
   int r = *((int*) q);
   return (r - l);
}
int comparator2(const void* p, const void* q)
{
   int* l = ((int*) p);
   int* r = ((int*) q);
   return (r[0] * r[1] * r[2] - l[0] * l[1] * l[2]);
}

int main()
{
    scanf("%d", &N);
    for (int i = 0; i < N; i ++) {
        scanf("%d %d %d", &B[i][0], &B[i][1], &B[i][2]);
        qsort(B[i], 3, sizeof(int), comparator);
    }
    qsort(B, N, 3 * sizeof(int), comparator2);
    // for (int i = 0; i < N; i ++) {
    //     printf("%d %d %d\n", B[i][0], B[i][1], B[i][2]);
    // }
    scanf("%d", &M);
    for (int i = 0; i < M; i ++) {
        int t[3];
        scanf("%d %d %d", &t[0], &t[1], &t[2]);
        qsort(t, 3, sizeof(int), comparator);
        
        int v = checkFit(t[0], t[1], t[2]);
        if (v == -1) printf("Item does not fit.\n");
        else printf("%d\n", B[v][0] * B[v][1] * B[v][2]);
    }
    return 0;
}