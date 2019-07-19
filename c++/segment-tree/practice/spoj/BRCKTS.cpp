#include <bits/stdc++.h>
using namespace std;
 
const int MAX_SIZE = 30007;

typedef struct {
    int open = 0;
    int close = 0;
} node;

node *tree = new node[4*MAX_SIZE];
char a[MAX_SIZE];

void build(int i, int s, int e) {
    if(s == e) {
        if(a[s] == '(') {
            tree[i].open = 1;
        } else {
            tree[i].close = 1;
        }

        return;
    }

    int mid = s + (e-s)/2;

    build(2*i, s, mid);
    build(2*i+1, mid+1, e);
    
    tree[i].open = tree[2*i].open + tree[2*i+1].open - min(tree[2*i].open, tree[2*i+1].close);
    tree[i].close = tree[2*i].close + tree[2*i+1].close - min(tree[2*i].open, tree[2*i+1].close);
}

void pointUpdate(int i, int p, int s, int e) {
    if (p < s || p > e) return;
    
    if(s == e) {
        if (a[s] == '(') {
            a[s] = ')';
            tree[i].close = 1;
            tree[i].open = 0;
        } else {
            a[s] = '(';
            tree[i].open = 1;
            tree[i].close = 0;
        }

        return;
    }

    int mid = s + (e-s)/2;

    if (p <= mid) {
        pointUpdate(2*i, p, s, mid);
    } else {
        pointUpdate(2*i+1, p, mid + 1, e);
    }

    tree[i].open = tree[2*i].open + tree[2*i+1].open - min(tree[2*i].open, tree[2*i+1].close);
    tree[i].close = tree[2*i].close + tree[2*i+1].close - min(tree[2*i].open, tree[2*i+1].close);
}
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int j = 1;

    while(j <= 10) {
        printf("Test %d:\n", j);
        j++;

        int n;
        scanf("%d", &n);
        scanf("%s", a);
        
        for(int i = 0; i < 4*MAX_SIZE; i++) {
            node n;
            tree[i] = n;
        }
        
        build(1, 0, n-1);

        int m;
        scanf("%d", &m);

        for (int i = 0; i < m; i++) {
            int k;
            scanf("%d", &k);

            if (k > 0) {
                pointUpdate(1, k-1, 0, n-1);
            } else {
                if (tree[1].open == 0 && tree[1].close == 0) {
                    printf("%s\n", "YES");
                } else 
                    printf("%s\n", "NO");
            }
        }
    }
} 