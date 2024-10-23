import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversalImplementation {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        long max = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            System.out.println("level");
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                System.out.println(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }

        System.out.println();
    }
}

