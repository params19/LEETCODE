class Solution 
{
    public int minZeroArray(int[] nums, int[][] q) {
        int n = nums.length;
        int[] curr = Arrays.copyOf(nums, n);
        boolean res = Arrays.stream(curr).allMatch(x -> x == 0);
        if (res) return 0;
        
        int[] b = new int[n];
        int si = 0, ei = q.length;
        int ans = -1;
        boolean mid = false;
        
        while (si <= ei) 
        {
            int j=si+(ei-si)/2;
            if (check(j, q, curr, n)) {
                ans=j;
                ei=j-1;
            } else {
                si=j+1;
            }
            
            if (!mid &&j==q.length / 2) 
            {
                calculate(j, q, curr, b, n);
                mid = true;
            }
        }
        return ans!=-1?ans:-1;
    }
    
    public void calculate(int j, int[][] q, int[] curr, int[] b, int n)
    {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i=0;i<j;i++) 
        {
            int l =q[i][0];
            int r =q[i][1];
            int val =q[i][2];
            mp.put(l, mp.getOrDefault(l,0)+val);
            if (r+1<n) mp.put(r + 1, mp.getOrDefault(r+1,0)-val);
        }

        System.arraycopy(curr, 0, b, 0, n);
        int sum = 0;
        for (int i=0;i<n;i++)
        {
            sum+=mp.getOrDefault(i, 0);
            b[i]=Math.max(0, curr[i] - sum);
        }
    }
    
    public boolean check(int j, int[][] q, int[] curr, int n) 
    {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i=0;i<j;i++) {
            int l= q[i][0];
            int r= q[i][1];
            int val = q[i][2];
            mp.put(l, mp.getOrDefault(l, 0) + val);
            // if (r + 1 < n) mp.put(r, mp.getOrDefault(r + 1, 0) - val);
            if (r + 1 < n) mp.put(r + 1, mp.getOrDefault(r + 1, 0) - val);
        }
        int sum=0;
        for (int i=0;i<n;i++) 
        {
            sum+=mp.getOrDefault(i,0);
            if (sum<curr[i]) 
            {
                return false;
            }
        }
        return true;
    }
}
