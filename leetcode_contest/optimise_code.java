package leetcode_contest;

import java.util.*;
class optimise_code
{
	public static void main (String[] args) throws java.lang.Exception
	{
       Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            solve(sc);
        }
        sc.close();
	}
    public static void solve(Scanner sc)
    {
        int n=sc.nextInt();
        long m=sc.nextInt();
        long a[]=new long[n];
        long b[]=new long[n];

        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextLong();
            b[i]=sc.nextLong();
        }

        Map<Long, Long> cand = new HashMap<>();
        //Map to store the remainder of a[i] with m
        for (int i = 0; i < n; i++) 
        {
            long rem=(int)(a[i]%m);
            cand.put(rem, cand.getOrDefault(rem, 0L) + 1);
        }

        long cnt=0;
        //Iterating over b[i] and checking if the remainder of m-b[i] is present in the map
        //If present, increment the count by the value of the remainder
        //This is done to check if a[i]+b[i] is divisible by m
        //If a[i]%m + b[i]%m = m, then a[i]+b[i] is divisible by m
        //So, we need to check if b[i]%m = m-a[i]%m
        //If yes, then a[i]+b[i] is divisible by m
        for (int j=0;j<n;j++) 
        {
            long req =(int)((m-b[j]%m)%m);
            cnt += cand.getOrDefault(req, 0L);
        }
        System.out.println(cnt);
    }
}
