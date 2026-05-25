#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int N, K;

struct Contestant {
    int id;
    int score;
    int rank;
    int worst;
};

int compareContestant (const void* p, const void* q) {
    struct Contestant* a = (struct Contestant*) p;
    struct Contestant* b = (struct Contestant*) q;
    // printf("%d %d, %d %d\n", a -> id, a -> score, b -> id, b -> score);
    // if ((a -> score == b -> score ? a -> id < b -> id : a -> score < b -> score) == 0) printf ("%d >= %d\n", a -> id, b -> id);
    // else printf ("%d >= %d\n", b -> id, a -> id);

    // printf("%d\n", (a -> score == b -> score ? a -> id < b -> id : a -> score < b -> score));
    return (a -> score == b -> score ? a -> id > b -> id : a -> score < b -> score);
}

struct Contestant* C[101];
struct Contestant R[100];

int main()
{
    scanf("%d %d", &N, &K);

    for (int i = 0; i < N; i ++) {
        R[i].id = i + 1;
        R[i].score = 0;
        R[i].rank = 1;
        R[i].worst = 1;
        C[i + 1] = &R[i];
    }
    
    for (int i = 0; i < K; i ++) {
        for (int j = 1; j <= N; j ++) {
            int s;
            scanf("%d", &s);
            C[j] -> score += s;
        }
        qsort(&R, N, sizeof(struct Contestant), compareContestant);
        R[0].rank = 1;
        C[R[0].id] = &R[0];
        for (int j = 1; j < N; j ++) {
            R[j].rank = j + 1;
            if (R[j].score == R[j - 1].score) R[j].rank = R[j - 1].rank;
            if (R[j].rank > R[j].worst) R[j].worst = R[j].rank;
            C[R[j].id] = &R[j];
        }
        // for (int j = 0; j < N; j ++) {
        //     printf("Yodeller %d has score %d, and is ranked %d.\n", R[j].id, R[j].score, R[j].rank);
        // }
    }

    int max = -2e9;
    for (int i = 0; i < N; i ++) {
        if (R[i].score < max) break;
        max = R[i].score;
        printf("Yodeller %d is the TopYodeller: score %d, worst rank %d\n", R[i].id, R[i].score, R[i].worst);
    }
    
    return 0;
}