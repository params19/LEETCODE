class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int res[][]=new int[n][m];
        for(int i=0;i<m;i++)
        {
            res[0][i]=matrix[0][i]-'0';
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]=='1')
                {
                    res[i][j]=res[i-1][j]+1;
                }
                else
                {
                    res[i][j]=0;
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,largestRectangleArea(res[i]));
        }
        return ans;
    }
    private static int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int left[]=new int[n];
        int right[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                left[i]=0;
            }
            else
            {
                left[i]=st.peek()+1;
            }
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && heights[st.peek()]>=heights[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                right[i]=n-1;
            }
            else
            {
                right[i]=st.peek()-1;
            }
            st.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,heights[i]*(right[i]-left[i]+1));
        }
        return ans;
    }
}