class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String i : strs) {
            char[] ch = i.toCharArray();
            Arrays.sort(ch);
            String sortedStr = String.valueOf(ch);
            
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            
            map.get(sortedStr).add(i);
        }
        
        return new ArrayList<>(map.values());
    }
}