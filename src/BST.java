import java.sql.Array;
import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        /*
        if (setupTestData) {
            return false;
        }
        if (val == search(val)) {

        }
        */
        return false;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInOrder() {
        ArrayList<BSTNode> arrInOrder = new ArrayList<BSTNode>();
        inOrder(root, arrInOrder);
        return arrInOrder;
        // create new arraylist
        // pass it into recursive method
        // return arraylist
    }

    public void inOrder(BSTNode n, ArrayList<BSTNode> nodes) {
        if (n.getLeft() == null && n.getRight() == null) {
            return;
        }
        //System.out.println(n.getVal());
        inOrder(n.getLeft(), getInOrder());
        nodes.add(n);
        inOrder(n.getRight(), getInOrder());

    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> arrPreOrder = new ArrayList<BSTNode>();
        inOrder(root, arrPreOrder);
        return arrPreOrder;
    }

    public void preOrder(BSTNode n, ArrayList<BSTNode> nodes) {
        if (n.getLeft() == null && n.getRight() == null) {
            return;
        }
        System.out.println(n.getVal());
        inOrder(n.getLeft(), getInOrder());
        nodes.add(n);
        inOrder(n.getRight(), getInOrder());
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> arrPostOrder = new ArrayList<BSTNode>();
        inOrder(root, arrPostOrder);
        return arrPostOrder;
    }

    public void postOrder(BSTNode n, ArrayList<BSTNode> nodes) {
        if (n.getLeft() == null && n.getRight() == null) {
            return;
        }
        inOrder(n.getLeft(), getInOrder());
        nodes.add(n);
        inOrder(n.getRight(), getInOrder());
        System.out.println(n.getVal());

    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
