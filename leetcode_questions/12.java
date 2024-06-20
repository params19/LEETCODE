class Solution {
    //Time complexity: O(1)
    //Space complexity: O(1)
    public String intToRoman(int num) {
         int[] valus = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumeral = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder s = new StringBuilder();

        int i = 0;
    
        while (num > 0) {
            if (num >= valus[i]) {
                
                s.append(romanNumeral[i]);
                num -= valus[i];
            } else {
                i++;
            }
        }

        return s.toString();
    }
}