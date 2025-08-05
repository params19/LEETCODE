class Solution {
    public int[] asteroidCollision(int[] arr) {
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        for (int a : arr)
        {
            while(!st.isEmpty() && a<0&&st.peek()>0) {
                int sum=a+st.peek();
                if(sum<0) {
                    st.pop();
                }else if (sum>0) {
                    a=0;
                    break;
                } else {
                    st.pop();
                    a = 0;
                }
            }
            if (a!=0) {
                st.push(a);
            }
        }
        int len=st.size();
        int[] res=new int[len];
        for (int i = len - 1; i >= 0; i--){
            res[i] = st.pop();
        }
        return res;
    }
}