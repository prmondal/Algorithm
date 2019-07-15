#include <bits/stdc++.h>
using namespace std;

//cin/cout gives TLE
const int MAX_SIZE = 100000;
int BIT[MAX_SIZE+1];

int sum(int idx) {
    int res = 0;

    while(idx > 0) {
        res += BIT[idx];
        idx -= (idx & -idx);
    }

    return res;
}

void update(int idx, int val) {
    while(idx <= MAX_SIZE) {
        BIT[idx] += val;
        idx += (idx & -idx);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    
    int t;
    scanf("%d", &t);

    int m = 0;

    while(m < t) {
        memset(BIT, 0, sizeof(BIT));
        printf("Case %d:\n", m+1);
        
        int n, q;
        scanf("%d", &n);
        scanf("%d", &q);

        for(int i = 0; i < n; i++) {
            int a;
            scanf("%d", &a);
            update(i+1, a);
        }

        for(int i = 0; i < q; i++) {
            int b;
            scanf("%d", &b);

            if(b == 1) {
                int j;
                scanf("%d", &j);
                int r = sum(j + 1) - sum(j);
                printf("%d\n", r);
                update(j + 1, -r);
            } else if(b == 2) {
                int j, v;
                scanf("%d", &j);
                scanf("%d", &v);
                update(j + 1, v);
            } else {
                int j, k;
                scanf("%d", &j);
                scanf("%d", &k);
                printf("%d\n", sum(k + 1) - sum(j));
            }
        }

        m++;
    }
}