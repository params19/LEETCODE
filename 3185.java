class Solution {
    public long countCompleteDayPairs(int[] hours) {
    int[] freq = new int[24]; // Array to store frequency of hours (0-23)

    long ans = 0; // Stores the final count of complete day pairs

    for (int hour : hours) 
    {
      int req = (24 - hour % 24) % 24; // Calculate complement for a complete day
      ans += freq[req]; // Add count of elements that can form a complete day with current hour
      freq[hour%24]++; // Increment frequency of current hour
    }
    return ans; 
  }
}