class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n=len(nums)
        res=[-1]*n
        st=[]
        for i in range(2*n-1, -1, -1):
            v=nums[i%n]
            while st and st[-1]<=v:
                st.pop()
            if st:
                res[i%n]=st[-1]
            st.append(v)
        return res

        