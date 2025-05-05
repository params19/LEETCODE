class Solution {
    public int findClosest(int x, int y, int z) {
        int diff=Math.abs(x-z);
        int d2=Math.abs(z-y);
        if(d2<diff)return 2;
        if(d2>diff)return 1;
        return 0;
    }
}