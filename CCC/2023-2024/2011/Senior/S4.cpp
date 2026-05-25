#include <stdio.h>
#include <iostream>
using namespace std;

int B[8];
int P[8];
int C = 0;
int R[8] = {0, 1, 2, 123, 4, 145, 246, 1234567};

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    for (int i = 0; i < 8; i ++) {
        cin >> B[i];
    }
    for (int i = 0; i < 8; i ++) {
        cin >> P[i];
    }

    for (int i = 0; i < 8; i += 2) {
        if (P[i] <= B[i]) {
            C += P[i];
            B[i] -= P[i];
        }
        else {
            C += B[i];
            P[i] -= B[i];
            B[i] = 0;
            int r = R[i] / 10;
            while (r >= 0) {
                int s = r % 10;
                if (P[i] <= B[s]) {
                    C += P[i];
                    B[s] -= P[i];
                    break; 
                }
                else {
                    C += B[s];
                    P[i] -= B[s];
                    B[s] = 0;
                }
                
                if (r == 0) break;
                r /= 10;
            }
        }
    }
    for (int i = 1; i < 8; i += 2) {
        if (P[i] <= B[i]) {
            C += P[i];
            B[i] -= P[i];
        }
        else {
            C += B[i];
            P[i] -= B[i];
            B[i] = 0;
            int r = R[i] / 10;
            while (r >= 0) {
                int s = r % 10;
                if (P[i] <= B[s]) {
                    C += P[i];
                    B[s] -= P[i];
                    break; 
                }
                else {
                    C += B[s];
                    P[i] -= B[s];
                    B[s] = 0;
                }
                
                if (r == 0) break;
                r /= 10;
            }
        }
    }
    cout << C << endl;


    return 0;
}