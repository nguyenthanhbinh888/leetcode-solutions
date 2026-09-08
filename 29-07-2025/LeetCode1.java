class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> map;

        for (int i = 0; i < nums.size(); ++i) {
            int complement = target - nums[i];

            // Nếu tìm thấy phần bù trong map, trả về kết quả
            if (map.find(complement) != map.end()) {
                return {map[complement], i};
            }

            // Nếu chưa thấy, lưu giá trị hiện tại vào map
            map[nums[i]] = i;
        }

        return {}; // Trường hợp không tìm thấy, nhưng theo đề là luôn có đáp án
    }
};