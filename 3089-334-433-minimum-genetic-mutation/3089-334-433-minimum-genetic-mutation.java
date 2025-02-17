class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bs=new HashSet<>();
        for(String st : bank)bs.add(st);
        Set<String> vis=new HashSet<>();
        Queue<String> que=new LinkedList<>();
        que.add(start);
        vis.add(start);
        int level=0;
        while(!que.isEmpty())
        {
            int n=que.size();
            while(n-->0)
            {
                String curr=que.poll();
                if(curr.equals(end))
                {
                    return level;
                }
                for(char ch :new char[]{'A','C','G','T'})
                {
                    for (int i = 0; i < curr.length(); i++) 
                    {
                    char[] neighbour = curr.toCharArray();
                    neighbour[i] = ch;
                    String newStr = new String(neighbour);

                if(!vis.contains(newStr) && bs.contains(newStr)) 
                {
                vis.add(newStr);
                que.offer(newStr);
                }
            }
        }
            }
            level++;
        }
        return -1;
    }
}