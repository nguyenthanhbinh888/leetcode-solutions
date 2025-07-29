class Solution {
public:
    vector<int> smallestSubarrays(vector<int>& nums) {
        int n = nums.size();
        vector<int> res(n, 1);
        vector<int> lastSeen(32, -1);  // chỉ số cuối cùng mà bit i xuất hiện

        for (int i = n - 1; i >= 0; --i) {
            // Cập nhật vị trí bit đang bật ở nums[i]
            for (int b = 0; b < 32; ++b) {
                if ((nums[i] >> b) & 1) {
                    lastSeen[b] = i;
                }
            }

            int furthest = i;
            for (int b = 0; b < 32; ++b) {
                if (lastSeen[b] != -1) {
                    furthest = max(furthest, lastSeen[b]);
                }
            }

            res[i] = furthest - i + 1;
        }

        return res;
    }
};
