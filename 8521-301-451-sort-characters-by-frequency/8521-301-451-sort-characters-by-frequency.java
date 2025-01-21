class Solution {
    public String frequencySort(String s) {
        StringBuilder res= new StringBuilder();

        Map<Character,Integer> mp=new HashMap<>();
        for (char c :s.toCharArray()) 
        {
            mp.put(c, mp.getOrDefault(c,0)+1);
        }
        List<Character> ll=new ArrayList<>(mp.keySet());
        ll.sort((a, b) -> mp.get(b) - mp.get(a));

        for (char c :ll) 
        {
            int freq=mp.get(c);
            for (int i=0;i<freq;i++) 
            {
                res.append(c);
            }
        }
        return res.toString();
    }
}