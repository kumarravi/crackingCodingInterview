package cracking.coding;

public class Strings {
	
	public static void main(String[] args){
		//isUniqueCharString("prabhu");
		//isPermute("ravi","vira");
		//System.out.println(Integer.bitCount((3^5)));
		//System.out.println(convertDoubletoBinary(0.7));
		System.out.println(checkbits(1, 3));
	}
	
	public static int isUniqueCharString(String str){
		int checker=0;
		for(int i=0;i<str.length();i++){
			int val = str.charAt(i) - 'a';
			if((checker & (1<<val)) > 0){
				System.out.println("Not Unique");
				return 0;
			}	
			checker |= (1<<val);
		}
		System.out.println("Unique");
		return 1;
	}
	
	public static int isPermute(String str1, String str2){
		if(str1.length()!=str2.length()){
			System.out.println("not equal");
			return -1;
		}
		
		int checker1= getStringBits(str1);
		int checker2= getStringBits(str2);
		
		if(checker1 != checker2){
			System.out.println("Not Permutation");
		}else
			System.out.println("Permutaion");
			
		
		return 1;
	}
	
	public static  int getStringBits(String str){
		int checker =0;
		for(int i=0;i<str.length();i++){
			int val = str.charAt(i)-'a';
			
			checker |= (1<<val);
			
		}
		return checker;
	}
	
	public static String convertDoubletoBinary(double num){
		if(num >= 1 || num <= 0){
			return "ERROR1";
		}
		System.out.println(num);
		StringBuilder binary = new StringBuilder();
		double frac = 0.5;
		binary.append(".");
		while(num > 0){
			if(binary.length()>32)
				return "ERROR";
			
			if(num>=frac){
				binary.append(1);
				num -= frac;
			}else{
				binary.append(0);
			}
			
			frac /= 2;
		}
		return binary.toString();
	}
	
	public static int checkbits(int a, int b){
		int xor = a^b;
		int count=0;
		while(xor > 0){
			if((xor&1)>0)
				count++;
			xor >>= 1;
		}
		return count;
	}

}
