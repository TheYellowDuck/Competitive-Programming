#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int N;
int P[10][2];
double max = 0;

inline double dist (double a, double b, double c, double d) {
    return sqrt((a - c) * (a - c) + (b - d) * (b - d));
}
inline double pythagoreas (double a, double b, double c) {
    return a * a + b * b - c * c;
}

int main()
{
    scanf("%d", &N);
    for (int i = 0; i < N; i ++) {
        scanf("%d %d", &P[i][0], &P[i][1]);
    }
    
    for (int i = 0; i < N; i ++) {
        for (int j = i + 1; j < N; j ++) {
            double a = dist(P[i][0], P[i][1], P[j][0], P[j][1]);
            for (int k = j + 1; k < N; k ++) {
                double b = dist(P[j][0], P[j][1], P[k][0], P[k][1]);
                double c = dist(P[i][0], P[i][1], P[k][0], P[k][1]);
                double s = (a + b + c) / 2;

                double d = 0;

                if (s == 0 || pythagoreas(a, b, c) < 0 || pythagoreas(c, a, b) < 0 || pythagoreas(b, c, a) < 0) {
                    if (a > d) d = a;
                    if (b > d) d = b;
                    if (c > d) d = c;
                }
                else 
                    d = 2 * (a * b * c) / (4 * sqrt(s * (s - a) * (s - b) * (s - c)));

                if (d > max) max = d;
            }
        }
    }

    printf("%.2lf\n", max);
    
    return 0;
}