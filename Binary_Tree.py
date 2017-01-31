class TreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class BinaryTree:
    def __init__(self):
        self.root = None

    def insert(self, data):
        self.root = self.__insert(data, self.root)

    def __insert(self, data, root):
        if root == None:
            return TreeNode(data)

        if data > root.data:
            root.right = self.__insert(data, root.right)

        else:
            root.left = self.__insert(data, root.left)
        return root

    def printTree(self):
        if self.root == None:
            print("Empty Tree!")
            return
        print("Printing tree in-order:")
        self.__printTree(self.root)

    def __printTree(self, root):
        if root == None:
            return
        self.__printTree(root.left)
        print(root.data)
        self.__printTree(root.right)

    def printPostOrder(self):
        if self.root == None:
            print("Empty Tree!")
            return
        print("Printing tree Post order:")
        self.__printPostOrder(self.root)

    def __printPostOrder(self, root):
        if root == None:
            return

        self.__printPostOrder(root.left)
        self.__printPostOrder(root.right)
        print(root.data)

    def hasPathSum(self, sum):
        return self.__hasPathSum(self.root, sum)

    def __hasPathSum(self, root, sum):
        if root == None:
            return False

        if root.left == None and root.right == None:
            return (sum - root.data) == 0

        leftTreeResult = self.__hasPathSum(root.left, (sum - root.data))
        if leftTreeResult:
            return True

        rightTreeResult = self.__hasPathSum(root.right, (sum - root.data))
        return leftTreeResult or rightTreeResult


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
    # first = TreeNode(1)
    # second = TreeNode(2)
    # third = TreeNode(3)
    # tree = BinaryTree()
    # tree.root = second
    # second.left = first
    # second.right = third
    #
    # print("Printing tree")
    # print(tree.root.data)
    # print(tree.root.left.data)
    # print(tree.root.right.data)
    #
    # print("Size of the tree is")
    # # Different cases, 0, 1, 2, 3 and n nodes.
    # print(tree.size(tree.root))
    #
    # print("Max depth of tree:")
    # # Different cases, 0, 1, 2, 3 and n nodes.
    # print(tree.max_depth(tree.root))

    binary_search_tree = BinaryTree()
    binary_search_tree.insert(4)
    binary_search_tree.insert(5)
    binary_search_tree.insert(2)
    binary_search_tree.insert(3)
    binary_search_tree.insert(1)
    binary_search_tree.printTree()
    binary_search_tree.printPostOrder()

    print(binary_search_tree.hasPathSum(7))
    print(binary_search_tree.hasPathSum(9))
    print(binary_search_tree.hasPathSum(10))
