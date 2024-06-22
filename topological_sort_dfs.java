//Topological Sort(DFS) :
//Linear ordering of the vertices such that if there is an edge between u and v then, u appears before v in thta ordering.
//only in "directed acyclic graph"(DAG).
import java.util.*;
class solution
{
    private static void dfs(int node, int vis[], Stack<Integer> st,  ArrayList<ArrayList<Integer>> adj)
    {
        vis[node]=1;
        for(int i : adj.get(node))
        {
            if(vis[i]==0)
            {
                dfs(i,vis,st,adj);
            }
        }
        st.push(node);
    }

    //Function to return the list containing the vertices in topologocal order
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int vis[]=new int[V];
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,vis,st,adj);
            }
        }

        int ans[]=new int[V];
        int i=0;
        while(!st.empty()){
            ans[i++]=st.peek();
            st.pop();
        }
        return ans;
    }
}