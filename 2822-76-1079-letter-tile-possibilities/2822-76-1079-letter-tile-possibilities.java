class Solution {
    Set<String> ss=new HashSet<>();
    public int numTilePossibilities(String tiles) {
        int vis[]=new int[tiles.length()];
        StringBuilder curr=new StringBuilder();
        recur(tiles,curr,vis);
        return ss.size()-1;
    }
    public void recur(String st, StringBuilder curr, int vis[])
    {
        ss.add(curr.toString());
        for(int i=0;i<st.length();i++)
        {
            if(vis[i]==1)continue;
            else
            {
                vis[i]=1;
                curr.append(st.charAt(i));
                recur(st,curr,vis);
                vis[i]=0;
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }
}