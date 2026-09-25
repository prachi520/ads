class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), ans);
        return ans;
    }

    void backtrack(int n, int k, int start,
                   List<Integer> list, List<List<Integer>> ans) {

        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);

            backtrack(n, k, i + 1, list, ans);

            list.remove(list.size() - 1);
        }
    }
}