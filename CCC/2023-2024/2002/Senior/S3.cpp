#include <stdio.h>
#include <iostream>
#include <string.h>
#include <vector>
#include <utility>
using namespace std;

int R, C;
char yard[375][80];
int Q;
char Qs[30000];

inline void possiblePos(vector<pair<int, int>> cur, int o) {
    for (int q = 0; q < Q; q ++) {
        if (Qs[q] == 'L') o = (o + 3) % 4;
        else if (Qs[q] == 'R') o = (o + 1) % 4;
        else if (Qs[q] == 'B') o = (o + 2) % 4;
        else if (Qs[q] == 'f') continue;
        else {
            vector<pair<int, int>> next;
            for (pair<int, int> p : cur) {
                // int x = p.first, y = p.second;
                if (o == 0) 
                    // y --;
                    p.second --;
                else if (o == 1) 
                    // x ++;
                    p.first ++;
                else if (o == 2) 
                    // y ++;
                    p.second ++;
                else 
                    // x --;
                    p.first --;
                if (p.first < 0 || p.first >= C || p.second < 0 || p.second >= R || yard[p.second][p.first] == 'X')
                    continue;
                // next.push_back(pair(x, y));
                next.push_back(p);
            }
            cur = next;
        }
    }
    for (pair<int, int> p : cur) {
        yard[p.second][p.first] = '*';
    }
}


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> R >> C;
    vector<pair<int, int>> cur;
    for (int i = 0; i < R; i ++) {
        for (int j = 0; j < C; j ++) {
            cin >> yard[i][j];
            if (yard[i][j] != 'X') {
                cur.push_back(pair(j, i));
            }
        }
    }

    cin >> Q;

    for (int i = 0; i < Q; i ++) {
        cin >> Qs[i];
        if (Qs[i] != 'F' && i - 1 >= 0 && Qs[i - 1] != 'F') {
            if (Qs[i - 1] == 'f')
                Qs[i - 1] = Qs[i];
            else if (Qs[i - 1] == 'B') 
                Qs[i - 1] = Qs[i] == 'L' ? 'R' : 'L';
            else if (Qs[i - 1] == Qs[i])
                Qs[i - 1] = 'B';
            else
                Qs[i - 1] = 'f';
            i --;
            Q --;
        }
    }

    possiblePos(cur, 0);
    possiblePos(cur, 1);
    possiblePos(cur, 2);
    possiblePos(cur, 3);

    for (int i = 0; i < R; i ++) {
        for (int j = 0; j < C; j ++) {
            cout << yard[i][j];
        }
        cout << "\n";
    }
    return 0;
}