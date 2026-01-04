class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        res=[]
        for i in range(numRows):
            row=[]
            for j in range(i+1):
                if j==0:
                    row.append(1)
                elif j==i:
                    row.append(1)
                else:
                    row.append(res[i-1][j-1]+res[i-1][j])
            res.append(row)
        return res
        