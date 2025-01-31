// Brute force- 71/75 tc: 

// // class Solution {
// //     public int largestIsland(int[][] grid) {
// //         int n=grid.length;
// //         int m=grid[0].length;
// //         int ans=0;
// //         for (int i=0;i<n;i++) 
// //         {
// //             for (int j=0;j<m;j++) 
// //             {
// //                 if(grid[i][j]==0)
// //                 {
// //                     grid[i][j]=1;
// //                     boolean vis[][]=new boolean[n][m];
// //                     ans=Math.max(ans,dfs(i,j,grid,vis));
// //                     grid[i][j]=0; 
// //                 }
// //             }
// //         }
// //         return ans==0?n*m:ans; 
// //     }
// //     private int dfs(int i,int j,int[][] grid, boolean[][] vis) 
// //     {
// //         int n=grid.length;
// //         int m=grid[0].length;
// //         if (i < 0||j<0 || i >= n || j >= m || grid[i][j] ==0||vis[i][j]) 
// //         {
// //             return 0;
// //         }
// //         vis[i][j] = true;
// //         int size=1; 
// //         size+=dfs(i+1,j,grid,vis);
// //         size+=dfs(i-1,j,grid,vis);
// //         size+=dfs(i,j+1,grid,vis);
// //         size+=dfs(i,j-1,grid,vis);
// //         return size;
// //     }
// // }

//Optimal, bas har valid island ko pehle ek unique id dedi aur usko map me store kara liya
class Solution {
    private int m, n;
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int DFS(int[][] grid, int i, int j, int id) 
    {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) 
        {
            return 0;
        }
        grid[i][j]=id;
        int count=1;
        for (int[] dir : directions) 
        {
            int x =i+dir[0];
            int y =j+dir[1];
            count += DFS(grid, x, y, id);
        }
        return count;
    }
    
    public int largestIsland(int[][] grid) 
    {
        m = grid.length;
        n = grid[0].length;
        int maxArea=0;
        Map<Integer, Integer> islandSizes = new HashMap<>();
        int islandId=2;
        for (int i=0;i<m;i++) 
        {
            for (int j=0;j<n;j++) 
            {
                if (grid[i][j]==1) 
                {
                    int size =DFS(grid, i, j, islandId);
                    maxArea =Math.max(maxArea, size);
                    islandSizes.put(islandId, size);
                    islandId++;
                }
            }
        }
        
        for (int i=0;i<m;i++) 
        {
            for (int j=0;j<n;j++) 
            {
                if (grid[i][j]==0) 
                {
                    Set<Integer> uniqueIslands = new HashSet<>();
                    for (int[] dir :directions)
                    {
                        int x =i+dir[0];
                        int y =j+dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 0) 
                        {
                            uniqueIslands.add(grid[x][y]);
                        }
                    }
                    int sum=1; // converting current 0 to 1
                    for (int id : uniqueIslands) 
                    {
                        sum += islandSizes.get(id);
                    }
                    maxArea = Math.max(maxArea, sum);
                }
            }
        }
        return maxArea;
    }
}
