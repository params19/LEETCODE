class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int  n=word.length();
        Map<String,Integer> map=new HashMap<>();
        int j=n/k;
        for(int i=0;i<n;i+=k)
        {
            String s=word.substring(i,i+k);
            map.put(s,map.getOrDefault(s,0)+1);
        }
        int max=0;
        for (int f : map.values()) 
        {
            max = Math.max(max, f);
        }
        return j-max;
    }
}