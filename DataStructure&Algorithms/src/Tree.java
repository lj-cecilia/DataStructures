import org.w3c.dom.Node;

import java.util.ArrayList;

public class Tree {
    //use a node class for basis, because the node class is implementation details of tree class
    //declare some node that has the property of tree
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node = " + value;
        }
    }
    private Node root;
    //line 3-20 is prepare for the tree class

    //insert method
    public void insert(int value) {
        //create a temp node if anything is null, we put this node with the intended insert value at the null place
        Node temp = new Node(value);

        //check to see if the root is null
        if (root == null) {
            root = temp;
            return;
        }

        //declare a current node to traverse the tree without actually change the root value
        Node current = root;
        while(true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = temp;
                    break;
                }
                current = current.leftChild;
            }
            else if (value > current.value) {
                if (current.rightChild == null) {
                    current.rightChild = temp;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    //find method
    public boolean find(int value) {
        Node current = root;
        //set condition of while loop to current node isn't null instead of "true" boolean because
        //for insert, there is always a place, then we can break out of the infinite while loop
        //but to find a value, it might not appear in the tree, so we need other parameters to define the while loop
        while (current != null) {
            if (value < current.value) current = current.leftChild; //value smaller than root so we choose the left direction
            else if (value > current.value) current = current.rightChild; //value larger than root so we choose the right direction
            else if (value == current.value) return true; //if value equals root then we find it
        }
        //if after we go through the entire while loop and couldn't find it
        //we will exit the loop because at some point the root is empty(null/)
        //at this point we know the value is not in the tree and thus can return false
        return false;
    }

    //traverse the tree in preorder way
    public void traversePreOrder() {
        traversePreOrder(root);
    }
    //this is actually implementation detail
    //recursive
    //is private because its not called from outside
    //is called inside the method above thus can be private (accessible within the same class)
    private void traversePreOrder(Node root) {
        //if the current node is null, that means we have reached the end of the tree, thus we can return
        if (root == null) return;

        //first print the value of the root
        //then go to the leftchild and rightchild
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    //traverse the tree in InOrder way
    public void traverseInOrder() {
        traverseInOrder(root);
    }
    private void traverseInOrder(Node root) {
        if (root == null) return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    //traverse the tree in PostOrder way
    public void traversePostOrder() {
        traversePostOrder(root);
    }
    private void traversePostOrder(Node root) {
        if (root == null) return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    //height function, recursive method
    public int height() {
        return height(root);
    }
    private int height(Node root) {
        if (root == null) return -1;
        //base case for recursive method
        //when both child of the root is null,
        //reach a leaf node, return 0 as the height of that node
        if (root.leftChild == null && root.rightChild == null) return 0;
        //Or you can write if(isLeaf()) return 0;

        //recursively evaluate the left child and right child's height and choose the larger one
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    //check if a node is a leaf node
    public boolean isLeaf(Node node) {
        //this statement is either true or false so we can return it directly
        return node.leftChild == null & node.rightChild == null;
    }

    //min method, we traverse the entire tree or an unorganized tree
    //time complexity o( n )
    public int min() {
        return min(root);
    }
    //actual min method
    public int min(Node root) {
        //look for min value, if it's a leaf node then it's automatically the minimum
        if (isLeaf(root))
            return root.value;

        //recursively call min until reach the leaf, which is the base case
        int left = min(root.leftChild);
        int right = min(root.rightChild);
        //第一个math.min半决赛在left和right之间，第二个总决赛进一步对比root value
        return Math.min(Math.min(left, right), root.value);
    }

    //TODO binary search tree is more organized than an ordinary binary tree, you can use a simpler algorithm to find min
    //TODO simply go to the left most leaf node and obtain the min
    //time complexity o( log n ) because we throw away half of the nodes
    //in other similar algorithms where we throw away half of the data, it would have logarithmic time complexity
    public int minSearchTree() {
        //exception of root is null
        //because we can't find a min in an empty tree
        if (root == null) throw new IllegalStateException();
        Node current = root;
        Node last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        //last is reference to the left most child
        return last.value;
    }

    //for binary search tree to find minimum value, source code from GeeksForGeeks
    static int minValue(Node node)
    {
        if (node.leftChild == null)
            return node.value;
        return minValue(node.leftChild);
    }

    //equality checking of two trees, if they are identical
    public boolean equals(Tree other) {
        //if only the other is null, then not equal
        if (other == null) return false;

        //check the above condition in the public method because if other(second) is null, can't read its root value below
        return equals(root, other.root);
    }
    private boolean equals(Node first, Node second) {
        //if both null, then yes equal
        if (first == null && second == null) return true;

        //if both not equal, want to check both the root, leftChild, rightChild
        if (first != null && second != null)
            //post order traversal
            return first.value == second.value
            && equals(first.rightChild, second.rightChild)
            && equals(first.leftChild, second.leftChild);

        //if one is null, the other is not, then automatically false
        return false;
    }

    //check if the tree is binarySearchTree
    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null) return true; //if the tree is empty, then it is binary search tree

        //pre order traversal, check the root first
        if (root.value < min || root.value > max) return false;
        //check the leftChild
        return isBinarySearchTree(root.leftChild, min, root.value - 1)
        && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    //Node at K Distance
    public ArrayList<Integer> NodeAtK(int k) {
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        NodeAtK(root, k, count, list);
        return list;
    }//you can also combine k and count into one variable distance
    //when we call recursive function, pass in distance - 1
    //then if distance is 0, we return
    private void NodeAtK(Node root, int k, int count, ArrayList<Integer> list) {
        if (root == null) return;
        count++;
        if (count == k) list.add(root.value);
        NodeAtK(root.leftChild, k, count, list);
        NodeAtK(root.rightChild, k, count, list);
    }

    //level order traversal
    //make use of the Node at K method, print the Node at distance 1, 2, 3
    public void traversalLevelOrder() {
        //notice the i start from 1, so we won't have an empty list
        //notice the i can range up to height + 1, since the distance is i - 1
        //它和自己的distance都是1，我服了为啥啊
        //FIXME mosh的code用的是k - 1也就是distanc，我用了coun，也许这是导致问题的原因
        //start at distance of 1 instead of return value itself
        for (int i = 1; i <= height() + 1; i++) {
            System.out.println(NodeAtK(i));
        }
    }


}
