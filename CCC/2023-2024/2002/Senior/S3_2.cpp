#include <stdio.h>
#include <iostream>
#include <string.h>
using namespace std;

int R, C;
char yard[375][80];
int Q;
char Qs[30000];
int W = 0, H = 0;

inline void possiblePos(int x, int y, int o) {
    for (int q = 0; q < Q; q ++) {
        if (Qs[q] == 'L') o = (o + 3) % 4;
        else if (Qs[q] == 'R') o = (o + 1) % 4;
        else if (Qs[q] == 'B') o = (o + 2) % 4;
        else if (Qs[q] == 'f') continue;
        else {
        // cout << x << " " << y << "\n";
            if (o == 0) 
                y --;
            else if (o == 1) 
                x ++;
            else if (o == 2) 
                y ++;
            else 
                x --;
            if (x < 0 || x >= C || y < 0 || y >= R || yard[y][x] == 'X')
                return;
        }
    }
    // cout << x << " " << y << " *\n";
    yard[y][x] = '*';
}


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> R >> C;
    for (int i = 0; i < R; i ++) {
        for (int j = 0; j < C; j ++) {
            cin >> yard[i][j];
        }
    }

    cin >> Q;
    int d = 0;
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
        else if (Qs[i] == 'F' && i - 1 >= 0 && Qs[i - 1] == 'f') {
            Qs[i - 1] = Qs[i];
            i --;
            Q --;
        }
    }

    for (int o = 0; o < 4; o ++) {
        for (int i = 0; i < R; i ++) {
            for (int j = 0; j < C; j ++) {
                if (yard[i][j] == 'X') continue;
                possiblePos(j, i, o);
                // cout << endl;
            }
        }
    }

    for (int i = 0; i < R; i ++) {
        for (int j = 0; j < C; j ++) {
            cout << yard[i][j];
        }
        cout << "\n";
    }
    return 0;
}