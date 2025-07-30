class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int maxVal = *max_element(nums.begin(), nums.end());
        int maxLen = 0, curLen = 0;

        for (int num : nums) {
            if (num == maxVal) {
                curLen++;
                maxLen = max(maxLen, curLen);
            } else {
                curLen = 0;
            }
        }

        return maxLen;
    }
};
