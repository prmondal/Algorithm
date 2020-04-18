#include <bits/stdc++.h>
using namespace std;
 
const int MAX_SIZE = 2e5; 
int parent[MAX_SIZE], size[MAX_SIZE];
 
void makeSet(int v) {
    parent[v] = v;
    size[v] = 1;
}
 
int findSet(int v) {
    if (v == parent[v]) return v;
    return parent[v] = findSet(parent[v]);
}
 
void mergeSet(int p, int q) {
    int a = findSet(p);
    int b = findSet(q);
 
    if (a != b) {
        if (size[a] <= size[b]) {
            parent[a] = b;
            size[b] += size[a];
        } else {
            parent[b] = a;
            size[a] += size[b];
        }
    }
}
 
int main() {
    for (int i = 0; i < MAX_SIZE; i++) {
        parent[i] = -1;
        size[i] = 0;
    }
 
    int n, q;
    scanf("%d%d", &n, &q);

    set<int> s;
 
    for (int i = 1; i <= n; i++) {
        makeSet(i);
        s.insert(i);
    }
 
    for (int i = 1; i <= q; i++) {
        int tp, x, y;
        scanf("%d%d%d", &tp, &x, &y);
 
        if (tp == 1) {
            mergeSet(x, y);
        } else if (tp == 2) {
            auto it = s.lower_bound(x);

            while(it != s.end()) {
                if (*it >= y) break;
                mergeSet(*it, (*it)+1);
                s.erase(it++);
            }
        } else {
            printf("%s\n", (findSet(x) == findSet(y) ? "YES" : "NO"));
        }
    }
}