public class BSTTemplate {
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
		traverse(root);
	}

	private void traverse(Node root) {
		if (root == null)
			return;

		System.out.println(root.value);
		traverse(root.left);
		traverse(root.right);
	}

	public int size() {
		return nodeCount;
	}

	public int maxDepth() {
		return calculateDepth(root);
	}

	private int calculateDepth(Node root) {
		if (root == null)
			return 0;

		int count = 1;
		int leftSubTreeDepth = calculateDepth(root.left);
		int rightSubTreeDepth = calculateDepth(root.right);

		if (leftSubTreeDepth > rightSubTreeDepth)
			count = count + leftSubTreeDepth;
		else
			count = count + rightSubTreeDepth;

		return count;
	}


	public static void main(String[] arguments) {
		BSTTemplate tree = new BSTTemplate();
		tree.insert(6);
		tree.insert(4);
		tree.insert(3);
		tree.insert(8);
		tree.insert(1);
		tree.insert(5);
		tree.insert(0);

		
		tree.printTree();
		System.out.println("Searching stuff.");
		System.out.println(tree.search(1));
		System.out.println(tree.search(8));
		System.out.println(tree.search(-98));
		System.out.println("Number of node in this freaking tree: " +
			tree.size());
		System.out.println("Max Depth of Tree: " + tree.maxDepth());
	}
}