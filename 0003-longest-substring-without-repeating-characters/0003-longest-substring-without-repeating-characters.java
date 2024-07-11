class Solution {
    public int lengthOfLongestSubstring(String s) {
       Map<Character,Integer> map=new HashMap<>();
       //Map declare kiya hai ha character ki frequency store karne k liye
       int l=0,r=0;
       //2 pointer hai
       //r ko badhayenge 
       int len=0;
       //max length k liye variable hai
       int n=s.length();
       while(r<n)
       {
           if(map.containsKey(s.charAt(r)))
           //check krne k liye ki map me hai ki ni character
           {
               l=Math.max(map.get(s.charAt(r))+1,l);
               //nayi wali value ko update karenge
           }
        map.put(s.charAt(r),r);
        len=Math.max(len,r-l+1);
        r++;
       }
       return len;
    }
}