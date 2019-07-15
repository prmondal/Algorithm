#include <bits/stdc++.h>
using namespace std;
 
const int MAX_SIZE = 200007;
int *tree = new int[4*MAX_SIZE+1];
int *delta = new int[4*MAX_SIZE+1];
 
void propagate(int i, int val, int s, int e) {
    tree[i] += val;
        
    if (s != e) {
        delta[2*i] += val;
        delta[2*i+1] += val;
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
 
    tree[i] = max(tree[2*i], tree[2*i+1]);
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
    int lv = rangeQuery(2*i, l, r, s, mid);
    int rv = rangeQuery(2*i+1, l, r, mid+1, e);
 
    return max(lv, rv);
}
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    
    memset(tree, 0, sizeof(tree));
    memset(delta, 0, sizeof(delta));
 
    vector<pair<int, int>> animals;
    map<int, int> m;
    
    int n;
    cin >> n;
 
    for(int i = 0; i < n; i++) {
        int l, r;
        cin >> l >> r;
 
        m[l] = 0;
        m[r] = 0;
 
        animals.push_back(make_pair(l, r));
    }
    
    int q;
    cin >> q;
    
    vector<pair<int, int>> queries;
    
    for(int i = 0; i < q; i++) {
        int l, r;
        cin >> l >> r;
        
        m[l] = 0;
        m[r] = 0;
        
        queries.push_back(make_pair(l, r));
    }
    
    int c = 0;
 
    for (auto& e: m) {
        e.second = ++c;
    }
 
    for (int i = 0; i < n; i++) {
        rangeUpdate(1, m[animals[i].first], m[animals[i].second], 0, MAX_SIZE, 1);
    }
    
    for (int i = 0; i < q; i++) {
        cout << rangeQuery(1, m[queries[i].first], m[queries[i].second], 0, MAX_SIZE) << endl;
    }
    
    return 0;
} 