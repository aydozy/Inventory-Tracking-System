//-----------------------------------------------------
// Title: BinarySearchTreeQ1 Class
// Author: Ayda Nil Özyürek
// Description: The class in which we bring the data given to us as input into the tree structure.
//------------------------------------------------
public class BinarySearchTreeQ1 {

	private TreeNodeQ1 root;

	public TreeNodeQ1 getRoot() {
		return root;
	}

	public void setRoot(TreeNodeQ1 root) {
		this.root = root;
	}

	public BinarySearchTreeQ1() {
		this.root = null;
	}

	public void insert(Product product) {
		this.root = insert(this.root, product); // recursive call
	}

	private TreeNodeQ1 insert(TreeNodeQ1 root, Product product) {

		// --------------------------------------------------------
		// Summary: This is the method where we create the full tree structure. We add
		// the information of the product to the tree, right and left.
		// --------------------------------------------------------

		if (root == null) {
			root = new TreeNodeQ1(product);
			return root;
		}

		if (product.getId() < root.getData().getId()) {
			root.setLeft(insert(root.getLeft(), product)); // nodes are added to the left
		} else {
			root.setRight(insert(root.getRight(), product)); // nodes are added to the right
		}

		return root;
	}

	public Product traversal(int id) {
		return traversal(this.root, id); // recursive call
	}

	private Product traversal(TreeNodeQ1 root, int id) {
		// --------------------------------------------------------
		// Summary: With this method, we find the desired product  by looking at their
		// IDs. We search around the tree to the right and left.
		// --------------------------------------------------------
		
		if (root == null) {
			return null;
		}

		if (root != null && root.getData().getId() == id) {
			return root.getData();
		}

		Product wanted = traversal(root.getLeft(), id);
		if (wanted == null) {
			wanted = traversal(root.getRight(), id);
		}
		return wanted;
	}
}
