class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        n=len(nums)
        k=k%n
        res=[0]*n
        for i in range(n):
            shift=(i+k)%n
            res[shift]=nums[i]

        for i in range(n):
            nums[i]=res[i]




