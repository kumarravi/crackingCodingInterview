package cracking.coding;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CompareBinToHex {
	
	public static void main(String [] args){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("write the value you want to use");
		
		try {
			System.out.println(reader.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String bin ="1101000111001110";
		String hex ="D1CE";
		CompareBinToHex object = new CompareBinToHex();
		object.compareBinToHexa(bin, hex);
	}

	public void compareBinToHexa(String bin, String hex){
		int binNum = convertToDec(bin, 2);
		int hexNum = convertToDec(hex, 16);
		
		if(binNum < 0 || hexNum < 0)
			System.out.println("The numbers are not equal");
		else
			System.out.println("The two numbers are equal: "+(binNum==hexNum));
	}
	
	public int convertToDec(String num, int base){
		if(base < 0 || (base > 10 && base !=16))
			return -1;
		int value = 0;
		for(int i = num.length()-1; i >= 0 ; i--){
			int digit = convertToDigit(num.charAt(i));
			if( digit < 0 || digit > base )
				return -1;
			int exp = num.length() -1 -i;
			value += digit * Math.pow(base, exp);
		}
		return value;
	}
	
	public int convertToDigit(char c){
		if(c >= '0' && c <= '9')
			return (c-'0');
		else if(c >= 'A' && c <= 'Z')
			return (10 + c -'A');
		else if(c >= 'a' && c <= 'z')
			return (10 + c - 'a');
		
		return -1;
	}
}
