#include <stdio.h>
#include <iostream>
#include <unordered_set>
using namespace std;

int T;
int N, K, W;
pair<int, int> P[30001];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> T;
    for (int t = 0; t < T; t ++) {
        cin >> N >> K >> W;
        for (int i = 0; i < N; i ++) {
            P[i][1] = i;
            int v;
            scanf("%d", &v);
            P[i + 1][0] -= v;
            if (i - W + 1>= 0) 
                P[i - W + 1][0] += v;
            else 
                P[0][0] += v;
        }
        
    }
    return 0;
}