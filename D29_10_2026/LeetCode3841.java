package D29_10_2026;


import java.util.*;

public class LeetCode3841 {

    static class Solution {
        private List<Integer>[] graph;
        private int[][] up;
        private int[] parent, depth, tin, tout;
        private int[] baseMask;
        private char[] chars;
        private int timer, log;
        private Fenwick fenwick;

        public List<Boolean> palindromePath(
                int n, int[][] edges, String s, String[] queries) {

            graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }

            log = 1;
            while ((1 << log) <= n) {
                log++;
            }

            up = new int[log][n];
            parent = new int[n];
            depth = new int[n];
            tin = new int[n];
            tout = new int[n];
            baseMask = new int[n];
            chars = s.toCharArray();

            buildTree(n);

            fenwick = new Fenwick(n);

            List<Boolean> answer = new ArrayList<>();

            for (String q : queries) {
                String[] parts = q.split(" ");

                if (parts[0].equals("update")) {
                    int u = Integer.parseInt(parts[1]);
                    char c = parts[2].charAt(0);

                    int delta = (1 << (chars[u] - 'a'))
                              ^ (1 << (c - 'a'));

                    if (delta != 0) {
                        fenwick.rangeXor(tin[u], tout[u], delta);
                        chars[u] = c;
                    }
                } else {
                    int u = Integer.parseInt(parts[1]);
                    int v = Integer.parseInt(parts[2]);

                    int lca = getLCA(u, v);

                    int mask = getPrefixMask(u)
                             ^ getPrefixMask(v)
                             ^ (1 << (chars[lca] - 'a'));

                    // At most one bit is set.
                    answer.add((mask & (mask - 1)) == 0);
                }
            }

            return answer;
        }

        private void buildTree(int n) {
            int[] stack = new int[n];
            int[] nextIndex = new int[n];
            int top = 0;

            Arrays.fill(parent, -2);

            parent[0] = -1;
            up[0][0] = 0;
            baseMask[0] = 1 << (chars[0] - 'a');
            tin[0] = ++timer;
            stack[top] = 0;

            while (top >= 0) {
                int u = stack[top];

                if (nextIndex[u] < graph[u].size()) {
                    int v = graph[u].get(nextIndex[u]++);

                    if (v == parent[u]) {
                        continue;
                    }

                    parent[v] = u;
                    depth[v] = depth[u] + 1;
                    up[0][v] = u;

                    for (int k = 1; k < log; k++) {
                        up[k][v] = up[k - 1][up[k - 1][v]];
                    }

                    baseMask[v] = baseMask[u]
                                ^ (1 << (chars[v] - 'a'));

                    tin[v] = ++timer;
                    stack[++top] = v;
                } else {
                    tout[u] = timer;
                    top--;
                }
            }
        }

        private int getPrefixMask(int u) {
            return baseMask[u] ^ fenwick.query(tin[u]);
        }

        private int getLCA(int u, int v) {
            if (depth[u] < depth[v]) {
                int temp = u;
                u = v;
                v = temp;
            }

            int diff = depth[u] - depth[v];

            for (int k = 0; k < log; k++) {
                if (((diff >> k) & 1) != 0) {
                    u = up[k][u];
                }
            }

            if (u == v) {
                return u;
            }

            for (int k = log - 1; k >= 0; k--) {
                if (up[k][u] != up[k][v]) {
                    u = up[k][u];
                    v = up[k][v];
                }
            }

            return parent[u];
        }

        static class Fenwick {
            private final int[] bit;
            private final int n;

            Fenwick(int n) {
                this.n = n;
                bit = new int[n + 2];
            }

            private void update(int i, int value) {
                while (i <= n) {
                    bit[i] ^= value;
                    i += i & -i;
                }
            }

            void rangeXor(int left, int right, int value) {
                update(left, value);
                update(right + 1, value);
            }

            int query(int i) {
                int result = 0;

                while (i > 0) {
                    result ^= bit[i];
                    i -= i & -i;
                }

                return result;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 3;
        int[][] edges = {
            {0, 1},
            {1, 2}
        };

        String s = "aac";

        String[] queries = {
            "query 0 2",
            "update 1 b",
            "query 0 2"
        };

        List<Boolean> result =
                solution.palindromePath(n, edges, s, queries);

        System.out.println(result);
    }
}
