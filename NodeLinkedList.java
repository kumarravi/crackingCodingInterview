package cracking.coding;

public class NodeLinkedList {
	
	NodeLinkedList next;
	int value;
	
	NodeLinkedList(int val){
		this.value = val;
		this.next = null;
	}
	
	public void insert (int val){
		NodeLinkedList New = new NodeLinkedList(val);
		NodeLinkedList n = this;
		while(n.next != null){
			n =  n.next;
		}
		n.next = New;
	}
	
	public NodeLinkedList delete(NodeLinkedList head, int val){
		NodeLinkedList n =head;

		if(n.value == val){
			return n.next;
		}
		
		while(n.next != null){
			if(n.next.value == val){
				n.next = n.next.next;
				return head;
			}
			n=n.next;
		}
		return head;
	}

}
