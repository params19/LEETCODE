class Solution {
    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        StringBuilder flipped = new StringBuilder();
        for (char bit : binary.toCharArray()) {
            flipped.append(bit == '0' ? '1' : '0');
        }
        return Integer.parseInt(flipped.toString(), 2);
    }
}