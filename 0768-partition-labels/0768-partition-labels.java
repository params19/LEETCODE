class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int lastIdx = s.lastIndexOf(ch);
            arr[i] = lastIdx; 
        }
        int match = arr[0];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            match = Math.max(match, arr[i]); 
            cnt++;
            if (i==match) { 
                ans.add(cnt);
                cnt = 0;
                if (i+1<n) {
                    match = arr[i + 1]; 
                }
            }
        }
        return ans;
    }
}
