
class Solution {
    int[] parent;

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];

        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int pu = find(u);
            int pv = find(v);

            if (pu == pv) {
                return edge;
            }

            parent[pu] = pv;
        }

        return new int[0];
    }
}
