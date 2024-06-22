import java.util.*;
class solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //we will increment the indegree of the node which is connected to the current node.
        int indegree[]=new int[V];
        for(int i=0;i<V;i++)
        {
            for(int j:adj.get(i))
            {
                indegree[j]++;
            }
        }

        //we will add the nodes with indegree 0 to the queue.
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }

        //we will remove the node from the queue and add it to the answer array.
        int ans[]=new int[V];
        int index=0;
        while(!q.isEmpty())
        {
            int node=q.poll();
            ans[index++]=node;
            for(int i:adj.get(node))
            {
                indegree[i]--;
                if(indegree[i]==0)
                {
                    q.add(i);
                }
            }
        }
        return ans;
    }
}