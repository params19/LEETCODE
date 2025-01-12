class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> ss = new Stack<>();
        //Pair me store kardo , freq match hone pe hata dena
        for (char ch : s.toCharArray()) 
        {
            if (!ss.isEmpty() && ss.peek().getKey()==ch) {
                ss.push(new Pair<>(ch, ss.pop().getValue()+1));
            } else {
                ss.push(new Pair<>(ch, 1));
            }
            if (ss.peek().getValue()==k)ss.pop();
        }
        StringBuilder sb = new StringBuilder();
        for (Pair<Character, Integer> pair :ss) 
        {
            sb.append(String.valueOf(pair.getKey()).repeat(pair.getValue()));
        }
        return sb.toString();
    }
}
