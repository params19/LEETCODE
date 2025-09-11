class Solution {
    public String sortVowels(String s) {
        int n=s.length();
        String con="";
        String vow="AEIOUaeiou";
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(vow.indexOf(ch)>=0){
                con=con+ch;
            }
        }
        char arr[]=con.toCharArray();
        Arrays.sort(arr);
        String res="";
        int idx=0;
        for(char ch : s.toCharArray())
        {
            if(vow.indexOf(ch)==-1)
            {
                res=res+ch;
            }
            else{
                res=res+arr[idx];
                idx++;
            }
        }
        return res;
    }
}