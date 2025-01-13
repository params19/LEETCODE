class NumArray {
    private int[] seg; 
    private int n;     
    public NumArray(int[] nums) {
        n=nums.length;
        seg=new int[4*n]; 
        build(0, 0,n-1,nums);
    }
    private void build(int i, int l, int r, int[] nums) {
        if (l==r) { 
            seg[i]=nums[l];
            return;
        }
        int mid=l+(r-l)/2;
        build(2*i+1,l,mid,nums);  
        build(2*i+2,mid + 1,r,nums);
        seg[i]=seg[2*i+1]+seg[2*i+2]; 
    }

    public void update(int idx, int val) {
        updateseg(idx,val,0,0,n-1);
    }
    public void updateseg(int idx,int val,int i,int l,int r)
    {
        if(l==r)
        {
            seg[i]=val;
            return;
        }
        int mid=l+(r-l)/2;
        if(idx<=mid)updateseg(idx,val,2*i+1,l,mid);
        else updateseg(idx,val,2*i+2,mid+1,r);
        seg[i]=seg[2*i+1]+seg[2*i+2];
    }
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
    }

    private int query(int i, int st, int en, int l, int r) {
        if (l>en||r<st) return 0; 
        if (l<=st&&r>=en) return seg[i]; 
        int mid= st+(en-st)/2;
        return query(2*i+1,st,mid,l,r) + query(2*i+2,mid+1,en,l,r); 
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */