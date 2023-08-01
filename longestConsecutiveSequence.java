class Solution {
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> mp = new HashSet<>();
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                mp.add(nums[i]);
            }
            int k = 0;
            while (k < nums.length) {
                int j=1;
                int count = 1;
                if (!mp.contains(nums[k] - 1)) {
                    while (mp.contains(nums[k] + j)) {
                        count++;
                        j++;
                    }
                    if (count > max) {
                        max = count;
                    }
                }
                k++;
            }
            return max;
        }
    }
