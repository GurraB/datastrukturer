package f7;

public class TestGet {
    public static void main(String[] args) {
        ObjectNode pos4 = new ObjectNode( 9, null );
        ObjectNode pos3 = new ObjectNode( -5, pos4 );
        ObjectNode pos2 = new ObjectNode( 20, pos3 );
        ObjectNode pos1 = new ObjectNode( 17, pos2 );
        ObjectNode list = new ObjectNode( 23, pos1 );
        System.out.println(list);
        int index = 2;
        
        ObjectNode node = list;
        for(int currentPos = 0; currentPos < index; currentPos++ ) {
            node = node.getNext();
        }
        System.out.println( "Element " + index + " = " + node.getData() );
        
    }
}
