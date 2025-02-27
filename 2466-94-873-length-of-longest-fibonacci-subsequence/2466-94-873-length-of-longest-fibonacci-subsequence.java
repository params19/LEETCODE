class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int count=0;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> x = new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            x.add(arr[i]);
        }
        for(int i=0;i<arr.length;i++)
        {
            int a=arr[i];
            for(int j=i+1;j<arr.length;j++)
            {
                int b=arr[j];
                count=count+2;
                while(x.contains(a+b))
                {
                    count++;
                    int temp=b;
                    b=a+b;
                    a=temp;
                }
                if(count>max)
                {
                    max=count;
                }
                count=0;
                a=arr[i];                
            }
        }
        return max==2?0:max;
    }
}