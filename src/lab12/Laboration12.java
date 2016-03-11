package lab12;
import javax.swing.*;
import java.util.*;

public class Laboration12 {
    public void exercise1() {
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<Integer,Integer>();
        bst.put( new Integer(50), new Integer(50) );
        bst.put( new Integer(30), new Integer(30) );
        bst.put( new Integer(70), new Integer(70) );
        bst.put( new Integer(20), new Integer(20) );
        bst.put( new Integer(40), new Integer(40) );
        bst.put( new Integer(60), new Integer(60) );
        bst.put( new Integer(80), new Integer(80) );
        bst.put( new Integer(75), new Integer(75) );
        
        bst.root().showTree();
    }
    
    public void exercise2() {
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<Integer,Integer>();
        bst.put( new Integer(20), new Integer(20) );
        bst.put( new Integer(30), new Integer(30) );
        bst.put( new Integer(40), new Integer(40) );
        bst.put( new Integer(50), new Integer(50) );
        bst.put( new Integer(60), new Integer(60) );
        bst.put( new Integer(70), new Integer(70) );
        bst.put( new Integer(75), new Integer(75) );
        bst.put( new Integer(80), new Integer(80) );
        
        bst.root().showTree();
   }
    
    public void exercise3() {
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<Integer,Integer>();
        bst.put( new Integer(80), new Integer(80) );
        bst.put( new Integer(75), new Integer(75) );
        bst.put( new Integer(70), new Integer(70) );
        bst.put( new Integer(60), new Integer(60) );
        bst.put( new Integer(50), new Integer(50) );
        bst.put( new Integer(40), new Integer(40) );
        bst.put( new Integer(30), new Integer(30) );
        bst.put( new Integer(20), new Integer(20) );
        
        bst.root().showTree();
    }
    
    public void exercise4() {
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<Integer,Integer>();
        bst.put( new Integer(27), new Integer(27) );
        bst.put( new Integer(15), new Integer(15) );
        bst.put( new Integer(17), new Integer(17) );
        bst.put( new Integer(38), new Integer(38) );
        bst.put( new Integer(36), new Integer(36) );
        bst.put( new Integer(45), new Integer(45) );
        bst.put( new Integer(44), new Integer(44) );
        bst.root().showTree();
    }
    
    public void exercise5() {
        BinarySearchTree<String,String> bst = new BinarySearchTree<>();
        bst.put( "F", "F");
        bst.put( "B", "B");
        bst.put( "C", "C");
        bst.put( "D", "D");
        bst.put( "I", "I");
        bst.put( "H", "H");
        bst.put( "G", "G");
        bst.root().showTree();
    }
    
    /*********************** Uppgift 6 *************************/
    private BinarySearchTree<String,String> svenskEngelsk() {
        BinarySearchTree<String,String> tree = new BinarySearchTree<String,String>();
        tree.put("vacker","beautiful");
        tree.put("svart","black");
        tree.put("boll", "ball");
        tree.put("vit","white");
        tree.put("lärare","teacher");
        tree.put("karta","map");
        tree.put("hus","house");
        tree.put("vänster","left");
        tree.put("höger","right");
        return tree;
    }
    
    public void exercise6() {
        BinarySearchTree<String,String> tree = svenskEngelsk();
        String svenska = javax.swing.JOptionPane.showInputDialog( "Skriv ett svenskt ord" ), engelska;
        while( svenska!=null && !svenska.equals("slut") ) {
            // hämta värdet för det inmatade ordet ur trädet
            // visa resultatet i en dialog
            // låt användaren mata in ett nytt ord
            JOptionPane.showMessageDialog(null, svenska + " = " + tree.get(svenska));
            svenska = JOptionPane.showInputDialog( "Skriv ett svenskt ord" );
        }
    }
    
    /*********************** Uppgift 7 *************************/
    private TreeMap<String,String> capitals() {
        TreeMap<String,String> tree = new TreeMap<String,String>();
             // Skriv ca 10 rader med kod vilka lägger till par av typen ( land, huvudstad )
        return tree;
    }
    
    public void exercise7() {
        // Komplettera med kod
    }

    public void exercise8() {
        BinarySearchTree<String,String> bst = new BinarySearchTree<>();
        bst.put( "F", "F");
        bst.put( "B", "B");
        bst.put( "C", "C");
        bst.put( "D", "D");
        bst.put( "I", "I");
        bst.put( "H", "H");
        bst.put( "G", "G");
        bst.remove("C");
        System.out.println("size(): " + bst.size());
        System.out.println("size1(): " + bst.size1());
        System.out.println("size2(): " + bst.size2());
    }

    public void exercise9() {
        BinarySearchTree<String,String> bst = new BinarySearchTree<>();
        bst.put( "F", "F");
        bst.put( "B", "B");
        bst.put( "C", "C");
        bst.put( "D", "D");
        bst.put( "I", "I");
        bst.put( "H", "H");
        bst.put( "G", "G");
        System.out.println(bst.first());
    }

    public void exercise10() {
        BinarySearchTree<String,String> bst = new BinarySearchTree<>();
        bst.put( "F", "F");
        bst.put( "B", "B");
        bst.put( "C", "C");
        bst.put( "D", "D");
        bst.put( "I", "I");
        bst.put( "H", "H");
        bst.put( "G", "G");
        System.out.println(bst.last());
    }
    /*********************** Uppgift 11a + 11b *************************/
    private <K,V> AVLNode<K,V> rotateRight(AVLNode<K,V> node) {
        AVLNode<K, V> rootNode = node.left;
        node.left = rootNode.right;
        rootNode.right = node;
        return rootNode;
    }
    
