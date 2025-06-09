class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        length = len(arr)
        
        zeroes = 0
        for i in arr:
            if i == 0:
                zeroes += 1
        
        copyFrom = length - 1
        copyTo = length + zeroes - 1

        while copyFrom != copyTo:
            if copyTo < length:
                arr[copyTo] = arr[copyFrom]
            copyTo -= 1
            if arr[copyFrom] == 0:
                if copyTo < length:
                    arr[copyTo] = arr[copyFrom]
                copyTo -= 1
            copyFrom -= 1