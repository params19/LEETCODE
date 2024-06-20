import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int m=(x/2)+1;
        if(x%2==0)
        {
            System.out.println(x/2);
        }
        else
        {
            System.out.println(m);
        }
	}
}
