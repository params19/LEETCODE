class Solution {
    public int countMaxOrSubsets(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int n=nums.length;
        for(int i : nums)
            set.add(i);
        if(set.size()==1)return (int)Math.pow(2,n)-1;
        int ans=generate(nums);
        return ans;
    }
    
    public static int generate(int[] arr) 
    {
        List<List<Integer>> subsets = new ArrayList<>();
        int n = arr.length;
        int total= 1 << n;
        int max=0;
        int cnt=0;
            for(int i : arr)
                max|=i;
        for (int i = 0; i < total; i++)
        {
            List<Integer> current = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    current.add(arr[j]);
                }
            }
            if(check(current)==max)
                cnt++;
        }
        return cnt;
    }
    private static int check(List<Integer> ll)
    {
        int or=0;
        for(int i=0;i<ll.size();i++)
        {
            or|=ll.get(i);
        }
        return or;
    }
}