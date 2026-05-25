#include <stdio.h>
#include <iostream>
using namespace std;

int W, N;
int T = 0;
int w[100000];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> W >> N;
    int sum = 0;
    for (int i = 0; i < N; i ++) {
        cin >> w[i];
        if (i - 4 >= 0) sum -= w[i - 4];
        sum += w[i];
        if (sum > W) break;
        T ++;
    }
    cout << T << endl;
    return 0;
}