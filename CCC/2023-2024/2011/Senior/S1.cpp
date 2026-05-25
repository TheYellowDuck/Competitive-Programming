#include <bits/stdc++.h>

using namespace std;
int N;
char L[101];
int c = 0;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    for (int i = 0; i <= N; i ++) {
        cin.getline(L, 101);
        for (char j : L) {
            if (j == 's' || j == 'S') c ++;
            if (j == 't' || j == 'T') c --;
        }
    }
    
    if (c >= 0) cout << "French";
    else cout << "English";
    
    return 0;
}