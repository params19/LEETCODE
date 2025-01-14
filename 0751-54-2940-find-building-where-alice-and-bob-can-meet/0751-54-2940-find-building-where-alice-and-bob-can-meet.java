class Solution {
    //binary search+segment tree
    //same RMIQ wala concept lgana h query pe
    private void build(int i, int l, int r, int[] seg, int[] heights) {
        if (l == r) {
            seg[i]=l;
            return;
        }
        int mid=l+(r-l)/2;
        build(2*i+1, l, mid, seg, heights);
        build(2*i+2, mid+1, r, seg, heights);
        seg[i]=(heights[seg[2*i+1]]>=heights[seg[2*i+2]])?seg[2*i+1]:seg[2*i+2];
    }
    private int[] constructST(int[] heights) {
        int n =heights.length;
        int[] seg = new int[4 * n];
        build(0, 0, n - 1, seg, heights);
        return seg;
    }

    private int query(int start, int end, int i, int l, int r, int[] seg, int[] heights) {
        if (l>end||r<start) {
            return -1; 
        }
        if (l>=start && r<=end) {
            return seg[i]; 
        }
        int mid =l+(r-l)/2;
        int left_idx=query(start,end,2*i+1, l, mid, seg, heights);
        int right_idx=query(start,end,2*i+2, mid+1, r, seg, heights);
        if (left_idx==-1) return right_idx;
        if (right_idx==-1) return left_idx;
        return (heights[left_idx] >= heights[right_idx]) ? left_idx : right_idx;
    }

    private int RMIQ(int[] st, int[] heights, int a, int b) {
        return query(a, b, 0, 0, heights.length - 1, st, heights);
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int[] seg =constructST(heights);
        int[] res =new int[queries.length];

        for (int q = 0; q < queries.length; q++) 
        {
            int alice = Math.min(queries[q][0], queries[q][1]);
            int bob = Math.max(queries[q][0], queries[q][1]);
            if (alice==bob || heights[bob]>heights[alice]) {
                res[q]=bob;
                continue;
            }
            int l=bob+1, r=n-1, res_idx = Integer.MAX_VALUE;
            while (l<=r) 
            {
                int mid = l+(r-l)/2;
                int idx = RMIQ(seg, heights, l, mid);
                if (heights[idx] > Math.max(heights[alice], heights[bob])) {
                    r=mid-1;
                    res_idx=Math.min(res_idx, idx);
                } else {
                    l=mid+1;
                }
            }
            res[q]=(res_idx==Integer.MAX_VALUE)?-1:res_idx;
        }
        return res;
    }
}