public class TreeImplementation {
    public static void main(String[] args) {
        //build a tree by yourself
        //tree class contain three fields, the root(value), the leftChild(Node), and the rightChild(Node)
        //insert(value), insert method pass in a value, void method
        //find(value), return a boolean

        //instantiate a tree
        Tree myTree = new Tree();

        //add values to the tree with insert method
        myTree.insert(7);
        myTree.insert(4);
        myTree.insert(9);
        myTree.insert(1);
        myTree.insert(6);
        myTree.insert(8);
        myTree.insert(10);

        Tree tree2 = new Tree();

        //add values to the tree with insert method
        //press alt 2 times and then -> arrow to change multiple lines at the same time
        tree2.insert(7);
        tree2.insert(4);
        tree2.insert(9);
        tree2.insert(1);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);

        System.out.println(myTree.equals(null));
        System.out.println(myTree.isBinarySearchTree());
        myTree.traversalLevelOrder();

        //System.out.println(myTree.NodeAtK(3));

        //test the find method
        /*
        System.out.println("Does myTree contains 2 ?\n Answer: " + myTree.find(2)); //don't have this in tree, return false
        System.out.println("Does myTree contains 8 ?\n Answer: " + myTree.find(8)); //have this in tree, return true*/

        //test the recursion traverse method
        /*
        myTree.traversePreOrder();
        myTree.traverseInOrder();
        myTree.traversePostOrder();
         */

        /*
        System.out.println("Height of myTree: " + myTree.height());
        System.out.println("Min value of myTree: " + myTree.min());*/

        System.out.println("Done");
    }
}
