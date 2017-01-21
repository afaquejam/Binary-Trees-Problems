import java.util.ArrayList;
public class RootToLeaf {
	private Node root = null;
	private int nodeCount;

	public void insert(int number) {
		root = insertNode(root, number);
	}

	private Node insertNode(Node root, int number) {
		Node newNode = new Node();
		newNode.value = number;
		newNode.right = null;
		newNode.left = null;

		if (root == null) {
			nodeCount++;
			return newNode;
		}

		if (number <= root.value) {
			root.left = insertNode(root.left, number);
		} else {
			root.right = insertNode(root.right, number);
		}

		return root;

	}

	// The search would be good for symbol tables.
	// In this case, we just search for the key.
	// Return the key if it's there.
	// Return -1 if it's not.
	public int search(int key) {
		return searchKey(root, key);
	}

	private int searchKey(Node root, int key) {
		if (root == null)
			return -1;

		if (key == root.value)
			return root.value;

		if (key < root.value)
			return searchKey(root.left, key);
		else
			return searchKey(root.right, key);
	}

	public void printTree() {
		inOrder(root);
	}

	private void preOrder(Node root) {
		if (root == null)
			return;

		System.out.println(root.value);
		preOrder(root.left);
		preOrder(root.right);
	}

	private void inOrder(Node root) {
		if (root == null)
			return;

		inOrder(root.left);
		System.out.println(root.value);
		inOrder(root.right);
	}

	private void postOrder(Node root) {
		if (root == null)
			return;

		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.value);
	}

	public int size() {
		return nodeCount;
	}

	public boolean hasPathSum(int pathSum) {
		if (root == null)
			return false;
		else
			return hasPathSum(root, pathSum, 0);
	}

	private boolean hasPathSum(Node root, int pathSum, int sum) {
		sum = sum + root.value;
		boolean hasLeftTree = false;
		boolean hasRightTree = false;

		if (root.left != null)
			hasLeftTree = hasPathSum(root.left, pathSum, sum);

		if (root.right != null)
			hasRightTree = hasPathSum(root.right, pathSum, sum);

		if (root.right == null && root.left == null)
			return pathSum == sum;
		else 
			return hasLeftTree || hasRightTree;
	}

	public void printRootToLeaf() {
		System.out.println("Printing All possible paths.");
		ArrayList<Integer> list = new ArrayList<Integer>();
		printRootToLeaf(root, list);

	}

	private void printRootToLeaf(Node node, ArrayList<Integer> list) {
		if (node == null)
			return;
		ArrayList<Integer> copyList = new ArrayList<Integer>(list);
		copyList.add(node.value);
		if (node.left == null && node.right == null) {
			for (Integer number : copyList)
				System.out.print(number + " ");
			System.out.println();
			return;
		}

		printRootToLeaf(node.left, copyList);
		printRootToLeaf(node.right, copyList);
	}

	

	public static void main(String[] arguments) {
		RootToLeaf tree = new RootToLeaf();
		tree.insert(5);
		tree.insert(4);
		tree.insert(8);
		tree.insert(11);
		tree.insert(13);
		tree.insert(7);
		tree.insert(2);
		tree.insert(1);

		
		tree.printTree();
		System.out.println(tree.hasPathSum(27));
		tree.printRootToLeaf();
		
	}
}