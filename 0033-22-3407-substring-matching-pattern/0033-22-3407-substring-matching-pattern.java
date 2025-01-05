class Solution {
    //one of the best easy question that i ever came across on LC.
    public boolean hasMatch(String s, String p) {
        int index = p.indexOf('*');
        int p1 = s.indexOf(p.substring(0, index)); 
        int p2 = s.indexOf(p.substring(index + 1), p1 + index); 
        if (p1 != -1 && p2 != -1) return true;
        return false;
    }
}