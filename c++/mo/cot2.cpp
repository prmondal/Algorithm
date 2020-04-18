//https://www.spoj.com/problems/COT2/

#include <bits/stdc++.h>
using namespace std;

const int MAXN = 1e5+7;
const int MAXM = 1e5+7;
const int MAXD = 20;

int n, m;
int a[MAXN], vis[MAXN];
int d[MAXN], anc[MAXN][MAXD];
int st[MAXN], et[MAXN], lookup[MAXN];
int freq[MAXN];

vector<int> adj[MAXN];

int epoch = 0;
int distinct = 0;
int BLOCK_SIZE;
int ans[MAXM];

struct Query {
    int l, r, id, lca;
    bool operator < (const struct Query& q) {
        if (l / BLOCK_SIZE != q.l / BLOCK_SIZE) return l < q.l;
        return r < q.r;
    }

} q[MAXM];

void dfs(int u, int p) {
    anc[u][0] = p;
    st[u] = ++epoch;
    lookup[st[u]] = u;

    for(int i = 1; i < MAXD; i++)
        anc[u][i] = anc[anc[u][i-1]][i-1];

    for(int v : adj[u]) {
        if(v == p)
            continue;

        d[v] = d[u] + 1;
        dfs(v, u);
    }

    et[u] = ++epoch;
    lookup[et[u]] = u;
}

int lca(int u, int v) {
    if(d[u] < d[v])
        swap(u, v);

    for(int i = MAXD - 1; ~i; i--)
        if(d[u] - d[v] >= (1<<i))
            u = anc[u][i];

    if(u == v)
        return u;

    for(int i = MAXD - 1; ~i; i--) {
        if(anc[u][i]^anc[v][i]) {
            u = anc[u][i];
            v = anc[v][i];
        }
    }

    return anc[u][0];
}

void toggle(int x) {
    int u = lookup[x];
    
    if (vis[u]) {
        freq[a[u]]--;

        if (freq[a[u]] == 0)
            distinct--;
    } else {
        if (freq[a[u]] == 0)
            distinct++;

        freq[a[u]]++;
    }

    vis[u] ^= 1;
}

void mo() {
    int currL = 1;
    int currR = 0;

    for (int i = 1; i <= m; i++) {
        while(currL < q[i].l) toggle(currL++);
        while(currR < q[i].r) toggle(++currR);
        while(currL > q[i].l) toggle(--currL);
        while(currR > q[i].r) toggle(currR--);

        if (q[i].lca != lookup[q[i].l]) toggle(st[q[i].lca]);
        ans[q[i].id] = distinct;
        if (q[i].lca != lookup[q[i].l]) toggle(st[q[i].lca]);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin>>n>>m;

    for (int i = 1; i <= n; i++) cin >> a[i];

    // coordinate compression
    unordered_map<int, int> cc;
    int val = 1;

    for (int i = 1; i <= n; i++) {
        if (cc.count(a[i]) == 0) {
            cc[a[i]] = val++;
        }

        a[i] = cc[a[i]];
    }

    for (int i = 1; i <= n-1; i++) {
        int u,v;
        cin>>u>>v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    anc[1][0] = 1;
    dfs(1, -1);

    BLOCK_SIZE = sqrt(epoch);

    for (int i = 1; i <= m; i++) {
        int u, v;
        cin>>u>>v;

        if (st[u] > st[v])
            swap(u, v);

        q[i].id = i;
        q[i].lca = lca(u, v);

        if (q[i].lca == u) {
            q[i].l = st[u];
            q[i].r = st[v];
        } else {
            q[i].l = et[u];
            q[i].r = st[v];
        }
    }

    sort(q+1, q+m+1);
    mo();

    for (int i = 1; i <= m; i++) {
        cout << ans[i] << "\n";
    }
}