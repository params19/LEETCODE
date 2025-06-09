class Solution {
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        int zeroes = 0;

        // Count the number of zeroes
        for (int num : arr) {
            if (num == 0) {
                zeroes++;
            }
        }

        int copyFrom = len - 1;
        int copyTo = len + zeroes - 1;

        // Traverse backwards
        while (copyFrom < copyTo) {
            // Only write if within bounds
            if (copyTo < len) {
                arr[copyTo] = arr[copyFrom];
            }

            // If element is 0, write it twice
            if (arr[copyFrom] == 0) {
                copyTo--;
                if (copyTo < len) {
                    arr[copyTo] = 0;
                }
            }

            copyFrom--;
            copyTo--;
        }
    }
}
