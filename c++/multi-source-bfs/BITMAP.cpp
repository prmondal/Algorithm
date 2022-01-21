// https://www.spoj.com/problems/BITMAP/

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

#define TEST

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

    vector<string> g;
    rep(i,n) {
        string s;
        cin >> s;
        g.pb(s);
    }
    
    vector<vector<bool>> visited(n, vector<bool>(m, false));
    vector<vector<int>> dists(n, vector<int>(m, INF));
    queue<pair<int,int>> q;

    rep(i,n) {
        rep(j,m) {
            if (g[i][j] == '1') {
                dists[i][j] = 0;
                visited[i][j] = true;
                q.push({i,j});
            }
        }
    }

    int dx[4] = {1,0,-1,0};
    int dy[4] = {0,1,0,-1};

    while (!q.empty()) {
        auto f = q.front();
        q.pop();
        
        int i = f.first;
        int j = f.second;
            
        visited[i][j] = true;

        rep(k,4) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && x < n && y >= 0 && y < m && dists[x][y] == INF && !visited[x][y]) {
                dists[x][y] = dists[i][j] + 1;
                q.push({x,y});
            }
        }
    }

    rep(i,n) {
        rep(j,m) {
            if (j==m-1)
                cout << dists[i][j] << endl;
            else
                cout << dists[i][j] << " ";
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