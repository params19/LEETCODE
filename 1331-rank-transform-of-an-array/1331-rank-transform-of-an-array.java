class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int copy[] = arr.clone();
        int res[]=new int[arr.length];
        Arrays.fill(res,0);
        int n=arr.length;
        int k=1;
        Arrays.sort(copy);
        for(int i=0;i<n;i++)
        {
            if(!map.containsKey(copy[i]))
            {
                map.put(copy[i],k++);
            }
        }
        for(int i=0;i<n;i++)
        {
            res[i]=map.get(arr[i]);
        }
        return res;
    }
}