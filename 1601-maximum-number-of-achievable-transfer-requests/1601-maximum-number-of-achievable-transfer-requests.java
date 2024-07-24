import java.util.*;
class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int res=backtrack(0,requests,new int[n],0);
        return res;
    }
    private int backtrack(int index, int[][] requests, int[] count, int res)
    {
        if(index==requests.length)
        {
            for(int i=0;i<count.length;i++)
            {
                if(count[i]!=0)
                {
                    return 0;
                }
            }
            return res;
        }
        count[requests[index][0]]--;
        count[requests[index][1]]++;
        int temp=backtrack(index+1,requests,count,res+1);
        count[requests[index][0]]++;
        count[requests[index][1]]--;
        int temp1=backtrack(index+1,requests,count,res);
        return Math.max(temp,temp1);
    }
}