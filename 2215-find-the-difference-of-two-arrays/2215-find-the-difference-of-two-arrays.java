class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1=new HashSet<>();
        Set<Integer> s2=new HashSet<>();
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ll1=new ArrayList<>();
        List<Integer> ll2=new ArrayList<>();
        int n1=nums1.length;
        int n2=nums2.length;
        for(int i : nums1)
        {
            s1.add(i);
        }
        for(int i : nums2)
        {
            s2.add(i);
        }
        for(int i : s1)
        {
            if(!s2.contains(i))
            {
                ll1.add(i);
            }
        }
        res.add(ll1);
        for(int i : s2)
        {
            if(!s1.contains(i))
            {
                ll2.add(i);
            }
        }
        res.add(ll2);
        return res;

    }
}