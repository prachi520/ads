class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        solve(0, n, cols, diag1, diag2);

        return count;
    }

    void solve(int row, int n, boolean[] cols,
               boolean[] diag1, boolean[] diag2) {

        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {

            
            if (cols[col] || diag1[row - col + n - 1] || diag2[row + col]) {
                continue;
            }

           
            cols[col] = true;
            diag1[row - col + n - 1] = true;
            diag2[row + col] = true;

            
            solve(row + 1, n, cols, diag1, diag2);

            cols[col] = false;
            diag1[row - col + n - 1] = false;
            diag2[row + col] = false;
        }
    }
}