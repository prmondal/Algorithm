#include <bits/stdc++.h>
using namespace std;
 
const int MAX_SIZE = 5e5+7;
const int MIN_VAL = -100000000;

typedef long long ll;

typedef struct {
    ll sum = 0;
    ll maxPrefSum = MIN_VAL;
    ll maxSuffSum = MIN_VAL;
    ll best = MIN_VAL;
} node;

node *tree = new node[4*MAX_SIZE];
ll a[MAX_SIZE];

void build(int i, int s, int e) {
    if(s == e) {
        tree[i].sum = a[s];
        tree[i].maxPrefSum = a[s];
        tree[i].maxSuffSum = a[s];
        tree[i].best = a[s];
        return;
    }

    int mid = s + (e-s)/2;

    build(2*i, s, mid);
    build(2*i+1, mid+1, e);
    
    tree[i].maxPrefSum = max(tree[2*i].maxPrefSum, tree[2*i].sum + tree[2*i+1].maxPrefSum);
    tree[i].maxSuffSum = max(tree[2*i+1].maxSuffSum, tree[2*i].maxSuffSum + tree[2*i+1].sum);
    tree[i].sum = tree[2*i].sum + tree[2*i+1].sum;
    tree[i].best = max(tree[2*i].best, max(tree[2*i+1].best, tree[2*i].maxSuffSum + tree[2*i+1].maxPrefSum));
}

node rangeQuery(int i, int l, int r, int s, int e) {
    if(r < s || l > e) {
        node n;
        return n;
    }
 
    if(l <= s && e <= r) {
        return tree[i];
    }
 
    int mid = s + (e-s)/2;
    node left = rangeQuery(2*i, l, r, s, mid);
    node right = rangeQuery(2*i+1, l, r, mid+1, e);
    
    node n;
    n.maxPrefSum = max(left.maxPrefSum, left.sum + right.maxPrefSum);
    n.maxSuffSum = max(right.maxSuffSum, left.maxSuffSum + right.sum);
    n.sum = left.sum + right.sum;
    n.best = max(left.best, max(right.best, left.maxSuffSum + right.maxPrefSum));
    
    return n;
}

void pointUpdate(int i, int p, int s, int e, ll v) {
    if (p < s || p > e) return;

    if (s == e) {
        a[s] = v;
        tree[i].sum = a[s];
        tree[i].maxPrefSum = a[s];
        tree[i].maxSuffSum = a[s];
        tree[i].best = a[s];
        return;
    }

    int mid = s + (e-s)/2;

    if (p <= mid) {
        pointUpdate(2*i, p, s, mid, v);
    } else {
        pointUpdate(2*i+1, p, mid + 1, e, v);
    }

    tree[i].maxPrefSum = max(tree[2*i].maxPrefSum, tree[2*i].sum + tree[2*i+1].maxPrefSum);
    tree[i].maxSuffSum = max(tree[2*i+1].maxSuffSum, tree[2*i].maxSuffSum + tree[2*i+1].sum);
    tree[i].sum = tree[2*i].sum + tree[2*i+1].sum;
    tree[i].best = max(tree[2*i].best, max(tree[2*i+1].best, tree[2*i].maxSuffSum + tree[2*i+1].maxPrefSum));
}
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    build(1, 0, n-1);

    int m;
    cin >> m;

    for (int i = 0; i < m; i++) {
        int type;
        cin >> type;

        if (type == 0) {
            int x;
            ll y;
            cin >> x >> y;
            pointUpdate(1, x-1, 0, n-1, y);
        } else {
            int l, r;
            cin >> l >> r;
            cout << rangeQuery(1, l-1, r-1, 0, n-1).best << endl;
        }
    }
} 