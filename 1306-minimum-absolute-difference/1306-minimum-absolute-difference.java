class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<n;i++)
        {
            int diff=Math.abs(arr[i]-arr[i-1]);
            min=Math.min(min, diff);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<n;i++)
        {
            int diff=Math.abs(arr[i]-arr[i-1]);
            List<Integer> ll=new ArrayList<>();
            if(diff==min)
            { 
                ll.add(arr[i-1]);
                ll.add(arr[i]);
                ans.add(ll);
            }
        }
        return ans;
    }
}