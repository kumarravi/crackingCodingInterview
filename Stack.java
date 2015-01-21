package cracking.coding;

import cracking.coding.Node;
 

public class Stack {
	
	Node top;
	
	public Object pop(){
		Node tmp;
		if(top != null){
			tmp = top;
			top=top.next;
			
			return tmp.value; 
		}
		return null;
	}
	
	public void push(Object data){
		
		Node tmp = new Node((int)data);
		tmp.next = top;
		top =  tmp;
	}
	
	public int top(){
		
		return top!=null?top.value:-1;
	}
	
	public void print(){
		Node tmp = top;
		while(tmp != null){
			
			System.out.println("-->"+tmp.value);
			tmp=tmp.next;
		}
	}
	
	public static void main(String args[]){
		Stack stack = new Stack();
		stack.push(31);
		stack.push(12);
		stack.push(19);
		stack.push(60);
		stack.push(2);
		stack.print();
		//stack.pop();
		stack.sortMe().print();
	}
	
	public Stack sortMe(){
		Stack buffer = new Stack();
		
		while(this.top != null){
			Object temp = this.pop();
			if(buffer.top() == -1){
				buffer.push(temp);
				continue;
			}
				
			while((int)temp <= (int)buffer.top()){
				this.push(buffer.pop());
			}
			buffer.push(temp);
		}
		
		return buffer;
	}

}
