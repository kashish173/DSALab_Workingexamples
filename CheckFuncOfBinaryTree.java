/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab8;

/**
 *
 * @author Kashish
 */

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class BinaryTree {
    Node root;

    // TASK 1. Calculate the height (level) of the binary tree
    public int calculateHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // TASK 2. Check if the binary tree is complete, full, or both
    public void checkTreeType(Node node) {
        boolean isComplete = isCompleteTree(node);
        boolean isFull = isFullTree(node);

        if (isComplete && isFull) {
            System.out.println("The tree is both a Complete Tree and a Full Tree.");
        } else if (isComplete) {
            System.out.println("The tree is a Complete Tree.");
        } else if (isFull) {
            System.out.println("The tree is a Full Tree.");
        } else {
            System.out.println("The tree is neither a Complete Tree nor a Full Tree.");
        }
    }

    // function 
    public boolean isCompleteTree(Node node) {
        if (node == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        boolean flag = false;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

           
            if (current == null) {
                flag = true;
            } else {
                if (flag) {
                    return false; 
                }
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return true;
    }

    //function
    public boolean isFullTree(Node node) {
        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            return true; 
        }

        if (node.left != null && node.right != null) {
            
            return isFullTree(node.left) && isFullTree(node.right);
        }

        return false; 
    }

    // TASK 3. Check the children sum property
    public boolean checkChildrenSumProperty(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return true; 
        }

        int leftData = (node.left != null) ? node.left.data : 0;
        int rightData = (node.right != null) ? node.right.data : 0;

        if (node.data == leftData + rightData && checkChildrenSumProperty(node.left) && checkChildrenSumProperty(node.right)) {
            return true;
        }

        return false;
    }

    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(2);

        System.out.println("Height of the binary tree: " + tree.calculateHeight(tree.root));

        tree.checkTreeType(tree.root);

        if (tree.checkChildrenSumProperty(tree.root)) {
            System.out.println("The tree satisfies the children sum property.");
        } else {
            System.out.println("The tree does not satisfy the children sum property.");
        }
    }
}
