#include <stdio.h>
#include <iostream>
#include <vector>
using namespace std;

int N;

int tf(vector<int> L) {
    // for (auto i : L) cout << i << " ";
    // cout << endl;
    if (L.size() == 1) return L[0] > 24 ? 0 : L[0];
    int m = 0;
    for (int i = 0; i < L.size(); i ++) {
        int a = L[i];
        for (int j = 0; j < L.size(); j ++) {
            if (i == j) continue;
            int b = L[j];
            vector<int> t = L;
            int x = max(i, j);
            int y = min(i, j);
            t.erase(t.begin() + x);
            t[y] = a + b;
            m = max(m, tf(t));
            t[y] = a - b;
            m = max(m, tf(t));
            t[y] = a * b;
            m = max(m, tf(t));
            if (b != 0 && a % b == 0) {
                t[y] = a / b;
                m = max(m, tf(t));
            }
        }
    }
    return m;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; i ++) {
        vector<int> C;
        for (int j = 0; j < 4; j ++) {
            int v;
            cin >> v;
            C.push_back(v);
        }
        cout << tf(C) << endl;
    }
    return 0;
}