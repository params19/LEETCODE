class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<digits.length;i++){
            for(int j=0;j<digits.length;j++){
                for(int k=0;k<digits.length;k++){
                    if(i==j|i==k||j==k) continue;
                    int num = digits[i]*100 + digits[j]*10+digits[k];
                    if(num>=100 && num%2==0) set.add(num);
                }
            }
        }
        List<Integer> temp =new ArrayList<>(set);
        Collections.sort(temp);
        int[] ans = new int[temp.size()];
        for(int i=0;i<ans.length;i++) ans[i]=temp.get(i);
        return ans;
    }
}