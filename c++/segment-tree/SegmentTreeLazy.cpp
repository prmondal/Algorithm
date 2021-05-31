#include <bits/stdc++.h>
using namespace std;

#define ll long long int
const int nax = 1e5+7;
const int TREE_SIZE = 2*(int)pow(2,ceil(log2(nax))) - 1;
ll tree[TREE_SIZE];
ll delta[TREE_SIZE];
ll arr[nax];

void build(int i, int s, int e) {
    if(s == e) {
        tree[i] = arr[s];
        return;
    }

    int mid = s + (e-s)/2;

    build(2*i, s, mid);
    build(2*i+1, mid+1, e);

    tree[i] = tree[2*i] + tree[2*i+1];
}

void propagate(int i, ll val, int s, int e) {
    tree[i] += (e-s+1) * val;
        
    if (s != e) {
        delta[2*i] += val;
        delta[2*i+1] += val;
    }
 
    delta[i] = 0;
}   
 
void rangeUpdate(int i, int l, int r, int s, int e, int val) {
    propagate(i, delta[i], s, e);
    
    if(r < s || l > e) return;
 
    if(l <= s && e <= r) {
        propagate(i, val, s, e);
        return;
    }
 
    int mid = s + (e-s)/2;
    rangeUpdate(2*i, l, r, s, mid, val);
    rangeUpdate(2*i+1, l, r, mid+1, e, val);
 
    tree[i] = tree[2*i] + tree[2*i+1];
}
 
ll rangeQuery(int i, int l, int r, int s, int e) {
    propagate(i, delta[i], s, e);
    
    if(r < s || l > e) {
        return 0;
    }
 
    if(l <= s && e <= r) {
        return tree[i];
    }
 
    int mid = s + (e-s)/2;
    return rangeQuery(2*i, l, r, s, mid) + rangeQuery(2*i+1, l, r, mid+1, e);
}

int main()
{   
    memset(tree, 0, sizeof(tree));
    memset(delta, 0, sizeof(delta));

    int n = 10;
    for (int i = 1; i <= n; i++) arr[i] = i;

    build(1, 1, n);
    
    cout << "============ All Subarray Sum ============" << endl;
    for(int i = 1; i <= n; i++) {
        for(int j = i; j <= n; j++) {
            cout << "[" << i << ", " << j << "]: " << rangeQuery(1, i, j, 1, n) << endl;
        }
    }

    cout << "============ Range Update ============" << endl;
    int i = 1, j = n;
    int v = 1;
    cout << "Increase [" << i << ", " << j << "] by " << v << endl;
    rangeUpdate(1, i, j, 1, n, v);
    cout << "Sum in [1, 10] is " << rangeQuery(1, 1, 10, 1, n) << endl;

    i = 1;
    j = 5;
    v = 2;

    cout << "Increase [" << i << ", " << j << "] by " << v << endl;
    rangeUpdate(1, i, j, 1, n, v);

    v = 3;
    cout << "Increase [" << i << ", " << j << "] by " << v << endl;
    rangeUpdate(1, i, j, 1, n, v);

    cout << "Sum in [1, 5] is " << rangeQuery(1, 1, 5, 1, n) << endl;
}  
