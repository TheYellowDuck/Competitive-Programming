#include <stdio.h>
#include <iostream>
#include <string>
#include <unordered_set>
using namespace std;

int L, N;
string C[100];
unordered_set<string> visited;

int idx; int c = 0;

int find_height(int d) {
    // int cur = index;
    // if (cur == N) return d;
    int size = visited.size();
    visited.emplace(C[idx]);
    if (visited.size() == size) {
        c ++;
        return d;
    }
    // cout << C[idx] << " " << (d + 1) << "\n";
    idx ++;
    int max = d + 1;
    for (; idx < N; idx ++) {
        int v = find_height(d + 1);
        if (v > max) max = v;
        if (c == 1) {
            c = 0;
            return max;
        }

    }
    return max;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> L;
    for (int i = 0; i < L; i ++) {
        visited.clear();
        idx = 0;
	    cin >> N;
	    for (int j = N - 1; j >= 0; j --) {
            cin >> C[j];
        }
        int v = find_height(0);
        cout << (N - (v - 1) * 2) * 10 << "\n";
    }


    return 0;
}