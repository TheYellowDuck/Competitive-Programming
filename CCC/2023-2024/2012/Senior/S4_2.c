#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef unsigned int uint;
// typedef MAXR 100000000;
#define MAX 1000000

int N;
int ans;

static inline void debugprint(uint cur[8]) {
    printf("-------------------------\n");
    for (int i = 0; i < N; i ++) {
        uint printval = cur[i];
        printf("%d: ", i + 1);
        while (printval > 0) {
            printf("%d ", (printval & 0b1111));
            printval = (printval >> 4);
        }
        printf("\n");
    }
    printf("-------------------------\n");

}

static inline int shorten(uint cur[8]) {
    int val = 13;
    for (int i = 0; i < N; i ++) 
        val = val * 37 + cur[i];
    return val;
}

int record[MAX];
int recordi = 0;
uint game[MAX][8];
int depths[MAX];
int addi = 0;
int geti = -1;

static inline int binarysearch (int val, int l, int r) {
    if (r < 0) return -1;
    if (record[r] < val) return r;
    else if (r == 0) return -1;

    int ans = -1;
    while (l <= r) {
        int m = (l + r) / 2;
        if (record[m] < val) {
            ans = m;
            l = m + 1;
        }
        else r = m - 1;
    }
    return ans;
}

static inline void add(uint cur[8], int depth) {
    if (addi == MAX) addi = 0;
    depths[addi] = depth;
    // game[addi ++] = cur;
    memcpy(&game[addi][0], &cur[0], sizeof(game[addi]));
    // debugprint(game[addi]);
    addi ++;
    int val = shorten(cur);
    int inserti = binarysearch(val, 0, recordi - 1) + 1;
    if (inserti != recordi) {
        // printf("%d %d\n", recordi, inserti);
        memmove(&record[inserti + 1], &record[inserti], (recordi - inserti) * sizeof(int));
        // for (int l = 0; l <= recordi; l ++) printf("%d ", record[l]);
        // printf("\n");
    }
    record[inserti] = val; 
    recordi ++;
}
static inline void get(uint* cur, int* depth) {
    geti ++;
    if (geti == MAX) geti = 0;
    if (geti == addi) {
        addi ++;
        ans = -1;
        return;
    }
    *depth = depths[geti];
    // uint val[8] = game[geti ++];
    memcpy(cur, &game[geti][0], 8 * sizeof(*cur));
    // *cur = game[geti ++];
}
static inline int valid(uint a, uint b) {
    uint aval = (a & 0b1111);
    uint bval = (b & 0b1111);
    int returnv = 0;
    if (aval == 0 && bval == 0) return 0;
    if (aval == 0) return 1;
    if (bval == 0) return -1;
    return (aval - bval);
}
// static inline void move(uint cur[8], int i, int j, uint* next) {
//     memcpy(next, &cur[0], 8 * sizeof(next));
//     uint val = (next[j] & 0b1111);
//     next[j] = (next[j] >> 4);
//     next[i] = (next[i] << 4) + val;
//     // memcpy(next, &dest, 8 * sizeof(*next));
// }

int main() {
    scanf("%d", &N);
    while (N) {
        memset(&record, 0, sizeof(record));
        recordi = 0;
        addi = 0;
        geti = -1;
        uint start[8];
        int checkwin = 1;
        ans = 0;
        for (int i = 0; i < N; i ++) {
            scanf("%u", &start[i]);
            // printf("%d\n", start[i]);
            if (i + 1 != start[i]) checkwin = 0;
        }
        if (checkwin) goto end;

        add(start, 0);

        while (1) {
            uint cur[8];
            int depth;
            get(cur, &depth);
            if (ans == -1) goto end;
            // printf("CUR: \n");
            // debugprint(cur);
            // printf("%d\n", depth);
            for (int i = 0; i < N - 1; i ++) {
                int j = i + 1;
                uint next[8];
                // printf("CUR: \n");
                // debugprint(cur);
                // printf("indexes: %d %d\n", i, j);
                int validcheck = valid(cur[i], cur[j]);
                if (validcheck > 0) {
                    // printf("a %u %d\n", cur[j], j);
                    if (cur[j] != 0) {
                        // printf("a1\n");
                        // printf("Mid Indexes: %d %d\n", i, j);
                        // move(cur, i, j, &next);
                        memcpy(&next[0], &cur[0], sizeof(next));
                        uint val = (next[j] & 0b1111);
                        next[j] = (next[j] >> 4);
                        next[i] = (next[i] << 4) + val;
                        // printf("Mid.5 Indexes: %d %d\n", i, j);
                    }
                    else {
                        printf("a2\n");
                        goto nextcycle;
                    }
                } 
                else if (validcheck < 0 ) {
                    // printf("b %u %d\n", cur[i], i);
                    if (cur[i] != 0) {
                        // printf("b1\n");
                        // printf("Mid Indexes: %d %d\n", i, j);
                        // move(cur, j, i, &next);
                        memcpy(&next[0], &cur[0], sizeof(next));
                        uint val = (next[i] & 0b1111);
                        next[i] = (next[i] >> 4);
                        next[j] = (next[j] << 4) + val;
                        // printf("Mid.5 Indexes: %d %d\n", i, j);
                    }
                    else {
                        printf("b2\n");
                        goto nextcycle;
                    }
                }
                else goto nextcycle;
                // printf("Mid1 Indexes: %d %d\n", i, j);
                // printf("NEXT: \n");
                // debugprint(next);
                int snext = shorten(next);
                int check = binarysearch(snext, 0, recordi - 1) + 1;
                // printf("%d %d %d\n", check, snext, record[check]);
                if (record[check] == snext) goto nextcycle;
                int win = 1;
                for (int k = 0; k < N; k ++) {
                    if (k + 1 != next[k]) win = 0;
                }
                if (win) {
                    ans = depth + 1;
                    goto end;
                }
                add(next, depth + 1);
                nextcycle:;
                // printf("End Indexes: %d %d\n", i, j);
                
            }
        }
        end:;
        if (ans != -1)
            printf("%d\n", ans);
        else printf("IMPOSSIBLE\n");
        scanf("%d", &N);
    }
    
    return 0;
}