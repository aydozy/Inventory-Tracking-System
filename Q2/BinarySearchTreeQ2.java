import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//-----------------------------------------------------
// Title: BinarySearchTreeQ2 Class
// Author: Ayda Nil Özyürek
// Description: The class in which we bring the data given to us as input into the tree structure.
//------------------------------------------------

public class BinarySearchTreeQ2 {

	private TreeNodeQ2 root;
	private List<TreeNodeQ2> list = new LinkedList<>();

	public TreeNodeQ2 getRoot() {
		return root;
	}

	public void setRoot(TreeNodeQ2 root) {
		this.root = root;
	}

	public BinarySearchTreeQ2() {
		this.root = null;
	}

	public void insert(Captain captain) {
		this.root = insert(this.root, captain); // recursive call
	}

	private TreeNodeQ2 insert(TreeNodeQ2 root, Captain captain) {
		// --------------------------------------------------------
		// Summary: This is the method where we create the full tree structure. We add
		// the information of the Captain to the tree, right and left.
		// --------------------------------------------------------
		if (root == null) {
			root = new TreeNodeQ2(captain);
			return root;
		}

		if (captain.getId() < root.getData().getId()) {
			root.setLeft(insert(root.getLeft(), captain));
		} else {
			root.setRight(insert(root.getRight(), captain));
		}

		return root;
	}

	public Captain traversal(int id) {
		TreeNodeQ2 result = traversal(this.root, id); // recursive call
		if (result == null) {
			return null;
		}
		return result.getData();
	}

	private TreeNodeQ2 traversal(TreeNodeQ2 root, int id) {
		// --------------------------------------------------------
		// Summary: With this method, we find the desired captain by looking at their
		// IDs. We search around the tree to the right and left.
		// --------------------------------------------------------

		if (root == null) {
			return null;
		}

		if (root != null && root.getData().getId() == id) {
			return root;
		}

		TreeNodeQ2 wanted = traversal(root.getLeft(), id);
		if (wanted == null) {
			wanted = traversal(root.getRight(), id);
		}
		return wanted;
	}

	public void delete(int id) {
		if (root == null)
			return;

		if (root.getLeft() == null && root.getRight() == null) {

			if (root.getData().getId() == id) {
				root = null;
				return;
			} else
				return;
		}

		Queue<TreeNodeQ2> q = new LinkedList<>();
		q.add(root);
		TreeNodeQ2 tem = null, keyNode = null;

		// Do level order traversal until we find key and last node.
		while (!q.isEmpty()) {
			tem = q.peek();
			q.remove();

			if (tem.getData().getId() == id) {
				System.out.println("Delete Captain: The captain " + tem.getData().getName() + " left CCR");
				System.out.println("----------------------------------------------------------------");
				keyNode = tem;
			}

			if (tem.getLeft() != null) {
				q.add(tem.getRight());
			}

			if (tem.getRight() != null) {
				q.add(tem.getRight());
			}

		}

		if (keyNode != null) {
			String str = tem.getData().getName();
			int x = tem.getData().getId();
			int y = tem.getData().getRatingStar();
			boolean z = tem.getData().isAvailable();

			deleteDeepest(root, tem);

			keyNode.getData().setName(str);
			keyNode.getData().setId(x);
			keyNode.getData().setRatingStar(y);
			keyNode.getData().setAvailable(z);
		}

	}

	private static void deleteDeepest(TreeNodeQ2 root, TreeNodeQ2 tem) {
		// --------------------------------------------------------
		// Summary: We find and delete the deepest one in the queue structure.The most
		// important thing here is to look left and right.
		// --------------------------------------------------------
		Queue<TreeNodeQ2> q = new LinkedList<>();
		q.add(root);

		TreeNodeQ2 temp = null;

		// Do level order traversal until last node
		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();

			if (temp == tem) {
				temp = null;
				return;
			}
			if (temp.getRight() != null) {
				if (temp.getRight() == tem) {
					temp.setRight(null);
					return;
				} else
					q.add(temp.getRight());
			}

			if (temp.getLeft() != null) {
				if (temp.getLeft() == tem) {
					temp.setLeft(null);
					return;
				} else
					q.add(temp.getLeft());
			}
		}
	}

	private void display(TreeNodeQ2 root) {
		// --------------------------------------------------------
		// Summary:Using the TreeNode class and using root, we get the information
		// placed to the right and left of our search tree.
		// --------------------------------------------------------
		if (root == null) {
			return;
		}

		list.add(root);
		display(root.getLeft());
		display(root.getRight());

	}

	public void displayAllCaptains() {
		// --------------------------------------------------------
		// Summary: A method that shows the remaining captains after this method is
		// deleted. At the same time, we can see the latest status about ratingStar and
		// availibilty.
		// --------------------------------------------------------

		list = new LinkedList<>();
		display(root); // recursive call
		Collections.sort(list); // The reason we use sort here is to make it print in the same order as the
								// output given to us.

		System.out.println("----------ALL CAPTAINS----------");
		for (TreeNodeQ2 nodeQ2 : list) {
			System.out.println("--CAPTAIN:");
			System.out.println("		       ID: " + nodeQ2.getData().getId());
			System.out.println("		       Name: " + nodeQ2.getData().getName());
			System.out.println("		       Available: " + nodeQ2.getData().isAvailable());
			System.out.println("		       Rating Star: " + nodeQ2.getData().getRatingStar());
		}

	}

}
