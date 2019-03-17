#include <bits/stdc++.h>
using namespace std;

void buildY(int ix, int iy, int sx, int ex, int sy, int ey, int **tree, int **a) {
    if(sy == ey) {
        if(sx == ex) {
            tree[ix][iy] = a[sx-1][sy-1];
        } else {
            tree[ix][iy] = tree[2*ix][iy] + tree[2*ix+1][iy];
        }
    } else {
        int mid = (sy+ey)/2;
        buildY(ix, 2*iy, sx, ex, sy, mid, tree, a);
        buildY(ix, 2*iy+1, sx, ex, mid+1, ey, tree, a);

        tree[ix][iy] = tree[ix][2*iy] + tree[ix][2*iy+1];
    }
}

void buildX(int ix, int sx, int ex, int m, int **tree, int **a) {
    if(sx != ex) {
        int mid = (sx+ex)/2;

        buildX(2*ix, sx, mid, m, tree, a);
        buildX(2*ix+1, mid+1, ex, m, tree, a);
    }

    buildY(ix, 1, sx, ex, 1, m, tree, a);
}

int rangeQueryY(int ix, int iy, int ly, int ry, int sy, int ey, int **tree) {
    if(ry < sy || ly > ey) return 0;

    if(sy >= ly && ey <= ry) {
        return tree[ix][iy];
    }

    int mid = (sy+ey)/2;
    return rangeQueryY(ix, 2*iy, ly, ry, sy, mid, tree) + rangeQueryY(ix, 2*iy+1, ly, ry, mid+1, ey, tree);
}

int rangeQueryX(int ix, int lx, int rx, int ly, int ry, int sx, int ex, int sy, int ey, int **tree) {
    if(rx < sx || lx > ex || ry < sy || ly > ey) return 0;

    if(sx >= lx && ex <= rx) {
        return rangeQueryY(ix, 1, ly, ry, sy, ey, tree);
    }

    int mid = (sx+ex)/2;
    return rangeQueryX(2*ix, lx, rx, ly, ry, sx, mid, sy, ey, tree) + rangeQueryX(2*ix+1, lx, rx, ly, ry, mid+1, ex, sy, ey, tree);
}

void pointUpdateY(int ix, int iy, int x, int y, int sx, int ex, int sy, int ey, int v, int **tree, int **a) {
    if(sy == ey) {
        if(sx == ex) {
            a[sx-1][sy-1] += v;
            tree[ix][iy] = a[sx-1][sy-1];
        } else {
            tree[ix][iy] = tree[2*ix][iy] + tree[2*ix+1][iy];
        }
    } else {
        int mid = (sy+ey)/2;
        
        if(y <= mid) {
            pointUpdateY(ix, 2*iy, x, y, sx, ex, sy, mid, v, tree, a);
        } else {
            pointUpdateY(ix, 2*iy+1, x, y, sx, ex, mid+1, ey, v, tree, a);
        }

        tree[ix][iy] = tree[ix][2*iy] + tree[ix][2*iy+1];
    }
}

void pointUpdateX(int ix, int x, int y, int sx, int ex, int sy, int ey, int v, int m, int **tree, int **a) {
    if(x < sx || x > ex || y < sy || y > ey) return;

    if(sx != ex) {
        int mid = (sx+ex)/2;
        
        if(x <= mid) {
            pointUpdateX(2*ix, x, y, sx, mid, sy, ey, v, m, tree, a);
        } else {
            pointUpdateX(2*ix+1, x, y, mid+1, ex, sy, ey, v, m, tree, a);
        }
    }

    pointUpdateY(ix, 1, x, y, sx, ex, 1, m, v, tree, a);
}

int main()
{   
    const int n = 4;
    const int m = 4;

    int *a[n];
    a[0] = new int[m]{1,2,3,4};
    a[1] = new int[m]{5,6,7,8};
    a[2] = new int[m]{9,10,11,12};
    a[3] = new int[m]{13,14,15,16};

    int *tree[4*n+1];
    for(int i = 1; i < 4*n+1; i++) {
        tree[i] = new int[4*m+1];

        for(int j = 1; j < 4*m+1; j++) {
            tree[i][j] = 0;
        }
    }

    buildX(1, 1, n, m, tree, a);
    cout << rangeQueryX(1, 3, 4, 3, 4, 1, n, 1, m, tree) << endl;

    pointUpdateX(1,2,3,1,n,1,m,10,m,tree, a);
    cout << rangeQueryX(1, 2, 2, 2, 3, 1, n, 1, m, tree) << endl;
}  
