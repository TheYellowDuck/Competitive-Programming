#include <stdio.h>
#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int T, N;
vector<int> M;
stack<int> B;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> T;
    for (int t = 0; t < T; t ++) {
        M.clear();
        B = {};
        cin >> N;
        for (int i = 0; i < N; i ++) {
            int v;
            cin >> v;
            M.push_back(v);
        }
        int n = 1;
        for (int i = N - 1; i >= 0; i --) {
            B.push(M[i]);
            while (!B.empty() && B.top() == n) {
                B.pop();
                n ++;
            }
        }
        cout << (B.empty() ? "Y" : "N") << endl;
    }
    return 0;
}