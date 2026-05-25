#include <stdio.h>
#include <iostream>
#include <unordered_set>
#include <tuple>
using namespace std;

int N, M;
int P, Q;
int B = 1, D = 1, S = 1;
double X, Y;
double side1, side2;
double newSide1, newSide2;

struct hashFunction
{
    size_t operator()(const tuple<int, double, double> &x) const
    {
        return ((long long int)(get<1>(x) * 1e15)) ^ (get<0>(x)) * ((long long int)(get<2>(x) * 1e15));
    }
};

unordered_set<tuple<int, double, double>, hashFunction> V;

inline void newSide()
{
    if (D == 0) {
        if (S == 0) {
            newSide1 = N - X;
            double ratio = newSide1 / side2;
            newSide2 = side1 * ratio;
            Y = newSide2;
            if (Y > M) {
                Y = M;
                newSide2 = M;
                ratio = newSide2 / side1;
                newSide1 = side2 * ratio;
                X += newSide1;
                double t = newSide1;
                newSide1 = newSide2;
                newSide2 = t;
                D = 1;
                S = 2;
            }
            else {
                X = N;
                D = 1;
                S = 1;
            }
        }
        else {
            newSide1 = Y;
            double ratio = newSide1 / side2;
            newSide2 = side1 * ratio;
            X = N - newSide2;
            if (X < 0) {
                X = 0;
                newSide2 = N;
                ratio = newSide2 / side1;
                newSide1 = side2 * ratio;
                Y -= newSide1;
                double t = newSide1;
                newSide1 = newSide2;
                newSide2 = t;
                D = 3;
                S = 3;
            }
            else {
                Y = 0;
                D = 3;
                S = 0;
            }
        }
    }
    else if (D == 1) {
        if (S == 1) {
            newSide1 = M - Y;
            double ratio = newSide1 / side2;
            newSide2 = side1 * ratio;
            X = N - newSide2;
            if (X < 0) {
                X = 0;
                newSide2 = N;
                ratio = newSide2 / side1;
                newSide1 = side2 * ratio;
                Y += newSide1;
                double t = newSide1;
                newSide1 = newSide2;
                newSide2 = t;
                D = 2;
                S = 3;
            }
            else {
                Y = M;
                D = 2;
                S = 2;
            }
        }
        else {
            newSide1 = N - X;
            double ratio = newSide1 / side2;
            newSide2 = side1 * ratio;
            Y = M - newSide2;
            if (Y < 0) {
                Y = 0;
                newSide2 = M;
                ratio = newSide2 / side1;
                newSide1 = side2 * ratio;
                X += newSide1;
                double t = newSide1;
                newSide1 = newSide2;
                newSide2 = t;
                D = 0;
                S = 0;
            }
            else {
                X = N;
                D = 0;
                S = 1;
            }
        }
    }
    else if (D == 2) {
        if (S == 2) {
            newSide1 = X;
            double ratio = newSide1 / side2;
            newSide2 = side1 * ratio;
            Y = M - newSide2;
            if (Y < 0) {
                Y = 0;
                newSide2 = M;
                ratio = newSide2 / side1;
                newSide1 = side2 * ratio;
                X -= newSide1;
                double t = newSide1;
                newSide1 = newSide2;
                newSide2 = t;
                D = 3;
                S = 0;
            }
            else {
                X = 0;
                D = 3;
                S = 3;
            }
        }
        else {
            newSide1 = M - Y;
            double ratio = newSide1 / side2;
            newSide2 = side1 * ratio;
            X = newSide2;
            if (X > N) {
                X = N;
                newSide2 = N;
                ratio = newSide2 / side1;
                newSide1 = side2 * ratio;
                Y += newSide1;
                double t = newSide1;
                newSide1 = newSide2;
                newSide2 = t;
                D = 1;
                S = 1;
            }
            else {
                Y = M;
                D = 1;
                S = 2;
            }
        }
    }
    else {
        if (S == 3) {
            newSide1 = Y;
            double ratio = newSide1 / side2;
            newSide2 = side1 * ratio;
            X = newSide2;
            if (X > N) {
                X = N;
                newSide2 = N;
                ratio = newSide2 / side1;
                newSide1 = side2 * ratio;
                Y -= newSide1;
                double t = newSide1;
                newSide1 = newSide2;
                newSide2 = t;
                D = 0;
                S = 1;
            }
            else {
                Y = 0;
                D = 0;
                S = 0;
            }
        }
        else {
            newSide1 = X;
            double ratio = newSide1 / side2;
            newSide2 = side1 * ratio;
            Y = newSide2;
            if (Y > M) {
                Y = M;
                newSide2 = M;
                ratio = newSide2 / side1;
                newSide1 = side2 * ratio;
                X -= newSide1;
                double t = newSide1;
                newSide1 = newSide2;
                newSide2 = t;
                D = 2;
                S = 2;
            }
            else {
                X = 0;
                D = 2;
                S = 3;
            }
        }
    }
    // printf("(%lf, %lf), (%lf, %lf), (%lf, %lf), (%d, %d)\n", X, Y, side1, side2, newSide1, newSide2, D, S);
}

inline int checkPot()
{
    int count = 0;
    
    if (X < 5) 
        count ++;
    if (Y < 5)
        count ++;
    if (X > N - 5) 
        count ++;
    if (Y > M - 5) 
        count ++;
    if (count >= 2)
        return 1;
    return 0;
}

int main()
{
    scanf("%d %d %d %d", &N, &M, &P, &Q);
    X = N;
    Y = Q;
    side1 = N - P;
    side2 = Q;
    while (1)
    {
        // printf("%d %lf %lf\n", D, side1, side2);
        newSide();
        if (checkPot() == 1) {
            printf("%d\n", B);
            return 0;
        }
        int size = V.size();
        V.emplace(tuple(S * 10 + D, X, Y));
        if (size == V.size()) {
            printf("0\n");
            return 0;
        }
        side1 = newSide1;
        side2 = newSide2;
        B ++;
    }
    return 0;
}