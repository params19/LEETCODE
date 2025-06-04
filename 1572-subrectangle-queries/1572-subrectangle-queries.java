class SubrectangleQueries {
    int[][] arr;
    public SubrectangleQueries(int[][] rectangle) {
        arr=rectangle;
    }
    public void updateSubrectangle(int r1, int c1, int r2, int c2, int val) {
        for(int i=r1; i<=r2; i++) {
            for(int j=c1; j<=c2; j++) {
                arr[i][j] = val;
            }
        }
    }
    
    public int getValue(int row, int col) {
        return arr[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */