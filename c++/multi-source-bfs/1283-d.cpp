// https://codeforces.com/problemset/problem/1283/D

#pragma GCC optimize("Ofast")

#include <bits/stdc++.h>
using namespace std;

#define endl "\n"
#define fastio ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL)
#define ll long long int
#define f(i,j,n) for(int i=j;i<=n;i++)
#define rep(i,n) f(i,0,n-1)
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

//#define TEST

// Use mt19937_64 for 64 bit random number
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
#define uid(l, r) uniform_int_distribution<int>(l, r)(rng)
#define shuf(v) shuffle(all(v), rng);

const int INF = 0x3f3f3f3f;
const ll INFL = 1LL << 61;
const double PI  = acos(-1);
const double EPS = 1e-9;

void solve() {
    int n,m;
    cin >> n >> m;

    queue<int> q;
    mapi distMap;
    mapi visited;

    rep(i,n) {
        int x;
        cin >> x;
        q.push(x);
        distMap[x] = 0;
        visited[x] = 1;
    }
    
    while(distMap.size() < m + n) {
        auto pos = q.front();
        q.pop();

        if (visited.find(pos + 1) == visited.end()) {
            q.push(pos + 1);
            distMap[pos + 1] = distMap[pos] + 1;
            visited[pos + 1] = 1;
        }

        if (distMap.size() == m + n)
            break;

        if (visited.find(pos - 1) == visited.end()) {
            q.push(pos - 1);
            distMap[pos - 1] = distMap[pos] + 1;
            visited[pos - 1] = 1;
        }
    }

    ll ans = 0;
    for (const auto& e: distMap) {
        ans += e.second;
    }

    cout << ans << endl;

    for (const auto& e: distMap) {
        if (e.second == 0) continue;
        cout << e.first << " ";
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