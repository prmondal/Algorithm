#include <bits/stdc++.h>
using namespace std;
 
const int MAX_SIZE = 1e5+7;

typedef long long ll;

typedef struct {
    ll firstMax = 0;
    ll secondMax = 0;
    ll best = 0;
} node;

node *tree = new node[4*MAX_SIZE];
ll a[MAX_SIZE];

void build(int i, int s, int e) {
    if(s == e) {
        tree[i].firstMax = a[s];
        tree[i].secondMax = a[s];
        tree[i].best = a[s];
        return;
    }

    int mid = s + (e-s)/2;

    build(2*i, s, mid);
    build(2*i+1, mid+1, e);
    
    tree[i].firstMax = max(tree[2*i].firstMax, tree[2*i+1].firstMax);
    tree[i].secondMax = max(tree[2*i].secondMax, tree[2*i+1].secondMax);
    tree[i].best = max(tree[2*i].best, max(tree[2*i+1].best, tree[2*i].firstMax + tree[2*i+1].firstMax));
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
    n.firstMax = max(left.firstMax, right.firstMax);
    n.secondMax = max(left.secondMax, right.secondMax);
    n.best = max(left.best, max(right.best, left.firstMax + right.firstMax));
    return n;
}

void pointUpdate(int i, int p, int s, int e, ll v) {
    if (p < s || p > e) return;
    
    if(s == e) {
        a[s] = v;
        tree[i].firstMax = a[s];
        tree[i].secondMax = a[s];
        tree[i].best = a[s];
        return;
    }

    int mid = s + (e-s)/2;

    if (p <= mid) {
        pointUpdate(2*i, p, s, mid, v);
    } else {
        pointUpdate(2*i+1, p, mid + 1, e, v);
    }

    tree[i].firstMax = max(tree[2*i].firstMax, tree[2*i+1].firstMax);
    tree[i].secondMax = max(tree[2*i].secondMax, tree[2*i+1].secondMax);
    tree[i].best = max(tree[2*i].best, max(tree[2*i+1].best, tree[2*i].firstMax + tree[2*i+1].firstMax));
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
        string type;
        cin >> type;

        if (type == "U") {
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