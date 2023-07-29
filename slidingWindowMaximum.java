class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       Stack<Integer> st=new Stack<>();
       Stack<Integer> index=new Stack<>();

       int n=nums.length; 
       int res[]=new int[n];
       st.push(nums[n-1]) ;
       index.push(n-1);
       res[n-1]=n;

       for(int i=n-2;i>=0;i--)
       {
           if(nums[i]<st.peek())
           {
               st.push(nums[i]);
               res[i]=index.peek();
               index.push(i);
           }
           else
           {
               while(st.size()>0 && nums[i]>=st.peek())
               {
                   st.pop();
                   index.pop();
               }
               if(!index.isEmpty())
               res[i]=index.peek();
               else
               res[i]=n;
               st.push(nums[i]);
               index.push(i);
           }
       }

        int arr[]=new int[nums.length-k+1];
        int i=0;
        int left=-1;
        int right=k-2;
        int flag=0;
        while(right<nums.length-1)
        {
            left++;
            right++;   
            for(i=left;i<=right;i++)
            {
                if(flag>=left && i<=flag)
                i=flag;
                

                if(res[i]<=right)
                {
                    
                }
                else
                {
                    arr[left]=nums[i];
                    flag=i;
                    break;
                }
                
                // if(i==right)
                // {
                //     arr[left]=nums[i];
                //     break;
                // }

            } 
        }
        return arr;

    }
}





















 // int max=Integer.MIN_VALUE;
        // int arr[]=new int[nums.length-k+1];
        // int i=0;
        // int left=-1;
        // int right=k-2;
        // while(right<nums.length-1)
        // {
        //     left++;
        //     right++;   
        //     for(i=left;i<=right;i++)
        //     {
        //         if(nums[i]>max)
        //         {
        //             max=nums[i];
        //         }
        //     } 
        //     arr[left]=max;
        //     max=Integer.MIN_VALUE;
        // }
        // return arr;
