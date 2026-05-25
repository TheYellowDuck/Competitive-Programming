#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

inline float dist_sq(float px1, float py1, float pz1, float px2, float py2, float pz2) {
    return (px1 - px2) * (px1 - px2) + (py1 - py2) * (py1 - py2) + (pz1 - pz2) * (pz1 - pz2);
}

inline float min_dist(float px, float py, float pz, float lx1, float ly1, float lz1, float lx2, float ly2, float lz2)
{
    float line_dist = dist_sq(lx1, ly1, lz1, lx2, ly2, lz2);
    if (line_dist == 0)
        return sqrt(dist_sq(px, py, pz, lx1, ly1, lz1));

    float t = ((px - lx1) * (lx2 - lx1) + (py - ly1) * (ly2 - ly1) + (pz - lz1) * (lz2 - lz1)) / line_dist;
    t = t > 0 ? (t < 1 ? t : 1) : 0;

    return sqrt(dist_sq(px, py, pz, lx1 + t * (lx2 - lx1), ly1 + t * (ly2 - ly1), lz1 + t * (lz2 - lz1)));
}

int PX, PY, PZ;
int X, Y, Z;
int d = 0, t = 4; // +x = 0, -x = 1, +y = 2, -y = 3, +z = 4, -z = 5

inline void update(char c) {
    if (c == 'U') {
        int temp = d;
        d = t;
        t = temp;
        if (t % 2 == 0) t ++;
        else t --;
    }
    else if (c == 'D') {
        int temp = d;
        d = t;
        if (d % 2 == 0) d ++;
        else d --;
        t = temp;
    }
    else {
        int cv = 0;
        if (c == 'L') cv = 1;
        int q = (d + cv) % 2;
        if (d == 0 || d == 1) {
            if (t == 2) {
                d = 4 + q;
            }
            else if (t == 3) {
                d = 5 - q;
            }
            else if (t == 4) {
                d = 3 - q;
            }
            else {
                d = 2 + q;
            }
        }
        else if (d == 2 || d == 3) {
            if (t == 0) {
                d = 5 - q;
            }
            else if (t == 1) {
                d = 4 + q;
            }
            else if (t == 4) {
                d = 0 + q;
            }
            else {
                d = 1 - q;
            }
        }
        else {
            if (t == 0) {
                d = 2 + q;
            }
            else if (t == 1) {
                d = 3 - q;
            }
            else if (t == 2) {
                d = 1 - q;
            }
            else {
                d = 0 + q;
            }
        }
    }
}

int main()
{
    scanf("%d %d %d", &X, &Y, &Z);
    scanf("%d %d %d", &PX, &PY, &PZ);

    float mind = 2e9;
    while (1) {
        int dir;
        char c;
        scanf("%d %c", &dir, &c);
        int x = X, y = Y, z = Z;
        if (d == 0) X += dir;
        else if (d == 1) X -= dir;
        else if (d == 2) Y += dir;
        else if (d == 3) Y -= dir;
        else if (d == 4) Z += dir;
        else Z -= dir;
        float dist = min_dist(PX, PY, PZ, x, y, z, X, Y, Z);
        if (dist < mind) mind = dist;
        if (c == 'E') break;
        update(c);
    }
    printf("%.2f\n", mind);
    return 0;
}