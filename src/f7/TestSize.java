package f7;

public class TestSize {
    public static void main(String[] args) {
        ObjectNode pos4 = new ObjectNode( 9, null );
        ObjectNode pos3 = new ObjectNode( -5, pos4 );
        ObjectNode pos2 = new ObjectNode( 20, pos3 );
        ObjectNode pos1 = new ObjectNode( 17, pos2 );
        ObjectNode list = new ObjectNode( 23, pos1 );
        // Vad ger:
//        ObjectNode list = new ObjectNode( 9, new ObjectNode( -5, new ObjectNode( 20, new ObjectNode( 17, new ObjectNode( 23, null ) ) ) ) );
        System.out.println(list);
        
//        int n = 0;
//        ObjectNode node = list;
//        while( node != null ) {
//            n++;
//            node = node.getNext();
//        }
//        System.out.println( "Size = " + n );        
    }
}
