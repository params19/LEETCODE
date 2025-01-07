class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans=new ArrayList<>();
        int n=words.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(words[i].contains(words[j])&&i!=j&&!ans.contains(words[j]))ans.add(words[j]);
            }
        }
        return ans;
    }
}