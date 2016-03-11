package lab07;
import f7.ObjectNode;

public class Laboration7a {
    
    public static void exercise2a() {
    	ObjectNode pos6 = new ObjectNode( 9, null );
    	ObjectNode pos5 = new ObjectNode( 11, pos6 );
    	ObjectNode pos4 = new ObjectNode( -9, pos5 );
    	ObjectNode pos3 = new ObjectNode( -5, pos4 );
    	ObjectNode pos2 = new ObjectNode( 20, pos3 );
    	ObjectNode pos1 = new ObjectNode( 17, pos2 );
    	ObjectNode list = new ObjectNode( 23, pos1 );
    	System.out.println( list );

        pos4.setNext(new ObjectNode(7, pos5));

        System.out.println( list );
    }
    
    public static void exercise2b() {
        ObjectNode list = new ObjectNode( 23, new ObjectNode( 17, new ObjectNode( 20,new ObjectNode( -5, new ObjectNode( -9, new ObjectNode( 11, new ObjectNode( 9, null ) ) ) ) ) ) );
        System.out.print("[ ");
        while(list != null) {
            System.out.print(list.getData() + " ");
            list = list.getNext();
        }
        System.out.print("]");
    }
    
    public static void exercise2c() {
        ObjectNode pos6 = new ObjectNode( 9, null );
        ObjectNode pos5 = new ObjectNode( 11, pos6 );
        ObjectNode pos4 = new ObjectNode( -9, pos5 );
        ObjectNode pos3 = new ObjectNode( -5, pos4 );
        ObjectNode pos2 = new ObjectNode( 20, pos3 );
        ObjectNode pos1 = new ObjectNode( 17, pos2 );
        ObjectNode list = new ObjectNode( 23, pos1 );
        System.out.println( list );
        
        pos1.setNext(new ObjectNode(-14, new ObjectNode(4, pos2)));

        System.out.println( list );
    }
    
    public static void exercise2d() {
        ObjectNode pos6 = new ObjectNode( 9, null );
        ObjectNode pos5 = new ObjectNode( 11, pos6 );
        ObjectNode pos4 = new ObjectNode( -9, pos5 );
        ObjectNode pos3 = new ObjectNode( -5, pos4 );
        ObjectNode pos2 = new ObjectNode( 20, pos3 );
        ObjectNode pos1 = new ObjectNode( 17, pos2 );
        ObjectNode list = new ObjectNode( 23, pos1 );
        System.out.println( list );

        pos1.setNext(new ObjectNode(-14, pos2));
        pos2.setNext(new ObjectNode(4, pos3));

        System.out.println( list );
    }
    
    public static void exercise2e() {
        ObjectNode pos6 = new ObjectNode( 9, null );
        ObjectNode pos5 = new ObjectNode( 11, pos6 );
        ObjectNode pos4 = new ObjectNode( -9, pos5 );
        ObjectNode pos3 = new ObjectNode( -5, pos4 );
        ObjectNode pos2 = new ObjectNode( 20, pos3 );
        ObjectNode pos1 = new ObjectNode( 17, pos2 );
        ObjectNode list = new ObjectNode( 23, pos1 );
        System.out.println( list );
        
        pos2.setNext(pos4);

        System.out.println( list );
    }
    
    public static void exercise2f() {
        ObjectNode list = new ObjectNode( 23, new ObjectNode( 17, new ObjectNode( 20,new ObjectNode( -5, new ObjectNode( -9, new ObjectNode( 11, new ObjectNode( 9, null ) ) ) ) ) ) );
        System.out.println( list );
        
        list = list.getNext();

        System.out.println( list );
    }
    
    public static void exercise2g() {
        ObjectNode pos6 = new ObjectNode( 9, null );
        ObjectNode pos5 = new ObjectNode( 11, pos6 );
        ObjectNode pos4 = new ObjectNode( -9, pos5 );
        ObjectNode pos3 = new ObjectNode( -5, pos4 );
        ObjectNode pos2 = new ObjectNode( 20, pos3 );
        ObjectNode pos1 = new ObjectNode( 17, pos2 );
        ObjectNode list = new ObjectNode( 23, pos1 );
        System.out.println( list );
        
        list = pos2;

        System.out.println( list );
    }
    
    public static void exercise2h() {
        ObjectNode list = new ObjectNode( 23, new ObjectNode( 17, new ObjectNode( 20,new ObjectNode( -5, new ObjectNode( -9, new ObjectNode( 11, new ObjectNode( 9, null ) ) ) ) ) ) );
        System.out.println( list );
        
        ObjectNode temp = list.getNext().getNext();
        list.getNext().setNext(null);
        list.setNext(null);
        list = temp;

        System.out.println( list );
    }
    
    public static void exercise2i() {
        ObjectNode pos6 = new ObjectNode( 9, null );
        ObjectNode pos5 = new ObjectNode( 11, pos6 );
        ObjectNode pos4 = new ObjectNode( -9, pos5 );
        ObjectNode pos3 = new ObjectNode( -5, pos4 );
        ObjectNode pos2 = new ObjectNode( 20, pos3 );
        ObjectNode pos1 = new ObjectNode( 17, pos2 );
        ObjectNode list = new ObjectNode( 23, pos1 );
        System.out.println( list );
        
        list.setNext(pos2);
        pos2.setNext(pos4);
        
        System.out.println( list );
    }    
    
    
    public static void main(String[] args) {        
//        Laboration7a.exercise2a();
//        Laboration7a.exercise2b();
//        Laboration7a.exercise2c();
//        Laboration7a.exercise2d();
//        Laboration7a.exercise2e();
//        Laboration7a.exercise2f();
//        Laboration7a.exercise2g();
        Laboration7a.exercise2h();
//        Laboration7a.exercise2i();
    }
}
