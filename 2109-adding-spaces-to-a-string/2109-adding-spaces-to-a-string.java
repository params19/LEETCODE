class Solution {
    public String addSpaces(String s, int[] arr) {
        int n=s.length();
        StringBuilder sb = new StringBuilder();

        int j = 0;
        for(int i = 0;i < n; i++)
        {
            if(j < arr.length && i == arr[j]){
                sb.append(" ");
                j++;
            }

            sb.append(s.charAt(i));
        }
        return sb.toString();
        // return st;
    }
}