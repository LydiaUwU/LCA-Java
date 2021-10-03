/**
 * @Author: Lydia MacBride, 19333944
 *
 * Implementation of a Binary Search Tree, Nodes and a Lowest Common Ancestor algorithm
 * Heavily based on these posts:
 *  - https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 *  - https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 */

//BST Class
public class BST {
    Node root;

    //Binary standard tree constructor
    BST() {
        root = null;
    }

    //Call getNode()
    Node getNode(int key) {
        return getNode(root, key);
    }

    //Get node from tree
    Node getNode(Node root, int key) {
        //Base cases where root is null or search matches root
        if (root == null || root.key == key) {
            return root;
        }

        //Key greater than root's key
        if (key > root.key) {
            return getNode(root.right, key);
        }

        //Key less than root's key
        return getNode(root.left, key);
    }

    //Call addNode()
    void addNode(int key)
    {
        root = addNode(root, key);
    }

    //Add node to tree
    Node addNode(Node node, int key) {
        //Return new node if tree is empty
        if (node == null) {
            node = new Node(key);
            return node;
        }

        //Else recur through tree
        if (key < node.key) {
            node.left = addNode(node.left, key);
        } else if (key > node.key) {
            node.right = addNode(node.right, key);
        }

        //Return unchanged node
        return node;
    }

    //Calls lca(Node, int, int)
    Node lca(int n1, int n2) {
        return lca(root, n1, n2);
    }

    //Find lowest common ancestor of two nodes
    Node lca(Node node, int n1, int n2)
    {
        if (node == null) {
            return null;
        }

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.key > n1 && node.key > n2) {
            return lca(node.left, n1, n2);
        }

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.key < n1 && node.key < n2) {
            return lca(node.right, n1, n2);
        }

        return node;
    }
}

//Node Class
class Node {
    int key;
    Node right, left;

    //Node constructor
    Node(int key) {
        this.key = key;
        right = left = null;
    }
}