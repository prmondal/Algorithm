#pragma GCC optimize("Ofast")

#include <bits/stdc++.h>
using namespace std;

#define endl "\n"
#define fastio ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL)
#define ll long long int
#define f(i,j,n) for(int i=j;i<n;i++)
#define rep(i,n) f(i,0,n)
#define repr(i,n) for(int i=n-1;i>=0;i--)
#define pb push_back
#define mp make_pair
#define ss second
#define ff first
#define vi vector<int>
#define vl vector<ll>
#define pii pair<int,int>
#define pll pair<ll,ll>
#define vii vector<pii>
#define vll vector<pll>
#define all(a) a.begin(),a.end()
#define sz(a) a.size()
#define bit(x,i) (x&(1<<i))
#define uniq(v) v.erase(v.unique(all(v)), v.end())
#define umapi unordered_map<int,int>
#define mapi map<int,int>
#define useti unordered_set<int>
#define seti set<int>
#define pqmin priority_queue<int>
#define pqmax priority_queue<int,vi,greater<int>>
#define coutp(i) cout << fixed << setprecision(i)
#define debug(x) cerr << "[ " << #x << " - " << x << " ]" << "\n"

#define TEST

// Use mt19937_64 for 64 bit random number
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
#define uid(l, r) uniform_int_distribution<int>(l, r)(rng)
#define shuf(v) shuffle(all(v), rng);

const int INF = 0x3f3f3f3f;
const ll INFL = 1LL << 61;
const double PI  = acos(-1);
const double EPS = 1e-9;

const int nax = 1e5+7;
const int TREE_SIZE = 2*(int)pow(2,ceil(log2(nax))) - 1;
ll tree[TREE_SIZE];
ll delta[TREE_SIZE];

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

void solve() {
    memset(tree, 0, sizeof(tree));
    memset(delta, 0, sizeof(delta));
    
    int n,q;
    cin >> n >> q;
    
    while(q--) {
        int type;
        cin >> type;

        if (type==0) {
            int l,r,v;
            cin >> l >> r >> v;
            rangeUpdate(1,l,r,1,n,v);
        } else {
            int l,r;
            cin >> l >> r;
            cout << rangeQuery(1,l,r,1,n) << "\n";
        }
    }
}

int main() {
    fastio;
#ifdef TEST
    int t;
    cin>>t;

    while(t--) {
        solve();
    }
#else
    solve();    
#endif    
}