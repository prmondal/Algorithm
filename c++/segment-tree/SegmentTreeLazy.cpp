#include <bits/stdc++.h>
using namespace std;

void build(int i, int s, int e, int *tree, int *a) {
    if(s == e) {
        tree[i] = a[s-1];
        return;
    }

    int mid = s + (e-s)/2;

    build(2*i, s, mid, tree, a);
    build(2*i+1, mid+1, e, tree, a);

    tree[i] = tree[2*i] + tree[2*i+1];
}

void propagate(int i, int *delta) {
    delta[2*i] += delta[i];
    delta[2*i+1] += delta[i];
    delta[i] = 0;
}

void update(int i, int *tree, int *delta) {
    tree[i] = tree[2*i] + delta[2*i] + tree[2*i+1] + delta[2*i+1];
}

void rangeUpdate(int i, int l, int r, int s, int e, int v, int *tree, int *delta) {
    if(r < s || l > e) return;

    if(l <= s && e <= r) {
        delta[i] += v;
        return;
    }

    propagate(i, delta);

    int mid = s + (e-s)/2;
    rangeUpdate(2*i, l, r, s, mid, v, tree, delta);
    rangeUpdate(2*i+1, l, r, mid+1, e, v, tree, delta);

    update(i, tree, delta);
}

int rangeQuery(int i, int l, int r, int s, int e, int *tree, int *delta) {
    if(r < s || l > e) {
        return 0;
    }

    if(l <= s && e <= r) {
        return tree[i] + delta[i] * (e-s+1);
    }

    propagate(i, delta);

    int mid = s + (e-s)/2;
    int lv = rangeQuery(2*i, l, r, s, mid, tree, delta);
    int rv = rangeQuery(2*i+1, l, r, mid+1, e, tree, delta);

    return lv + rv;
}

int main()
{   
    int n = 10;
    int *a = new int[n]{1,2,3,4,5,6,7,8,9,10};
    int *tree = new int[4*n+1];
    int *delta = new int[4*n+1];

    for(int i = 0; i < 4*n+1; i++) {
        tree[i] = 0;
        delta[i] = 0;
    }

    build(1, 1, n, tree, a);
    
    cout << "============ All Subarray Sum ============" << endl;
    for(int i = 1; i <= n; i++) {
        for(int j = i; j <= n; j++) {
            cout << "[" << i << ", " << j << "]: " << rangeQuery(1, i, j, 1, n, tree, delta) << endl;
        }
    }

    cout << "============ Range Update ============" << endl;
    int i = 1, j = n;
    int v = 1;
    cout << "Increase [" << i << ", " << j << "] by " << v << endl;
    rangeUpdate(1, i, j, 1, n, v, tree, delta);
    cout << "Sum in [1, 10] is " << rangeQuery(1, 1, 10, 1, n, tree, delta) << endl;

    i = 1;
    j = 5;
    v = 2;

    cout << "Increase [" << i << ", " << j << "] by " << v << endl;
    rangeUpdate(1, i, j, 1, n, v, tree, delta);

    v = 3;
    cout << "Increase [" << i << ", " << j << "] by " << v << endl;
    rangeUpdate(1, i, j, 1, n, v, tree, delta);

    cout << "Sum in [1, 5] is " << rangeQuery(1, 1, 5, 1, n, tree, delta) << endl;
}  
