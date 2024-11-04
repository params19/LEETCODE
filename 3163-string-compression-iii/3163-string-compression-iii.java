class Solution {
    public String compressedString(String word) {
        String ans = "";
        Queue<Character> q = new LinkedList<>();
        ArrayList<Integer> freq = new ArrayList<>();
        freq.add(1);
        q.add(word.charAt(0));
        char prev = q.peek();

        for(int i = 1; i < word.length(); i++){
            char c = word.charAt(i);
            int n = freq.size() - 1;

            if(!q.isEmpty() && prev == c){
                freq.set(n, freq.get(n)+1);
            }
            else{
                q.add(c);
                freq.add(1);
                prev = c;
            }
        }

        int idx = 0;
        while(!q.isEmpty()){
            int times = freq.get(idx)/9;

            while(times > 0){
                ans += 9;
                ans += q.peek();
                times--;
            }
            if(freq.get(idx) % 9 != 0){
                int rem = freq.get(idx) % 9;
                ans += rem;
                ans += q.peek();
            }
            q.remove();
            idx++;
        }
        return ans;
    }
}