#include <bits/stdc++.h>

using namespace std;
int N;
char ans[10001];
char c;
int cnt = 0;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; i ++) {
        cin >> ans[i];
    }
    for (int i = 0; i < N; i ++) {
        cin >> c;
        if (c == ans[i]) cnt ++;
    }
    cout << cnt;
    return 0;
}
