public class Utility
{
	//d - date ,m - month, y- year
	String dayFinder(int d,int m,int y)
	{
		String  []a = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		Integer []b = {0,0,3,3,6,1,4,6,2,5,0,3,5};
        Integer []c = {0,5,3,1};  
        int s;
        int f = 0;

    if(isLeapYear(y) && m>=3)
        f=1;
    
     int l=y%100;
     y=y/100;

      s = d + b[m] + (l-1) + ((l-1)/4) + c[y%4] + f;
      if(l == 0)
      	s--;

      return a[s%7];
	}
	boolean isLeapYear(int n)//n - year
	{
		if(n%400 == 0)return true;
		if(n%4 == 0)
		{
			if(n % 100 == 0)
				return false;
			return true;
		}
		return false;
	}
}