class Solution {
    public String getHappyString(int n, int k) {
        List<String> ll=new ArrayList<>();
        recur(new StringBuilder(),n,ll);
        if(ll.size()<k)return "";
        return ll.get(k-1);
    }
    public void recur(StringBuilder curr, int n, List<String> ll)
    {
        if(curr.length()==n)
        {
            ll.add(curr.toString());
            return;
        }
        for(char ch='a';ch<='c';ch++)
        {
            if(curr.length()>0&&curr.charAt(curr.length()-1)==ch)continue;
            curr.append(ch);
            recur(curr, n, ll);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}