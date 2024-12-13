import java.sql.Array;
import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Angelica Chou
 * @version: 12/12/24
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

    //search for given value in tree
    public boolean search(int val) {
        return search(val, root);
    }

    //helper function
    public boolean search(int val, BSTNode node) {
        //if the value is in the tree, return true
        if (node.getVal() == val) {
            return true;
        }
        //if the children are empty, return false;
        if (node.getLeft() == null && node.getRight() == null) {
            return false;
        }
        return (search(val, node.getLeft()) || search(val, node.getRight()));
    }

    //function to add inOrder nodes into arrayList
    public ArrayList<BSTNode> getInOrder() {
        //create new arrayList
        ArrayList<BSTNode> arrInOrder = new ArrayList<BSTNode>();
        inOrder(root, arrInOrder);
        return arrInOrder;
    }

    //helper function for inOrder recursion
    public void inOrder(BSTNode n, ArrayList<BSTNode> nodes) {
        if (n == null) {
            return;
        }
        //inOrder: left, root, right
        inOrder(n.getLeft(), nodes);
        nodes.add(n);
        inOrder(n.getRight(), nodes);
    }

    //function to add preOrder nodes into arrayList
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> arrPreOrder = new ArrayList<BSTNode>();
        preOrder(root, arrPreOrder);
        return arrPreOrder;
    }

    //preOrder: root, left, right
    public void preOrder(BSTNode n, ArrayList<BSTNode> nodes) {
        if (n == null) {
            return;
        }
        nodes.add(n);
        preOrder(n.getLeft(), nodes);
        preOrder(n.getRight(), nodes);
    }

    //function to add posOrder nodes into arrayList
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> arrPostOrder = new ArrayList<BSTNode>();
        postOrder(root, arrPostOrder);
        return arrPostOrder;
    }

    //postOrder: left, right, root
    public void postOrder(BSTNode n, ArrayList<BSTNode> nodes) {
        if (n == null) {
            return;
        }
        postOrder(n.getLeft(), nodes);
        postOrder(n.getRight(), nodes);
        nodes.add(n);
    }

    //inserts given value into the tree where it fits
    public void insert(int val) {
        root = insert(val, root);
    }

    public BSTNode insert(int val, BSTNode node) {
        if (node == null) {
            node = new BSTNode(val);
            return node;
        }
        //if given value is less than a node, put it to the left of node
        else if (node.getVal() < val) {
            node.setLeft(insert(val, node.getLeft()));
        }
        //if given value is greater than node, put it to the right of the node
        else if (node.getVal() > val) {
            node.setRight(insert(val, node.getRight()));
        }
        return node;
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
        sol = tree.getInOrder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(7);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInOrder();
        printNodes(sol);
    }
}
