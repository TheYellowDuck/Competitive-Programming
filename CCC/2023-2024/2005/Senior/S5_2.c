#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

int T;
int A[100000];
int temp[100000];
double sum = 0;

inline void merge(int l, int r, int m) {
    int i = l;
    int j = m + 1;
    int k = 0;
    while (i <= m && j <= r) {
        if (A[i] <= A[j]) {
            temp[k ++] = A[i ++];
        }
        else {
            temp[k ++] = A[j ++];
            sum += m + 1 - i;
        }
    }
    while (i <= m) {
        temp[k ++] = A[i ++];
    }
    while (j <= r) {
        temp[k ++] = A[j ++];
    }
    memcpy(&A[l], temp, (r - l + 1) * sizeof(int));
}

inline void mergeSort(int l, int r) {
    if (l < r) {
        int m = (l + r) / 2;
        mergeSort(l, m);
        mergeSort(m + 1, r);
        merge(l, r, m);
    }
}

int main()
{
    scanf("%d", &T);
    for (int i = 0; i < T; i ++) {
        scanf("%d", &A[i]);
    }
    sum += T;
    mergeSort(0, T - 1);
    // printf("%lf\n", sum);
    printf("%.2lf\n", rint(sum / T * 100) / 100);

    return 0;
}