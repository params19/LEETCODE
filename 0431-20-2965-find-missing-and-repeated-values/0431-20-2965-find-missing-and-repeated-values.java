class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        Map<Integer, Integer> mp=new HashMap<>();
        int res[]=new int[2];
        for(int i=1;i<=n*n;i++)
        {
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int val=grid[i][j];
                mp.put(val,mp.getOrDefault(val,0)+1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : mp.entrySet())
        {
            int key=entry.getKey();
            int val=entry.getValue();
            if(val==3)res[0]=key;
            else if(val==1)res[1]=key;
        }
        return res;
    }
}