package f11;

public class Traversal {
    public static void main(String[] args) {
        BTNode<Integer> n7 = new BTNode<Integer>( new Integer(45), null, null );
        BTNode<Integer> n6 = new BTNode<Integer>( new Integer(15), null, null );
        BTNode<Integer> n5 = new BTNode<Integer>( new Integer(31), null, null );
        BTNode<Integer> n4 = new BTNode<Integer>( new Integer(47), n7, null );
        BTNode<Integer> n3 = new BTNode<Integer>( new Integer(19), n6, null );
        BTNode<Integer> n2 = new BTNode<Integer>( new Integer(40), n5, n4 );
        BTNode<Integer> tree = new BTNode<Integer>( new Integer(23), n3, n2 );

        BTNode.Action<Integer> print = new PrintValue<Integer>();
        Sum sum = new Sum();
        System.out.print("Preorder: ");
        tree.preorder( print );
        tree.preorder( sum );
        System.out.println(", Summa=" + sum.getSum());
//        System.out.print("Inorder: ");
//        tree.inorder( print );
//        System.out.println();
//        System.out.print("Postorder: ");
//        tree.postorder( print );
//        System.out.println();
//        System.out.print("Level-order: ");
//        tree.levelOrder( print );
//        System.out.println();
//        tree.showTree();
    }
}


//System.out.print("Preorder: ");
//tree.preorder(new PrintValue<Integer>());
//System.out.println();
//System.out.print("Inorder: ");
//tree.inorder(new PrintValue<Integer>());
//System.out.println();
//System.out.print("Postorder: ");
//tree.postorder(new PrintValue<Integer>());
//System.out.println();
//System.out.print("Level-order: ");
//tree.levelOrder(new PrintValue<Integer>());
//System.out.println();
//System.out.print("SUMMA");
//tree.levelOrder(new PrintValue<Integer>());
//System.out.println();
//tree.showTree();


class PrintValue<T> implements BTNode.Action<T> {
    public void action(T value) {
        System.out.print(value + " ");
    }    
}


class Sum implements BTNode.Action<Integer> {
    private int sum =0;
    
    public void action(Integer value) {
        sum += value;
    }    
    
    public int getSum() {
        return sum;
    }
}
