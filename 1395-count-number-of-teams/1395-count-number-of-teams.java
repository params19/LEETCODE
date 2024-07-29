class Solution {
    public int numTeams(int[] rating) {
        int n=rating.length;
        // Arrays.sort(rating);
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                for(int k=j;k<n;k++)
                {
                    if(i<j&&j<k)
                    {
                        if((rating[i]<rating[j]&&rating[j]< rating[k]) ||(rating[i]>rating[j]&&rating[j]>rating[k]))
                        {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}