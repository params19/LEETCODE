class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> o = new HashSet<>();
        Set<String> i = new HashSet<>();
        
        for (List<String> path : paths) 
        {
            String s = path.get(0);
            String e = path.get(1);
            o.add(s);
            i.add(e);
        }
        for (String city : i) 
        {
            if (!o.contains(city)) {
                return city;
            }
        }
        return "";
    }
}