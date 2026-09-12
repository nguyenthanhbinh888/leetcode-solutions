import java.util.*;

class Solution {

    static class Interval {
        int start;
        int end;
        int weight;
        int index;

        Interval(int start, int end, int weight, int index) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.index = index;
        }
    }

    // Mảng interval sau khi sort
    private Interval[] intervals;

    // next[i] = interval tiếp theo không overlap
    private int[] next;

    // dp[i][k]
    private long[][] dp;

    public int[] maximumWeight(List<List<Integer>> input) {

        int n = input.size();

        intervals = new Interval[n];

        // =========================
        // 1. Chuyển List sang Array
        // =========================

        for (int i = 0; i < n; i++) {

            int start = input.get(i).get(0);
            int end = input.get(i).get(1);
            int weight = input.get(i).get(2);

            intervals[i] =
                    new Interval(start, end, weight, i);
        }

        // =========================
        // 2. Sort theo start
        // =========================

        Arrays.sort(intervals, (a, b) -> {

            if (a.start != b.start) {
                return Integer.compare(a.start, b.start);
            }

            if (a.end != b.end) {
                return Integer.compare(a.end, b.end);
            }

            return Integer.compare(a.weight, b.weight);
        });

        // =========================
        // 3. Tìm next[i]
        // =========================

        next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = findNext(i);
        }

        // =========================
        // 4. DP
        // =========================

        dp = new long[n + 1][5];

        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 4; k++) {

                // Không chọn interval i
                long skip = dp[i + 1][k];

                // Chọn interval i
                long take = intervals[i].weight;

                if (k > 1) {
                    take += dp[next[i]][k - 1];
                }

                dp[i][k] = Math.max(skip, take);
            }
        }

        // =========================
        // 5. Khôi phục đáp án
        // =========================

        List<Integer> answer = new ArrayList<>();

        int i = 0;
        int k = 4;

        while (i < n && k > 0) {

            long skip = dp[i + 1][k];

            long take = intervals[i].weight;

            if (k > 1) {
                take += dp[next[i]][k - 1];
            }

            if (take >= skip) {

                // Chọn interval này
                answer.add(intervals[i].index);

                // Nhảy đến interval tiếp theo
                i = next[i];

                k--;

            } else {

                // Bỏ qua interval này
                i++;
            }
        }

        // =========================
        // 6. Sort index tăng dần
        // =========================

        Collections.sort(answer);

        int[] result = new int[answer.size()];

        for (int j = 0; j < answer.size(); j++) {
            result[j] = answer.get(j);
        }

        return result;
    }

    // ==========================================
    // Binary Search
    //
    // Tìm interval đầu tiên có:
    //
    // intervals[j].start > intervals[i].end
    // ==========================================

    private int findNext(int i) {

        int target = intervals[i].end;

        int left = i + 1;
        int right = intervals.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (intervals[mid].start > target) {

                right = mid;

            } else {

                left = mid + 1;
            }
        }

        return left;
    }
}