class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int len=words.length;
        int n=queries.length;
        int m=queries[0].length;
        int bin[]=new int[len];
        String alpha="aeiou";
        int ans[]=new int[n];
        for(int i=0;i<len;i++)
        {
            String s=words[i];
            char start=s.charAt(0);
            char end=s.charAt(s.length()-1);
            if(alpha.indexOf(start)!=-1&&alpha.indexOf(end)!=-1)
            {
                bin[i]=1;
            }
            else
            {
                bin[i]=0;
            }
        }
        int[] prefix = new int[len+1];
        for (int i = 0;i <len; i++) {
            prefix[i + 1] = prefix[i] + (bin[i] == 1 ? 1 : 0);
        }
        for(int i=0;i<n;i++)
        {
            int left=queries[i][0];
            int right=queries[i][1];
            ans[i] = prefix[right + 1] - prefix[left];
        }
        return ans;
    }
}