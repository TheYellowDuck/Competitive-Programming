#include <stdio.h>
#include <iostream>
#include <string.h>
#include <unordered_set>
#include <queue>
// #include <unistd.h>
using namespace std;

int N;
unordered_set<string> set;
queue<string> Q;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; i ++) {
        string S;
        cin >> S;
        Q.emplace(S);
        set.emplace("");
        set.emplace(S);
        while(!Q.empty()) {
            string s = Q.front();
            // usleep(500000);
            cout << "running" << endl;
            s.pop_back();
            if (set.count(s) == 0) {
                Q.emplace(s);
                set.emplace(s);
            }
            Q.front().erase(0, 1);
            if (set.count(Q.front()) == 0) {
                Q.emplace(Q.front());
                set.emplace(Q.front());
            }
            Q.pop();
        }
        cout << set.size() << "\n";
        // cout << sizeof(set) << " " << sizeof(Q) << "\n";
        set.clear();
    }

    return 0;
}