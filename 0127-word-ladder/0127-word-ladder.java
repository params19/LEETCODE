class Solution {
    public int ladderLength(String b, String e, List<String> ll) {
        Set<String> ss=new HashSet<>();
        for(String st : ll)ss.add(st);
        Set<String> vis=new HashSet<>();
        Queue<String> que=new LinkedList<>();
        que.add(b);
        vis.add(b);
        int level=1;
        while(!que.isEmpty())
        {
            int n=que.size();
            while(n-->0)
            {
                String curr=que.poll();
                if(curr.equals(e))
                {
                    return level;
                }
                for(char ch :new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}
)
                {
                for (int i=0;i<curr.length();i++) 
                {
                char[] neighbour = curr.toCharArray();
                neighbour[i] = ch;
                String newStr = new String(neighbour);
                if(!vis.contains(newStr) && ss.contains(newStr)) 
                {
                vis.add(newStr);
                que.offer(newStr);
                }
            }
        }
            }
            level++;
        }
        return 0;
    }
}