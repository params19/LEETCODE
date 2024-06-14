class Solution {
    public int reverse(int x) {
        int u=0;
    if(x>0)
    {
    long rev=0;
    while(x != 0)   
     {  
       int r= x%10;  
       rev=(rev*10)+r;  
       x=x/10;  
     }
    if((rev>Integer.MAX_VALUE)||(rev<Integer.MIN_VALUE))
    {
       u=0;
    } 
    else
    {
        u=(int)rev;
    }     
}
else if(x<0)
{
    int p=-(x);
    long rev=0;
    while(p != 0)   
     {  
       int r= p%10;  
       rev=(rev*10)+r;  
       p=p/10;  
     }
     rev=-(rev);
    if((rev>Integer.MAX_VALUE)||(rev<Integer.MIN_VALUE))
    {
        u=0;
    }
    else
    {
        u=(int)rev;
    }   
    }
    return u;
    }
}