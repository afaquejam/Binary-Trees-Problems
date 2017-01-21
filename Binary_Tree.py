class TreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class BinaryTree:
    def __init__(self):
        self.root = None

    def size(self, root_node):
        if root_node == None:
            return 0
        return 1 + self.size(root_node.left) + self.size(root_node.right)

    def max_depth(self, root_node):
        if root_node == None:
            return 0

        if root_node.left == None and root_node.right == None:
            return 1

        return 1 + max(self.max_depth(root_node.left), self.max_depth(root_node.right))

if __name__ == "__main__":
    first = TreeNode(1)
    second = TreeNode(2)
    third = TreeNode(3)
    tree = BinaryTree()
    tree.root = second
    second.left = first
    second.right = third

    print("Printing tree")
    print(tree.root.data)
    print(tree.root.left.data)
    print(tree.root.right.data)

    print("Size of the tree is")
    # Different cases, 0, 1, 2, 3 and n nodes.
    print(tree.size(tree.root))

    print("Max depth of tree:")
    # Different cases, 0, 1, 2, 3 and n nodes.
    print(tree.max_depth(tree.root))
