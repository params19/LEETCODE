import java.util.*;
public class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long freq[]=new long[n];
        int n1=roads.length;
        int m=roads[0].length;
        Arrays.fill(freq,0);
        for(int i=0;i<n1;i++)
        {
            for(int j=0;j<m;j++)
            {
                freq[roads[i][j]]=freq[roads[i][j]]+1;
            }
        }
        long ans=0;
        Arrays.sort(freq);
        for(int i=0;i<n;i++)
        {
            ans+=(freq[i]*(i+1));
        }
        return ans;
    }
} 
