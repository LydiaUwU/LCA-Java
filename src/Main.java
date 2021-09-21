/**
 * @Author: Lydia MacBride, 19333944
 *
 * Main class to run an example program to demonstrate the functionality of my implementation of an LCA algorithm.
 */

public class Main {
    public static void main(String[] args) {
        //Initialise tree
        BST tree = new BST();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.addNode(50);
        tree.addNode(30);
        tree.addNode(20);
        tree.addNode(40);
        tree.addNode(70);
        tree.addNode(60);
        tree.addNode(80);

        //Example lca() call
        System.out.println("LCA of 20 and 40: " + tree.lca(20, 40).key);
    }
}
