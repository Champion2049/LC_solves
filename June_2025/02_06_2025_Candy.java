class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        // Give each child at least one candy
        Arrays.fill(candies, 1);
        
        // Left to right: if right child has higher rating, give more candy
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // Right to left: if left child has higher rating, ensure it has more candy
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        
        // Sum up all candies
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }
        
        return total;
    }
}
