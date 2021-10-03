import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @Author: Lydia MacBride, 19333944
 *
 * JUnit Tests for various functions of my LCA implementation
 */

public class Tests {
    // ~~~~~~~~~~ Test constructors ~~~~~~~~~~
    // Test Node constructor
    @Test
    public void testNodeConstructor() {
        Node node = new Node(1);

        assertEquals(1, node.key);
    }

    // Test BST constructor
    @Test
    public void testBSTConstructor() {
        BST tree = new BST();

        assertNull(tree.root);
    }

    // ~~~~~~~~~~ Test getNode() ~~~~~~~~~~
    // Where root is null
    @Test
    public void TestGetNodeNull() {
        BST tree = new BST();

        assertNull(tree.getNode(1));
    }

    // Where search key doesn't exist
    @Test
    public void TestGetNodeNullKey() {
        BST tree = new BST();
        tree.addNode(1);

        assertNull(tree.getNode(2));
    }

    // Where root is equal to search key
    @Test
    public void TestGetNodeSameKey() {
        BST tree = new BST();
        tree.addNode(1);

        assertEquals(1, tree.getNode(1).key);
    }

    // Where search key is greater than root
    @Test
    public void TestGetNodeKeyGD() {
        BST tree = new BST();
        tree.addNode(1); // Root
        tree.addNode(2);

        assertEquals(2, tree.getNode(2).key);
    }

    // Where search key is less than root
    @Test
    public void TestGetNodeKeyLD() {
        BST tree = new BST();
        tree.addNode(2); // Root
        tree.addNode(1);

        assertEquals(1, tree.getNode(1).key);
    }

    // ~~~~~~~~~~ Test addNode() ~~~~~~~~~~
    // Add one node to tree
    @Test
    public void testAddNode() {
        BST tree = new BST();
        tree.addNode(10);
        assertEquals(10, tree.getNode(10).key);
    }

    // Check that values > root and vales < root are added correctly
    @Test
    public void testAddNode3() {
        BST tree = new BST();
        tree.addNode(2); // Root
        tree.addNode(1);
        tree.addNode(3);

        assertEquals(tree.getNode(1), tree.getNode(2).left);
        assertEquals(tree.getNode(3), tree.getNode(2).right);
    }

    // Check adding a child, and then its own child
    @Test
    public void testGrandChild() {
        BST tree = new BST();
        tree.addNode(3); // Root
        tree.addNode(2); // Child
        tree.addNode(1); // Grandchild

        assertEquals(tree.getNode(1), tree.getNode(3).left.left);
    }

    // ~~~~~~~~~~ Test lca() ~~~~~~~~~~
    // Where root is null
    @Test
    public void testLCANull() {
        BST tree = new BST();

        assertNull(tree.lca(1, 2));
    }

    // Where root is LCA and there are 3 nodes
    @Test
    public void testLCA3() {
        BST tree = new BST();
        tree.addNode(2); // Root and LCA
        tree.addNode(1);
        tree.addNode(3);

        assertEquals(tree.getNode(2), tree.lca(1, 3));
    }

    // Where LCA lies to left of root
    @Test
    public void testLCALeft() {
        BST tree = new BST();
        tree.addNode(4); // Root
        tree.addNode(2); // LCA
        tree.addNode(1);
        tree.addNode(3);

        assertEquals(tree.getNode(2), tree.lca(1, 3));
    }

    // Where LCA lies to right of root
    @Test
    public void testLCARight() {
        BST tree = new BST();
        tree.addNode(1); // Root
        tree.addNode(3); // LCA
        tree.addNode(2);
        tree.addNode(4);

        assertEquals(tree.getNode(3), tree.lca(2, 4));
    }
}
