class Solution {
    public int regionsBySlashes(String[] grid) {
        int n=grid.length;
        int m=grid[0].length();
        int[][] binary_matrices=new int[n*3][m*3];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i].charAt(j)=='/'){
                    binary_matrices[i*3][j*3+2]=1;
                    binary_matrices[i*3+1][j*3+1]=1;
                    binary_matrices[i*3+2][j*3]=1;
                }
                else if(grid[i].charAt(j)=='\\'){
                    binary_matrices[i*3][j*3]=1;
                    binary_matrices[i*3+1][j*3+1]=1;
                    binary_matrices[i*3+2][j*3+2]=1;
                }
            }
        }
        int ans=0;
        for(int i=0;i<n*3;i++){
            for(int j=0;j<m*3;j++){
                if(binary_matrices[i][j]==0){
                    dfs(binary_matrices,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] binary_matrices,int i,int j){
        if(i<0 || j<0 || i>=binary_matrices.length || j>=binary_matrices[0].length || binary_matrices[i][j]==1){
            return;
        }
        binary_matrices[i][j]=1;
        dfs(binary_matrices,i+1,j);
        dfs(binary_matrices,i-1,j);
        dfs(binary_matrices,i,j+1);
        dfs(binary_matrices,i,j-1);
    }
}