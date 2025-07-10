import java.util.*;
class Solution {
    public String longestWord(String[] words) {
        Set<String> ss= new HashSet<>();
        Arrays.sort(words);
        String res="";
        for (String word : words) 
        {
            if(word.length()==1|| ss.contains(word.substring(0, word.length()-1))) 
            {
                ss.add(word);
                if (word.length()>res.length()) {
                    res=word;
                }
            }
        }
        return res;
    }
}
