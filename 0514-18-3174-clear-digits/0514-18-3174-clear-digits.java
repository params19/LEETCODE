class Solution {
    public String clearDigits(String s) {
        StringBuilder res=new StringBuilder();
        for(char ch : s.toCharArray())
        {
            if(Character.isDigit(ch))
            {
                if(res.length()>0)
                {
                    res.deleteCharAt(res.length()-1);
                }
            }
            else
            {
                res.append(ch);
            }
        }
        return res.toString();
    }
}