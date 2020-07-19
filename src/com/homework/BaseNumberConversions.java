package com.homework;

public class BaseNumberConversions {

	public static void main(String[] args) {
		// Old decimal to octal way
		System.out.println(dToO(10));
		System.out.println(dToO(11));
		// New way as of J8
		System.out.println(Integer.toOctalString(10));
		System.out.println(Integer.toOctalString(11));
		
		// Old way octal to decimal
		System.out.println(oToD(12));
		System.out.println(oToD(13));
		// New way as of J8
		System.out.println(Integer.parseInt("12", 8));
		System.out.println(Integer.parseInt("13", 8));

	}
	
	private static char octalchars[]={'0','1','2','3','4','5','6','7'}; 
	
	public static String dToO(int decimal){    
	    int rem; 
	    String octal="";   
	      
	    while(decimal>0)  
	    {  
	       rem=decimal%8;   
	       octal=octalchars[rem]+octal;   
	       decimal=decimal/8;  
	    }  
	    return octal;  
	} 
	
	public static int oToD(int onum){    

		int num = 0;      
		int p = 0;      
		while(true){    
		   if(onum == 0){    
			break;    
		   } else {    
			int temp = onum%10;    
			num += temp*Math.pow(8, p);    
			onum = onum/10;    
			p++;    
		   }    
		}    
		return num;    
	   } 
	

}
