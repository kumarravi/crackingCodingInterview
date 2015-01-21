package cracking.coding;

public class StackFromArray {
	
	static int stackSize=100;
	static int [] buffer = new int[(stackSize*3)];
	static int [] stackPointer = {-1,-1,-1};
	
	public int pop(int stackNumber){
		
		if(stackPointer[(stackNumber)] == -1){
			System.out.println("Empty stack");
		}else{
			int data = buffer[absTopOfStack(stackNumber)];
			buffer[absTopOfStack(stackNumber)]=0;
			stackPointer[stackNumber]--;
			
			return data;
		}
		return 0;
	}
	
	public void push(int data, int stackNumber){
		if(stackPointer[stackNumber]+1 >= stackSize){
			System.out.println("Stack full");
		}else{
			stackPointer[stackNumber]++;
			buffer[absTopOfStack(stackNumber)+1] = data;	
		}
	}
	
	public static int absTopOfStack(int stackNumber){
		
		return stackNumber*stackSize*stackPointer[stackNumber];
	}
	
	public void print(int stackNumber){
		System.out.println();
	}

}
