package cracking.coding;

public class LinkedListNode {
	int data;
	LinkedListNode next;
	
	public LinkedListNode(int data){
		this.data=data;
		this.next=null;
	}

	public void addToList(int data){
		LinkedListNode node = new LinkedListNode(data);
		LinkedListNode head = this;
		
		while(head.next !=null){
			head = head.next;
			
		}
		head.next=node;
	}
	
	public LinkedListNode delete(LinkedListNode head, int data){
		LinkedListNode node=head, temp;
		if(node.data==data){
			return node.next;
		}
		
		while(node.next != null){
			if(node.next.data==data){
				node.next=node.next.next;
				return head;
			}
			node=node.next;
				
		}
		return head;
	}
	
	public void printData(LinkedListNode head){
		LinkedListNode node=head;
		while(node != null){
			System.out.println("--> "+node.data);
			node=node.next;
		}
	}
	
	public static void main(String [] args){
		LinkedListNode head = new LinkedListNode(1);
		head.addToList(2);
		head.addToList(3);
		head.addToList(4);
		head.addToList(5);
		head.addToList(5);
		head.addToList(4);
		head.addToList(6);
		head.addToList(4);
		head.addToList(6);
		head.printData(head);
		//head.removeDuplicates(head);
		//head.printData(head);
		head.kthLastElement(head, 6);
		
	}
	
	public LinkedListNode removeDuplicates(LinkedListNode head){
		LinkedListNode current;
		current = head;
		
		while(current != null){
			LinkedListNode runner = current.next;
			LinkedListNode previous = current;
			while(runner != null){
				if(current.data == runner.data){
					LinkedListNode tmp;
					tmp = runner.next;
					previous.next = tmp;
				}
				previous = runner;
				runner =  runner.next;
			}
			current = current.next;
		}
		
		return head;
	}
	
	public void kthLastElement(LinkedListNode head, int n){
		int count = 1;
		LinkedListNode node=head, target=head;
		while (count <= n && node != null){
			node = node.next;
			count ++;
		}
		if(node == null){
			System.out.println("index does not exist");
			System.exit(1);
		}
		
		while(node != null){
			target = target.next;
			node = node.next;
		}
		System.out.println("The "+n+"th value from last is "+target.data);
	}
}
