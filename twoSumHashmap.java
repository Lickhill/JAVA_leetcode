class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[]=new int[2];
            Map<Integer,Integer> mp=new HashMap<>();//<number in the array, index of that number>
            for(int i=0;i<nums.length;i++)
            {
                if(mp.containsKey(target-nums[i]))
                {
                    ans[0]=i;
                    ans[1]=mp.get(target-nums[i]);
                    return ans;
                }
                else{
                    mp.put(nums[i],i);
                }   
            }
            return ans;
    }
}
        
