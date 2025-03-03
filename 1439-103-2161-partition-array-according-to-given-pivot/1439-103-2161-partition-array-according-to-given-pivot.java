class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        List<Integer> lls=new ArrayList<>();
        List<Integer> llg=new ArrayList<>();
        List<Integer> lle=new ArrayList<>();
        for(int i : nums)
        {
            if(i<pivot)lls.add(i);
            else if(i>pivot)llg.add(i);
            else lle.add(i);
        }
        int res[]=new int[n];
        int s=0,g=0,e=0;
        for(int i=0;i<n;i++)
        {
            if(s<lls.size())
            {
                res[i]=lls.get(s);
                s++;
            }
            else if(e<lle.size())
            {
                res[i]=lle.get(e);
                e++;
            }
            else{
                res[i]=llg.get(g);
                g++;
            }
        }
        return res;
    }
}