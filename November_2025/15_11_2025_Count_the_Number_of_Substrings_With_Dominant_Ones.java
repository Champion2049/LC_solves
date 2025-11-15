class Solution {
    public int numberOfSubstrings(String s) {
        int res = 0, n = s.length(), m = 1;
        char[] arr = s.toCharArray();
        int[] zeroIndexes = new int[n + 1];
        zeroIndexes[0] = -1;
        int totalOnes = 0, nextZeroIndex = 1;
        for (int right = 0; right < n; right++) {
            if (arr[right] == '0') {
                zeroIndexes[nextZeroIndex++] = right;
            } else {
                res += right - zeroIndexes[nextZeroIndex - 1];
                totalOnes++;
            }
            for (int z = nextZeroIndex - 1; z > 0 && (nextZeroIndex - z) * (nextZeroIndex - z) <= totalOnes; z--) {
                int zeroCount = nextZeroIndex - z;
                int oneCount = right - zeroIndexes[z] + 1 - zeroCount;
                res += Math.max(zeroIndexes[z] - zeroIndexes[z - 1] - Math.max(zeroCount * zeroCount - oneCount, 0), 0);
            }
        }
        return res;
    }
}
