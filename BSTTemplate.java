public class BSTTemplate {
	private Node root = null;

	public void insert(int number) {
		root = insertNode(root, number);
	}

	private Node insertNode(Node root, int number) {
		Node newNode = new Node();
		newNode.value = number;
		newNode.right = null;
		newNode.left = null;

		if (root == null)
			return newNode;

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

	public static void main(String[] arguments) {
		BSTTemplate tree = new BSTTemplate();
		tree.insert(4);
		tree.insert(6);
		tree.insert(3);
		tree.insert(8);
		tree.insert(1);
		tree.insert(5);

		tree.printTree();
		System.out.println("Searching stuff.");
		System.out.println(tree.search(1));
		System.out.println(tree.search(8));
		System.out.println(tree.search(-98));
	}
}