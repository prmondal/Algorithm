#include <bits/stdc++.h>
using namespace std;
 
const int MAX_SIZE = 1e4+7;
const int MAX_VAL = 1e6+7;
 
int *tree = new int[4*MAX_SIZE];
int *delta = new int[4*MAX_SIZE];
int *a = new int[MAX_SIZE];
 
bool primes[MAX_VAL];
 
void sieve() {
    for (int i = 0; i < MAX_VAL; i++) primes[i] = 1;
    
    for (int i = 2; i < MAX_VAL; i++) {
        for (int j = 2*i; j < MAX_VAL; j += i) {
            primes[j] = 0;
        }
    }
} 
 
void propagate(int i, int val, int s, int e) {
    tree[i] = (e-s+1) * primes[val];
        
    if (s != e) {
        delta[2*i] = val;
        delta[2*i+1] = val;
    }
 
    delta[i] = 0;
}   
 
void build(int i, int s, int e) {
    if(s == e) {
        tree[i] = primes[a[s]];
        return;
    }
 
    int mid = s + (e-s)/2;
 
    build(2*i, s, mid);
    build(2*i+1, mid+1, e);
    
    tree[i] = tree[2*i] + tree[2*i+1];
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
 
    tree[i] = tree[2*i] + tree[2*i+1];
}
 
int rangeQuery(int i, int l, int r, int s, int e) {
    if(delta[i] > 0) {
        propagate(i, delta[i], s, e);
    }
    
    if(r < s || l > e) {
        return 0;
    }
 
    if(l <= s && e <= r) {
        return tree[i];
    }
 
    int mid = s + (e-s)/2;
    return rangeQuery(2*i, l, r, s, mid) + rangeQuery(2*i+1, l, r, mid+1, e);
}
 
int main() {
    sieve();
 
    int t;
    scanf("%d", &t);
 
    for (int c = 1; c <= t; c++) {
        for (int k = 0; k < 4*MAX_SIZE; k++) {
            tree[k] = 0;
            delta[k] = 0;
        }
 
        printf("Case %d:\n", c);
 
        int n, q;
        scanf("%d%d", &n, &q);
 
        for (int i = 0; i < n; i++) {
            scanf("%d", &a[i]);
        }
 
        build(1, 0, n-1);
        
        for (int j = 0; j < q; j++) {
            int type;
            scanf("%d", &type);
            
            if (type == 0) {
                int l, r, v;
                scanf("%d%d%d", &l, &r, &v);
                rangeUpdate(1, l-1, r-1, 0, n-1, v);
            } else {
                int l, r;
                scanf("%d%d", &l, &r);
                printf("%d\n", rangeQuery(1, l-1, r-1, 0, n-1));
            }
        }
    }
    
    return 0;
}   