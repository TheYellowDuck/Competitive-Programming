#include <stdio.h>
#include <iostream>
#include <utility>
using namespace std;

int N;
pair<int, int> P[2000];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N;
    for (int i = 0; i < N; i ++) {
        int x, y;
        cin >> x >> y;
        P[i] = make_pair(x, y);
    }

    pair<int, int> cur = {0, 0};
    int D = 2e9;

    for (int i = 0; 1; i ++) {
        int m = 0;
        pair<int, int> nxt;
        for (int j = 0; j < N; j ++) {
            int d = abs((cur.first - P[j].first) * (cur.first - P[j].first) + (cur.second - P[j].second) * (cur.second - P[j].second));
            cout << d << " ";
            if (m < d && d < D) {
                m = d;
                nxt = P[j];
            }
        }
        cout << endl;

        if (m == 0) {
            cout << i << endl;
            break;
        }

        cur = nxt;
        D = m;

    }

    return 0;
}