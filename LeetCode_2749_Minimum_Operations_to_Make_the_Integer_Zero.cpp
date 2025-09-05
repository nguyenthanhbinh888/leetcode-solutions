class Solution {
public:
  int makeTheIntegerZero(long long num1, long long num2) {
    for (long long k = 0; k <= 60; ++k) {
      long long target = num1 - k * num2;
      if (target >= 0 && __builtin_popcountll(target) <= k && k <= target)
        return (int)k;
    }
    return -1;
  }
};
