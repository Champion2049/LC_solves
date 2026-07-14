class Solution {
    private static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {

        int[][] cur = new int[201][201];
        int[][] nxt = new int[201][201];

        cur[0][0] = 1;

        for (int x : nums) {

            for (int i = 0; i <= 200; i++) {
                Arrays.fill(nxt[i], 0);
            }

            for (int g1 = 0; g1 <= 200; g1++) {
                for (int g2 = 0; g2 <= 200; g2++) {

                    if (cur[g1][g2] == 0) continue;

                    long ways = cur[g1][g2];

                    // Ignore
                    nxt[g1][g2] = (int) ((nxt[g1][g2] + ways) % MOD);

                    // Put in seq1
                    int ng1 = (g1 == 0) ? x : gcd(g1, x);
                    nxt[ng1][g2] = (int) ((nxt[ng1][g2] + ways) % MOD);

                    // Put in seq2
                    int ng2 = (g2 == 0) ? x : gcd(g2, x);
                    nxt[g1][ng2] = (int) ((nxt[g1][ng2] + ways) % MOD);
                }
            }

            int[][] temp = cur;
            cur = nxt;
            nxt = temp;
        }

        long ans = 0;
        for (int g = 1; g <= 200; g++) {
            ans = (ans + cur[g][g]) % MOD;
        }

        return (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
