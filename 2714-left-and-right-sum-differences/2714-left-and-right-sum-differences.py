class Solution(object):
    def leftRightDifference(self, nums):
        n = len(nums)
        l = [0] * n
        r = [0] * n
        res = [0] * n

        c = 0
        for i in range(n):          # left sum
            l[i] = c
            c += nums[i]

        c = 0
        for i in range(n-1, -1, -1): # right sum
            r[i] = c
            c += nums[i]

        for i in range(n):          # absolute difference
            if l[i] >= r[i]:
                res[i] = l[i] - r[i]
            else:
                res[i] = r[i] - l[i]

        return res
