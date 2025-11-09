import java.util.*;

class BST {
    class Node {
        int value;
        Node left, right;
        Node(int val) { value = val; }
    }

    private Node root;

    public void insert(int val) {
        root = insertRec(root, val);
    }

    private Node insertRec(Node node, int val) {
        if (node == null) return new Node(val);
        if (val < node.value) node.left = insertRec(node.left, val);
        else if (val > node.value) node.right = insertRec(node.right, val);
        return node;
    }

    public void delete(int val) {
        root = deleteRec(root, val);
    }

    private Node deleteRec(Node node, int val) {
        if (node == null) return null;
        if (val < node.value) node.left = deleteRec(node.left, val);
        else if (val > node.value) node.right = deleteRec(node.right, val);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            node.value = minValue(node.right);
            node.right = deleteRec(node.right, node.value);
        }
        return node;
    }

    private int minValue(Node node) {
        while (node.left != null) node = node.left;
        return node.value;
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.value + " ");
            inorderRec(node.right);
        }
    }

    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node node) {
        if (node != null) {
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.value + " ");
        }
    }

    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    public boolean search(int val) {
        return searchRec(root, val);
    }

    private boolean searchRec(Node node, int val) {
        if (node == null) return false;
        if (val == node.value) return true;
        return val < node.value ? searchRec(node.left, val) : searchRec(node.right, val);
    }

    public List<Integer> path(int val) {
        List<Integer> result = new ArrayList<>();
        pathRec(root, val, result);
        return result;
    }

    private boolean pathRec(Node node, int val, List<Integer> result) {
        if (node == null) return false;
        result.add(node.value);
        if (node.value == val) return true;
        if ((node.left != null && pathRec(node.left, val, result)) ||
            (node.right != null && pathRec(node.right, val, result)))
            return true;
        result.remove(result.size() - 1);
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        // Step 1
        BST lab5Tree = new BST();

        // Step 2
        int[] values = {13, 22, 36, 5, 48, 17, 39, 2, 26, 40, 29, 34, 10};
        for (int val : values) lab5Tree.insert(val);

        // Step 3
        lab5Tree.delete(17);

        // Step 4
        System.out.print("Inorder: ");
        lab5Tree.inorder();

        // Step 5
        System.out.print("Postorder: ");
        lab5Tree.postorder();

        // Step 6
        System.out.print("Preorder: ");
        lab5Tree.preorder();

        // Step 7
        System.out.println("Search 36: " + lab5Tree.search(36));

        // Step 8
        System.out.println("Search 37: " + lab5Tree.search(37));

        // Step 9
        System.out.println("Path to 2: " + lab5Tree.path(2));

        // Step 10
        System.out.println("Path to 34: " + lab5Tree.path(34));
    }
}
