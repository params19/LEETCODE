import java.util.*;
class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> ll=new ArrayList<>();
        //2^n matlab hota hai = (1<<n) theek?
        for(int i=0;i<(1<<n);i++)
        {
            //gray code ka formula ye hota hai :
            int g=i^(i>>1);
            ll.add(g);
        }
        return ll;
    }
}