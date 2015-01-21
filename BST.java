package cracking.coding;

public class BST {
	Node root;
	static class Node{
		Node left, right;
		int value;
		
		public Node(int value){
			this.value=value;
			left=right=null;
		}
	}
	
	public static void main(String Args[]){
		BST bst = new BST();
		//bst.run();
		bst.minimalBSTRun();
		
	}
	
	public void run(){
		insert(root, 1);
		insert(root, 2);
		insert(root, 3);
		insert(root, 4);
		insert(root, 5);
		insert(root, 6);
		insert(root, 7);
		insert(root, 8);
		insert(root, 9);
		insert(root, 10);
		
		//inOrder(root);
		System.out.println(isBalanced(root));
		System.out.println(getHeight(root));
	}
	
	public void minimalBSTRun(){
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		
		root = createMinimalBST(arr);
		System.out.println(isBalanced(root));
		System.out.println(getHeight(root));
		
	}
	
	public void insert(Node node, int data){
		if(root==null){
			root= new Node(data);
			return;
		}
		if(data < node.value){
			if(node.left != null){
				insert(node.left, data);
			}else{
				node.left = new Node(data);
			}
		}else{
			if(node.right != null){
				insert(node.right, data);
			}else{
				node.right=new Node(data);
			}
		}
	}
	
	public void inOrder(Node node){
		if(node != null){
			inOrder(node.left);
			System.out.println(node.value);
			inOrder(node.right);
		}
	}
	
	public boolean isBalanced(Node node){
		
		if(node == null)
			return true;
		int diff = getHeight(node.left) - getHeight(node.right);
		if(Math.abs(diff)>1)
			return false;
		else
			return isBalanced(node.left) && isBalanced(node.right);
	}
	
	public int getHeight(Node node){
		if(node == null)
			return 0;
		return Math.max(getHeight(node.left), getHeight(node.right)) +1;
	}
	
	public Node MinimalBST(int arr[], int start, int end){
		if(end < start)
			return null;
		
		int mid = (start + end)/2;
		Node n = new Node(mid);
		n.left = MinimalBST(arr, start, mid-1);
		n.right = MinimalBST(arr, mid+1, end);
		
		return n;
	}
	
	public Node createMinimalBST(int arr[]){
		return MinimalBST(arr, 0, arr.length-1);
	}
	
	public void commonAncestorRun(){
		
	}
	public boolean isPresent(Node root, Node p){
		if(root==null) return false;
		if(root==p) return false;
		return true;
	}
	public Node findCommonAncestor(Node root, Node p, Node q){
		if(root == null) return null;
		if(p==root || q==root) return root;
		
		boolean is_p_on_left = isPresent(root, p);
		boolean is_q_on_left = isPresent(root, q);
		if(is_p_on_left != is_q_on_left)
			return root;
		
		Node childnode = is_p_on_left?root.left:root.right;
		return findCommonAncestor(childnode, p, q);
	}
	
	public Node commonAncestor(Node root, Node p, Node q){
		if(!isPresent(root, p) || !isPresent(root, q))
			return null;
		
		return findCommonAncestor(root, p, q);
	}

}