    private <K,V> AVLNode<K,V> rotateLeft(AVLNode<K,V> node) {
        AVLNode<K, V> rootNode = node.right;
        node.right = rootNode.left;
        rootNode.left = node;
        return rootNode;
    }
    
    public void exercise11a() {
        AVLNode<Integer,Integer> n5 = new AVLNode<Integer,Integer>( new Integer(1), new Integer(1), null, null );
        AVLNode<Integer,Integer> n4 = new AVLNode<Integer,Integer>( new Integer(3), new Integer(3), n5, null );
        AVLNode<Integer,Integer> n3 = new AVLNode<Integer,Integer>( new Integer(10), new Integer(10), null, null );
        AVLNode<Integer,Integer> n2 = new AVLNode<Integer,Integer>( new Integer(5), new Integer(5), n4, n3 );
        AVLNode<Integer,Integer> n1 = new AVLNode<Integer,Integer>( new Integer(15), new Integer(15), null, null );
        AVLNode<Integer,Integer> root = new AVLNode<Integer,Integer>( new Integer(13), new Integer(13), n2, n1 );
        root.showAVL();
        root = rotateRight(root);
        root.showAVL();
    }
    
    public void exercise11b() {
        AVLNode<Integer,Integer> n5 = new AVLNode<Integer,Integer>( new Integer(15), new Integer(15), null, null );
        AVLNode<Integer,Integer> n4 = new AVLNode<Integer,Integer>( new Integer(13), new Integer(13), null, n5 );
        AVLNode<Integer,Integer> n3 = new AVLNode<Integer,Integer>( new Integer(5), new Integer(5), null, null );
        AVLNode<Integer,Integer> n2 = new AVLNode<Integer,Integer>( new Integer(1), new Integer(1), null, null );
        AVLNode<Integer,Integer> n1 = new AVLNode<Integer,Integer>( new Integer(10), new Integer(10), n3, n4 );
        AVLNode<Integer,Integer> root = new AVLNode<Integer,Integer>( new Integer(3), new Integer(3), n2, n1 );
        root.showAVL();
        root = rotateLeft(root);
        root.showAVL();
    }
    
    /*********************** Uppgift 12a + 12b + 12c *************************/
    private <K,V> int height(AVLNode<K,V> node ) {
        if( node == null )
            return -1;
        return 1 + Math.max( height( node.left ), height( node.right ));
    }
    
    private <K,V> AVLNode<K,V> balanceLeft(AVLNode<K,V> node) {
        if(height(node.left) - height(node.right) == 2) {
            if(height(node.left.left) - height(node.left.right) == -1) {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
            else
                node = rotateRight(node);
        }
        return node;
    }
    
    private <K,V> AVLNode<K,V> balanceRight(AVLNode<K,V> node) {
        if(height(node.right) - height(node.right) == 2) {
            if(height(node.right.right) - height(node.right.left) == -1) {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
            else
                node = rotateLeft(node);
        }
        return node;
    }

    public void exercise12a() {
        AVLNode<Integer,Integer> n5 = new AVLNode<Integer,Integer>( new Integer(1), new Integer(1), null, null );
        AVLNode<Integer,Integer> n4 = new AVLNode<Integer,Integer>( new Integer(3), new Integer(3), n5, null );
        AVLNode<Integer,Integer> n3 = new AVLNode<Integer,Integer>( new Integer(10), new Integer(10), null, null );
        AVLNode<Integer,Integer> n2 = new AVLNode<Integer,Integer>( new Integer(5), new Integer(5), n4, n3 );
        AVLNode<Integer,Integer> n1 = new AVLNode<Integer,Integer>( new Integer(15), new Integer(15), null, null );
        AVLNode<Integer,Integer> root = new AVLNode<Integer,Integer>( new Integer(13), new Integer(13), n2, n1 );
        root.showAVL();
        root = balanceLeft(root);
        root.showAVL();
        AVLNode<Integer,Integer> n6 = new AVLNode<Integer,Integer>( new Integer(2), new Integer(2), null, null );
        n5.right = n6;
        root.showAVL();
        root.left = balanceLeft(root.left);
        root.showAVL();
    }

    public void exercise12b() {
        AVLNode<Integer,Integer> n5 = new AVLNode<Integer,Integer>( new Integer(15), new Integer(15), null, null );
        AVLNode<Integer,Integer> n4 = new AVLNode<Integer,Integer>( new Integer(13), new Integer(13), null, n5 );
        AVLNode<Integer,Integer> n3 = new AVLNode<Integer,Integer>( new Integer(5), new Integer(5), null, null );
        AVLNode<Integer,Integer> n2 = new AVLNode<Integer,Integer>( new Integer(1), new Integer(1), null, null );
        AVLNode<Integer,Integer> n1 = new AVLNode<Integer,Integer>( new Integer(10), new Integer(10), n3, n4 );
        AVLNode<Integer,Integer> root = new AVLNode<Integer,Integer>( new Integer(3), new Integer(3), n2, n1 );
        root.showAVL();
        root = balanceRight(root);
        root.showAVL();
        AVLNode<Integer,Integer> n6 = new AVLNode<Integer,Integer>( new Integer(14), new Integer(14), null, null );
        n5.left = n6;
        root.showAVL();
        root.right = balanceRight(root.right);
        root.showAVL();
    }
    
    
    public static void main(String[] args) {
        Laboration12 lab12 = new Laboration12();
        lab12.exercise11b();
    }
}
