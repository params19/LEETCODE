class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
         int[][] matrix=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(matrix[i],-1);
        }
        int toprow=0, bottrow=m-1,leftcol=0,rightcol=n-1;
        while(head!=null){
            for(int col=leftcol;col<=rightcol;col++){
                if(head==null)break;
                matrix[toprow][col]=head.val;
                head=head.next;

            }
            toprow++;
            for(int row=toprow;row<=bottrow;row++){
                if(head == null)break;
                matrix[row][rightcol]=head.val;
                head=head.next;

            }
            rightcol--;
            for(int col=rightcol;col>=leftcol;col--){
                if(head==null)break;
                matrix[bottrow][col]=head.val;
                head=head.next;
            }
            bottrow--;
            for(int row=bottrow;row>=toprow;row--){
                if(head==null)break;
                matrix[row][leftcol]=head.val;
                head=head.next;
            }
            leftcol++;

        }
        return matrix ;
        
    }
}