#include <stdio.h>
#include <iostream>
#include <algorithm>
using namespace std;

int circ = 1e6;

int H, K;
int houses[1000];

int checkLength(int L) {
    for (int i = 0; i < H; i ++) {
        int h = i;
        for (int j = 0; j < K; j ++) {
            int cur = houses[h];
            int stop = (cur + L) % circ;
            int cycle = 0;
            if (stop < cur) cycle = 1;
            while ((!cycle && (cur <= houses[h] && houses[h] <= stop)) || (cycle && ((cur <= houses[h] && houses[h] <= circ) || houses[h] <= stop))) { 
                h = (h + 1) % H;
                if (h == i) 
                    return 1;
            }
        }
    }
    return 0;
}

int binarySearch(int l, int r) {
    if (l > r) return -1;
    int m = (l + r) / 2;
    if (checkLength(m)) {
        int v = binarySearch(l, m - 1);
        if (v == -1) return m;
        return v;
    }
    else 
        return binarySearch(m + 1, r);
}

int compare(const void* a, const void* b) {
    return (*(int*) a) - (*(int*) b);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> H;
    for (int i = 0; i < H; i ++) {
        cin >> houses[i];
    }
    qsort(houses, H, sizeof(int), compare);
    cin >> K;

    cout << (binarySearch(0, circ - 1) + 1) / 2 << endl;

    return 0;
}