#include <stdio.h>
#include <iostream>
#include <cmath>
#include <cstring>
#include <iomanip>
using namespace std;

int T;
int ranking[100002];

inline int binary_search(int l, int r, int v) {
    if (l > r) return -1;
    int m = (l + r) / 2;
    // if (ranking[m] == v) return m;
    if (ranking[m] <= v) {
        int i = binary_search(l, m - 1, v);
        if (i == -1) return m;
        return i;
    }
    else return binary_search(m + 1, r, v);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> T;

    double sum = 0;
    ranking[1] = -1;
    for (int i = 1; i <= T; i ++) {
        int v;
        cin >> v;
        int idx = binary_search(1, i, v);
        if (idx == -1) idx = 1;
        memmove(&ranking[idx + 1], &ranking[idx], (i - idx + 1) * sizeof(int));
        // memcpy(&ranking[idx + 1], &ranking[idx], (i - idx) * sizeof(int));
        ranking[idx] = v;
        sum += idx;
        cout << v << " " << idx << " " << sum << "\n";
        // for (int j = 1; j <= i; j ++) {
        //     if (j == idx) cout << "***" << ranking[j] << "*** ";
        //     else cout << ranking[j] << " ";
        // }
        if (ranking[idx] == ranking[idx - 1]) cout << "error1\n";
        for (int j = 1; j <= i; j ++) if (ranking[j] < ranking[j + 1]) cout << "error2: " << j << " " << ranking[j] << "\n";
        cout << "\n";
    }
    // cout << sum << "\n";
    cout.setf(ios::fixed);
    cout.setf(ios::showpoint);
    cout << setprecision(2) << sum / T - 0.001 << "\n";
    // for (int i = 1; i <= T; i ++) if (ranking[i] < ranking[i + 1]) cout << "error: " << i << " " << ranking[i] << "\n";

    return 0;
}