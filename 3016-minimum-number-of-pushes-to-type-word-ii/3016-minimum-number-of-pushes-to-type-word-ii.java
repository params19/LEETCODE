class Solution {
    public int minimumPushes(String word) {
        
        HashMap<String, Integer> frequency = new HashMap<>();
        ArrayList<String> sortedWord = new ArrayList<>();
        int pushValue = 0, minPush = 0;

        for (int i = 0; i < word.length(); i++) {
            String key = String.valueOf(word.charAt(i));
            if (!sortedWord.contains(key)) sortedWord.add(key);
            frequency.put(key, frequency.get(key) == null ? 1 : frequency.get(key) + 1);
        }
        
        Collections.sort(sortedWord, (i, j) -> {
            if (frequency.get(i) < frequency.get(j)) return 1;
            else if (frequency.get(i) > frequency.get(j)) return -1;
            else return 0;
        });
        
        

        for (int i = 0; i < sortedWord.size(); i++) {
            if (i % 8 == 0) pushValue++;
            minPush += frequency.get(sortedWord.get(i)) * pushValue;
        }

        return minPush;
    }
}