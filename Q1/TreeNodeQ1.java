//-----------------------------------------------------
// Title: TreeNodeQ1 Class
// Author: Ayda Nil Özyürek
// Description: This class holds data for the binary search tree we will create.
//------------------------------------------------

public class TreeNodeQ1 {

	private Product data; 
	private TreeNodeQ1 left;
	private TreeNodeQ1 right;
	
	public TreeNodeQ1(Product data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public Product getData() {
		return data;
	}
	
	public void setData(Product data) {
		this.data = data;
	}
	
	public TreeNodeQ1 getLeft() {
		return left;
	}
	
	public void setLeft(TreeNodeQ1 left) {
		this.left = left;
	}
	
	public TreeNodeQ1 getRight() {
		return right;
	}
	
	public void setRight(TreeNodeQ1 right) {
		this.right = right;
	}	
}
