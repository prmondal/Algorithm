#include <bits/stdc++.h>
using namespace std;

const int MAX_SIZE = 1e5+7;

typedef struct {
    int zero = 1;
    int one = 0;
    int two = 0;
} node;

node *tree = new node[4*MAX_SIZE];
int *delta = new int[4*MAX_SIZE];

void build(int i, int s, int e) {
    if(s == e) {
        return;
    }

    int mid = s + (e-s)/2;

    build(2*i, s, mid);
    build(2*i+1, mid+1, e);
    
    tree[i].zero = tree[2*i].zero + tree[2*i+1].zero;
    tree[i].one = tree[2*i].one + tree[2*i+1].one;
    tree[i].two = tree[2*i].two + tree[2*i+1].two;
}

void propagate(int i, int val, int s, int e) {
    val = val % 3;
    
    if (val == 1) {
        int t = tree[i].zero;
        tree[i].zero = tree[i].two;
        tree[i].two = tree[i].one;
        tree[i].one = t;
    } else if (val == 2) {
        int t = tree[i].zero;
        tree[i].zero = tree[i].one;
        tree[i].one = tree[i].two;
        tree[i].two = t;
    }
    
    if (s != e) {
        delta[2*i] = (delta[2*i]+val) % 3;
        delta[2*i+1] = (delta[2*i+1]+val) % 3;
    }
 
    delta[i] = 0;
}

void rangeUpdate(int i, int l, int r, int s, int e, int val) {
    if(delta[i] > 0) {
        propagate(i, delta[i], s, e);
    }
    
    if(r < s || l > e) return;
 
    if(l <= s && e <= r) {
        propagate(i, val, s, e);
        return;
    }
 
    int mid = s + (e-s)/2;
    rangeUpdate(2*i, l, r, s, mid, val);
    rangeUpdate(2*i+1, l, r, mid+1, e, val);

    tree[i].zero = tree[2*i].zero + tree[2*i+1].zero;
    tree[i].one = tree[2*i].one + tree[2*i+1].one;
    tree[i].two = tree[2*i].two + tree[2*i+1].two;
}
 
node rangeQuery(int i, int l, int r, int s, int e) {
    if(delta[i] > 0) {
        propagate(i, delta[i], s, e);
    }
    
    if(r < s || l > e) {
        return {0, 0, 0};
    }
 
    if(l <= s && e <= r) {
        return tree[i];
    }
 
    int mid = s + (e-s)/2;
    node left = rangeQuery(2*i, l, r, s, mid);
    node right = rangeQuery(2*i+1, l, r, mid+1, e);

    node res;
    res.zero = left.zero + right.zero;
    res.one = left.one + right.one;
    res.two = left.two + right.two;
    return res;
}
 
int main() {
    int n, q;
    scanf("%d%d", &n, &q);
    
    build(1, 0, n-1);

    for (int i = 0; i < q; i++) {
        int tp;
        scanf("%d", &tp);

        int a, b;
        scanf("%d%d", &a, &b);

        if (tp == 0) {
            rangeUpdate(1, a, b, 0, n-1, 1);
        } else {
            printf("%d\n", rangeQuery(1, a, b, 0, n-1).zero);
        }
    }
    
    return 0;
} 