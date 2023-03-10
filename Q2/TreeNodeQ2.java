//-----------------------------------------------------
// Title: TreeNodeQ2 Class
// Author: Ayda Nil Özyürek
// Description: This class holds data for the binary search tree we will create.
//------------------------------------------------
public class TreeNodeQ2 implements Comparable{

	private Captain data; 
	private TreeNodeQ2 left;
	private TreeNodeQ2 right;
	
	public TreeNodeQ2(Captain data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public Captain getData() {
		return data;
	}
	
	public void setData(Captain data) {
		this.data = data;
	}
	
	public TreeNodeQ2 getLeft() {
		return left;
	}
	
	public void setLeft(TreeNodeQ2 left) {
		this.left = left;
	}
	
	public TreeNodeQ2 getRight() {
		return right;
	}
	
	public void setRight(TreeNodeQ2 right) {
		this.right = right;
	}	
	
	public int compareTo(Object o) {
		TreeNodeQ2 that = (TreeNodeQ2) o;
		if(this.getData().getId() > that.getData().getId()){
			return 1;
		}else if(this.getData().getId() < that.getData().getId()){
			return -1;
		}
		return 0;
	}
}
