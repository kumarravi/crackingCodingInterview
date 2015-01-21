package cracking.coding;

import java.util.Hashtable;

public class BitManipulation {
	
	public static void main(String args[]){

		System.out.println("differenc in bits are: "+bitDiff((byte)3,(byte)2));
		Hashtable hash = new Hashtable();
	}

	public static int bitDiff(byte one, byte second){

		int numBits = 0;
		int xored = (one ^ second);

		for(int i = 0 ; i < 8 ; i++ ){
			if((xored&1) >= 1)
				numBits++;
			xored>>=1;
		}

		return numBits;
	}
	
	public int mergeInt(int n, int m, int i, int j){
		
		int allones = ~0;
		int left = allones<<(j+1);
		int right = (1<<i)-1;
		int mask = left|right;
		
		return ((n&mask)|(m<<i));
	}

}
