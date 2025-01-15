class Solution {
    public int minimizeXor(int n1, int n2) {
        int x=n1;
        int req=Integer.bitCount(n2);
        int curr=Integer.bitCount(x);
        if(req==curr)return n1;
        int pos=0;
        if(req>curr)
        {
            while(req>curr)
            {
                if(!is_set(x,pos))
                {
                    x=set(x,pos);
                    curr++;
                }
                pos++;
            }
        }
        else if(curr>req) {
            pos=0;
            while(curr>req)
            {
                if(is_set(x,pos))
                {
                    x=unset(x,pos);
                    curr--;
                }
                pos++;
            }
        }
        return x;
    }
    public boolean is_set(int x, int bit) {
        return (x&(1<<bit))!=0;
    }
    public int set(int x, int bit) {
        return x|(1<<bit);
    }
    public int unset(int x, int bit) {
        return x&~(1<<bit);
    }
}