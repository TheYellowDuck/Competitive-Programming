#include <stdio.h>
#include <iostream>
#include <utility>
using namespace std;

int N;
pair<int, int> P[2000];
int D[2000][2000];
int A[2001][2000];


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N;
    for (int i = 0; i < N; i ++) {
        int x, y;
        cin >> x >> y;
        P[i] = make_pair(x, y);
        // for (int j = i - 1; j >= 0; j --) {
        //     D[i][j] = abs((P[i].first - P[j].first) * (P[i].first - P[j].first) + (P[i].second - P[j].second) * (P[i].second - P[j].second));
        //     D[j][i] = D[i][j];
        // }
    }

    for (int i = 0; i < N; i ++) {
        A[1][i] = abs(P[i].first * P[i].first + P[i].second * P[i].second);
    }

    for (int i = 2; 1; i ++) {
        int c = 0;
        for (int j = 0; j < N; j ++) {
            int m = 0;
            for (int k = 0; k < N; k ++) {
                int d = abs((P[k].first - P[j].first) * (P[k].first - P[j].first) + (P[k].second - P[j].second) * (P[k].second - P[j].second));
                if (m < d && d < A[i - 1][k]) {
                    m = d;
                }
            }
            if (m != 0) {
                A[i][j] = m;
                c = 1;
            }
            // cout << A[i][j] << " ";
        }
        // cout << endl;
        if (!c) {
            cout << (i - 1) << endl;
            break;
        }
    }

    return 0;
}