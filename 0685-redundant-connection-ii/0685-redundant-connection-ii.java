
class Solution {
    int[] parent;

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parentNode = new int[n + 1];

        int[] candidate1 = null;
        int[] candidate2 = null;

        // Step 1: Check if a node has two parents
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (parentNode[v] == 0) {
                parentNode[v] = u;
            } else {
                candidate1 = new int[]{parentNode[v], v};
                candidate2 = edge;
                break;
            }
        }

        // Step 2: Union Find to detect cycle
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            if (edge == candidate2) {
                continue;
            }

            int u = edge[0];
            int v = edge[1];

            int pu = find(u);
            int pv = find(v);

            if (pu == pv) {
                if (candidate1 == null) {
                    return edge;
                }
                return candidate1;
            }

            parent[pu] = pv;
        }

        return candidate2;
    }
}
