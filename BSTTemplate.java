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

	public int search(int key) {
		return 0;
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
	}
}