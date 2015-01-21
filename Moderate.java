package cracking.coding;

public class Moderate {
	
	public static void main(String args[]){
		Moderate test = new Moderate();
		System.out.println(test.getMaxNaive(-8, -9));
	}
	
	public int getMaxNaive(int a, int b){
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(a-b);
		
		int using_a = sa^sb;
		int using_c = flip(sa^sb);
		
		int k = using_a*sa+using_c*sc;
		int l = flip(k);
		return a*k+b*l;
	}
	
	public int sign(int a){
		return flip((a>>31) & 0x1);
	}
	
	public int flip(int a){
		return a^1;
	}

}
