class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n=skill.length;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            set.add(skill[i]+skill[n-i-1]);
        }
        if(set.size()!=1)return -1;
        long sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=skill[i]*skill[n-i-1];
        }
        return sum/2;
    }
}