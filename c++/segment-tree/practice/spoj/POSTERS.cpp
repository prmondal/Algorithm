#include <bits/stdc++.h>
using namespace std;
 
const int MAX_SIZE = 100000;
 
void rangeUpdate(int i, int l, int r, int s, int e, int v, int *tree, int *delta) {
    if(delta[i] > 0) {
        tree[i] = delta[i];
        
        if (s != e) {
            delta[2*i] = delta[i];
            delta[2*i+1] = delta[i];
        }
        delta[i] = 0;
    }
    
    if(r < s || l > e) return;
 
    if(l <= s && e <= r) {
        tree[i] = v;
        
        delta[2*i] = v;
        delta[2*i+1] = v;
        delta[i] = 0;
        
        return;
    }
 
    int mid = s + (e-s)/2;
    rangeUpdate(2*i, l, r, s, mid, v, tree, delta);
    rangeUpdate(2*i+1, l, r, mid+1, e, v, tree, delta);
 
    tree[i] = v;
}
 
int rangeQuery(int i, int l, int r, int s, int e, int *tree, int *delta) {
    if(delta[i] > 0) {
        tree[i] = delta[i];
        
        if (s != e) {
            delta[2*i] = delta[i];
            delta[2*i+1] = delta[i];
        }
        delta[i] = 0;
    }
    
    if(r < s || l > e) {
        return 0;
    }
 
    if(l <= s && e <= r) {
        return tree[i];
    }
 
    int mid = s + (e-s)/2;
    int lv = rangeQuery(2*i, l, r, s, mid, tree, delta);
    int rv = rangeQuery(2*i+1, l, r, mid+1, e, tree, delta);
 
    return max(lv, rv);
}
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
 
    int t;
    cin >> t;
    
    while(t--) {
        int n;
        cin >> n;
 
        int *tree = new int[4*MAX_SIZE+1];
        int *delta = new int[4*MAX_SIZE+1];
        memset(tree, 0, sizeof tree);
        memset(delta, 0, sizeof delta);
 
        vector<pair<int, int>> posters;
        map<int, int> m;
        
        for(int i = 0; i < n; i++) {
            int l, r;
            cin >> l >> r;
            
            m[l] = 1;
            m[r] = 1;
            
            posters.push_back(make_pair(l, r));
        }
        
        int c = 0;
        
        for (auto& e: m) {
            e.second = ++c;
        }
        
        for (int i = 0; i < n; i++) {
            rangeUpdate(1, m[posters[i].first], m[posters[i].second], 0, MAX_SIZE, i+1, tree, delta);
        }
 
        set<int> s;
 
        for(int i = 1; i < MAX_SIZE; i++) {
            s.insert(rangeQuery(1, i, i, 0, MAX_SIZE, tree, delta));
        }
        
        int k = s.size();
        if (s.find(0) != s.end()) k--;
        
        cout << k << endl;
    }
    
    return 0;
} 