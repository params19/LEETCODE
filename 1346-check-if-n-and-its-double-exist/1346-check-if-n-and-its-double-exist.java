class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> ss=new HashSet<>();
        int cnt=0;
        for(int i : arr)
        {
            if(i==0)cnt++;
            ss.add(i);
        }
        if(cnt>1)return true;
        for(int i : arr)
        {
            if(ss.contains(i*2)&&i!=0)return true;
            // if(ss.contains(i*2)&&cnt%2==0)return true;
        }
        return false;
    }
}