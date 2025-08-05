class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=fruits.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(fruits[i]<=baskets[j])
                {
                    baskets[j]=-1;
                    break;
                }
            }
        }
        for(int i : baskets)
        {
            if(i==-1)n--;
        }
        return n;
    }
}