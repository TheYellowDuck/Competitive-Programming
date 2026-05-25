#include <stdio.h>
#include <iostream>
#include <utility>
#include <algorithm>
#include <cstring>
using namespace std;

int N;
char names[10000][21];
pair<char*, int> C[10000];

int comparator(const void* p, const void* q)
{
    pair<char*, int> l = *(const pair<char*, int>*)p;
    pair<char*, int> r = *(const pair<char*, int>*)q;
  
    if (l.second == r.second) {
        // printf("%s %s\n", l.first, r.first);
        return strcmp(l.first, r.first);
    }

    return -(l.second - r.second);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; i ++) {
        int r, s, d;
        cin >> names[i] >> r >> s >> d;
        // cout << names[i] << endl;
        C[i] = make_pair(&names[i][0], 2 * r + 3 * s + d);
        // cout << C[i].first << " " << C[i].second << endl;
    }
    // for (auto i : C) {
    //     printf("%s ", i.first);
    // }
    // printf("\n");
    qsort(C, N, sizeof(pair<char*, int>), comparator);
    for (int i = 0; i < 2 && i < N; i ++) {
        cout << C[i].first << endl;
    }
    return 0;
}