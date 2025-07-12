class Solution {
    public int firstMissingPositive(int[] arr) {
        int i = 0;
        while(i < arr.length)
        {
            int correct = arr[i] - 1;
            if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correct])
                swap(arr, i, correct);
            else
                i++;
        }
        for(int idx = 0; idx < arr.length; idx++)
        {
            if(arr[idx] != idx + 1)
                return idx + 1;
        }
        return arr.length + 1;
    }
    public void swap(int[] arr, int first, int sec)
    {
        int temp = arr[first];
        arr[first] = arr[sec];
        arr[sec] = temp;
    }
}