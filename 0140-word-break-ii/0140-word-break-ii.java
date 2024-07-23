import java.util.*;
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        backtrack(res, s, wordDict, "", 0);
        return res;
    }
    private void backtrack(List<String> res, String s, List<String> wordDict, String temp, int start)
    {
        if(start == s.length())
        {
            res.add(temp.trim());
        }
        else
        {
            for(String word : wordDict)
            {
                if(s.startsWith(word, start))
                {
                    backtrack(res, s, wordDict, temp + word + " ", start + word.length());
                }
            }
        }
    }
}