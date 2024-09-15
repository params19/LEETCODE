class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int arr[]=new int[2];
        Set<Integer> set=new HashSet<>();
        int k=0;
        for(int i : nums)
        {
            if(!set.contains(i))
                set.add(i);
            else
            {
                arr[k]=i;
                k++;
            }
        }
        return arr;
    }
}