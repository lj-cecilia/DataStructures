public class AVLTree {
    private class AVLNode {
        private int height;
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode (int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value" + this.value;
        }
    }

    private AVLNode root;
    public void insert(int value) {
        root = insert(root, value);

    }
    //compare to insert in the other tree class, this is more concise
    private AVLNode insert(AVLNode root, int value) {
        if (root  == null) return new AVLNode(value);

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else
            root.rightChild = insert(root.rightChild, value);

        root.height = 1 + //the newly added node increase the height
                Math.max(height(root.leftChild), height(root.rightChild));
        //how recursion works, we first recursively go down into a side of the tree
        //then once we reach the base case, we recursively go back to
        //the unfinished part of the method and in that
        //we update all the height

        int balanceFactor = height(root.leftChild) - height(root.rightChild);
        if (balanceFactor > 1) System.out.println(root.value + " needs left rotate");
        else if (balanceFactor < -1) System.out.println(root.value + " need right rotate");

        return root;
    }

    private int height(AVLNode node) {
        if (node == null) return -1;
        //todo notice an empty tree has a height of -1

        return node.height;
        //abbreviated version is follow
        //if (node == null) ? -1 : node.height;
    }
}
