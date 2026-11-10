class Solution {
    private int n;
    private int[] costs, memo;

    public int climbStairs(int n, int[] costs) {
        this.n = n;
        this.costs = new int[n + 1];  
        System.arraycopy(costs, 0, this.costs, 1, n);
        memo = new int[n + 1];  
        return climb(0);
    }

    private int climb(int i) {  
        if (i > n) return Integer.MAX_VALUE / 2;  
        if (i == n) return costs[n];  
        if (memo[i] == 0)
            memo[i] = costs[i] + Math.min(climb(i + 1) + 1, Math.min(climb(i + 2) + 4, climb(i + 3) + 9));
        return memo[i];
    }
}
