class Solution {
     public static int lowerBound(ArrayList<Integer> list, int key) {
        int left = 0;
        int right = list.size()-1;
        int ans=list.size()-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = list.get(mid);

            if (midValue >= key) {
               ans=mid;
               right=mid-1;
            } else {
               left=mid+1;
            }
        }
        return list.get(ans);
    }
    public int minimumDifference(int[] nums) 
    {
        HashMap<Integer,ArrayList<Integer>> one=new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> two=new HashMap<>();
        int n=nums.length/2;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        for(int i=0;i<(1<<n);i++){
            int s1=0;
            int s2=0;
            int l1=0;
            int l2=0;
            for(int j=0;j<n;j++){
                if((i&(1<<j))>=1){
                s1+=nums[j];
                s2+=nums[j+n];
                l1++;
                l2++;
                }
            }
           ArrayList<Integer> fi= one.getOrDefault(l1,new ArrayList<>());
           ArrayList<Integer> se= two.getOrDefault(l2,new ArrayList<>());
           fi.add(s1);
           se.add(s2);
           one.put(l1,fi);
           two.put(l2,se);
         
        }
        for(ArrayList<Integer> e:two.values()){
            Collections.sort(e);
        }
     int ans=Integer.MAX_VALUE;
        for(Integer e:one.keySet()){
             ArrayList<Integer> nfi=one.get(e);
             ArrayList<Integer> nse=two.get(n-e);
             for(Integer m:nfi){
             int lb=lowerBound(nse,(sum-2*m)/2);
             ans=Math.min(ans,Math.abs(sum-2*(m+lb)));
             }
        }
        return ans;
    }
}