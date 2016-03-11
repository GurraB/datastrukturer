package f7;
import java.awt.*;

public class TestObjectList {
    public static void main(String[] args) {
        ObjectList list = new ObjectList();
        list.add( 0, new Color( 129, 32, 192 ) );
        list.add( 0, new Point( -12, 7 ) );
        list.add( 1, new Person( "Gunilla", 55 ) );
        list.add( 2, "Hej alla studenter!" );
        list.add( 0, new Long( 19266 ) );
        for( int i = 0; i < list.size(); i++ )
            System.out.println( list.get( i ) );
        while(list.size()>0) {
        	list.remove(0);
        	System.out.println(list);
        }
    }
}
