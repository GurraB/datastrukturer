package f11;

public class TestBTNode {
    public static void main(String[] args) {
        BTNode<Integer> n7 = new BTNode<Integer>( new Integer(45), null, null );
        BTNode<Integer> n6 = new BTNode<Integer>( new Integer(15), null, null );
        BTNode<Integer> n5 = new BTNode<Integer>( new Integer(31), null, null );
        BTNode<Integer> n4 = new BTNode<Integer>( new Integer(47), n7, null );
        BTNode<Integer> n3 = new BTNode<Integer>( new Integer(19), n6, null );
        BTNode<Integer> n2 = new BTNode<Integer>( new Integer(40), n5, n4 );
        BTNode<Integer> tree = new BTNode<Integer>( new Integer(23), n3, n2 );
        
        System.out.println( "Size = " + tree.size() + ", Height = " + tree.depth() );
        tree.showTree();
        
        System.out.println( "Size = " + n3.size() + ", Height = " + n3.depth() );
        n3.showTree();
        
        System.out.println( "Size = " + n2.size() + ", Height = " + n2.depth() );
        n2.showTree();
    }
}

