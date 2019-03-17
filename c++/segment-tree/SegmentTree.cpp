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

void pointUpdate(int p, int i, int s, int e, int v, int *tree, int *a) {
    if(p < s || p > e) return;

    if(s == e) {
        a[s-1] += v;
        tree[i] = a[s-1];
        return; 
    }

    int mid = s + (e-s)/2;

    if(p <= mid) {
        pointUpdate(p, 2*i, s, mid, v, tree, a);
    } else {
        pointUpdate(p, 2*i+1, mid+1, e, v, tree, a);
    }
    

    tree[i] = tree[2*i] + tree[2*i+1];
}

int rangeQuery(int i, int l, int r, int s, int e, int *tree) {
    if(r < s || l > e) {
        return 0;
    }

    if(l <= s && e <= r) return tree[i];

    int mid = s + (e-s)/2;
    return rangeQuery(2*i, l, r, s, mid, tree) + rangeQuery(2*i+1, l, r, mid+1, e, tree);
}

int main()
{   
    int n = 10;
    int *a = new int[n]{1,2,3,4,5,6,7,8,9,10};
    int *tree = new int[4*n+1];

    build(1, 1, n, tree, a);
    
    cout << "============ All Subarray Sum ============" << endl;
    for(int i = 1; i <= n; i++) {
        for(int j = i; j <= n; j++) {
            cout << "[" << i << ", " << j << "]: " << rangeQuery(1, i, j, 1, n, tree) << endl;
        }
    }

    cout << "============ Point Update ============" << endl;
    int p = 5;
    int v = 2;

    cout << "Increase pos " << p << " by " << v << endl;
    pointUpdate(p, 1, 1, n, v, tree, a);
    cout << "Sum in [5, 5] is " << rangeQuery(1, 5, 5, 1, n, tree) << endl;
    cout << "Sum in [4, 6] is " << rangeQuery(1, 4, 6, 1, n, tree) << endl;
    cout << "Sum in [7, 8] is " << rangeQuery(1, 7, 8, 1, n, tree) << endl;
}  
