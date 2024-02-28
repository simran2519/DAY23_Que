//3.Two elements of a binary search tree (BST) are swapped by mistake.
//
//        Tell us the 2 values swapping which the tree will be restored.
//
//        Note:
//
//        A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
//
//        Example :
//
//
//        Input :
//        1
//        / \
//        2   3
//
//        Output :
//        [1, 2]
//
//        Explanation : Swapping 1 and 2 will change the BST to be
//        2
//        / \
//        1   3
//        which is a valid BST
package DAY_23;


class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Q3 {

    // Variables to store the two swapped elements
    private TreeNode firstElement = null;
    private TreeNode secondElement = null;

    // Variable to keep track of the previous element while traversing the BST
    private TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    // Function to recover the BST by finding the two swapped elements
    public void recoverTree(TreeNode root) {
        // Traverse the BST in inorder fashion and find the two swapped elements
        traverse(root);

        // Swap the values of the two elements to restore the BST
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    // Inorder traversal to find the two swapped elements
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // Recursively traverse the left subtree
        traverse(root.left);

        // Check if the current element is out of order
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }

        // Update the previous element
        prevElement = root;

        // Recursively traverse the right subtree
        traverse(root.right);
    }

    // Helper function to print the swapped elements
    public void printSwappedElements() {
        System.out.println("[" + firstElement.val + ", " + secondElement.val + "]");
    }

    public static void main(String[] args) {
        // Create a binary search tree with two elements swapped
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // Create an instance of BSTRecover class
        Q3 bstRecover = new Q3();

        // Recover the BST and print the swapped elements
        bstRecover.recoverTree(root);
        bstRecover.printSwappedElements();
    }
}

//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Collections;
//
//class Node {
//    int data;
//    Node left;
//    Node right;
//    Node(int data)
//    {
//        this.data = data;
//        this.left = this.right = null;
//    }
//}
//
//public class Q3{
//    public static void storeInVector(Node root,
//                                     ArrayList<Integer> vec)
//    {
//        if (root == null)
//            return;
//        storeInVector(root.left, vec);
//        vec.add(root.data);
//        storeInVector(root.right, vec);
//    }
//    public static void
//    correctBSTUtil(Node root, ArrayList<Integer> vec,
//                   int[] index)
//    {
//        if (root == null)
//            return;
//        correctBSTUtil(root.left, vec, index);
//        root.data = vec.get(index[0]);
//        index[0]++;
//        correctBSTUtil(root.right, vec, index);
//    }
//
//    public static void correctBST(Node root)
//    {
//        // ArrayList to store the inorder traversal of
//        // given tree
//        ArrayList<Integer> vec = new ArrayList<Integer>();
//        storeInVector(root, vec);
//        Collections.sort(vec);
//        int[] index = { 0 };
//        correctBSTUtil(root, vec, index);
//    }
//
//    public static void printInorder(Node root)
//    {
//        if (root == null)
//            return;
//        printInorder(root.left);
//        System.out.print(root.data + " ");
//        printInorder(root.right);
//    }
//
//    public static void main(String[] args)
//    {
//        /*   6
//            / \
//           10  2
//          / \ / \
//         1  3 7 12
//
//        10 and 2 are swapped */
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//
////        Node root = new Node(6);
////        root.left = new Node(10);
////        root.right = new Node(2);
////        root.left.left = new Node(1);
////        root.left.right = new Node(3);
////        root.right.right = new Node(12);
////        root.right.left = new Node(7);
//
//        // Inorder traversal of the Original Tree
//        System.out.println(
//                "Inorder Traversal of the original tree");
//        printInorder(root);
//
//        correctBST(root);
//
//        // inorder traversal of the fixed tree
//        System.out.println(
//                "\nInorder Traversal of the fixed tree");
//        printInorder(root);
//    }
//}
