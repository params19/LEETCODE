class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int n=s.length();
        int ans=0;
        // while(s.lastIndexOf('1')>s.indexOf('0'))
        while(s.contains("01"))
        {
            s=s.replace("01","10");
            ans++;
        }
        return ans;
    }
    // public String swap(String s, int i) 
    // {
    //     char[] arr=s.toCharArray();
    //     char temp=arr[i];
    //     arr[i]=arr[i + 1];
    //     arr[i+1]=temp;
    //     return new String(arr);
    // }
}