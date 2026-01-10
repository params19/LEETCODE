class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        uniq=set()
        while n!=1:
            if n in uniq:
                return False
            uniq.add(n)
            n=self.squaresum(n)
        return True

    def squaresum(self,n):
        s=0
        while n>0:
            d=n%10
            s+=d*d
            n//=10
        return s