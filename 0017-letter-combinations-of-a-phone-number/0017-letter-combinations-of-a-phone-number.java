import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), digits, 0);
        return res;
    }
    private void backtrack(List<String> res, StringBuilder temp, String digits, int start)
    {
        if(temp.length() == digits.length())
        {
            res.add(temp.toString());
        }
        else
        {
            String[] letters = getLetters(digits.charAt(start));
            for(int i = 0; i < letters.length; i++)
            {
                temp.append(letters[i]);
                backtrack(res, temp, digits, start + 1);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
    private String[] getLetters(char c)
    {
        switch(c)
        {
            case '2': return new String[]{"a", "b", "c"};
            case '3': return new String[]{"d", "e", "f"};
            case '4': return new String[]{"g", "h", "i"};
            case '5': return new String[]{"j", "k", "l"};
            case '6': return new String[]{"m", "n", "o"};
            case '7': return new String[]{"p", "q", "r", "s"};
            case '8': return new String[]{"t", "u", "v"};
            case '9': return new String[]{"w", "x", "y", "z"};
            default: return new String[]{};
        }
    }
}