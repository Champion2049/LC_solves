class Solution {
    public List<String> readBinaryWatch(int k) {
        if (k == 0) return Arrays.asList("0:00");
        if (k > 8) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        int q = (1 << k) - 1; 

        while (q < (1 << 10)) {
            String time = isValid(q);
            if (!time.isEmpty()) res.add(time);

            int r = q & -q;
            int n = q + r;
            q = (((n ^ q) >> 2) / r) | n;
        }

        return res;
    }


    String isValid(int q) {
        int hour = q >> 6;
        int min = q & 63;
        if (hour >= 12 || min >= 60) return "";
        //return String.format("%d:%02d", hour, min);
        return hour + ":" + (min < 10 ? "0" : "") + min;
    }
}
