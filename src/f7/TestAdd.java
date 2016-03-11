package f7;
import javax.swing.*;

public class TestAdd {
    public static void main(String[] args) {
        ObjectNode pos4 = new ObjectNode(9, null);
        ObjectNode pos3 = new ObjectNode(-5, pos4);
        ObjectNode pos2 = new ObjectNode(20, pos3);
        ObjectNode pos1 = new ObjectNode(17, pos2);
        ObjectNode list = new ObjectNode(23, pos1);
        System.out.println(list);

        // Sätta in 13 i position 2
        ObjectNode newPos2 = new ObjectNode(13, pos2);
        pos1.setNext(newPos2);
        System.out.println(list);

        // Sätta in 19 i position 0
//        ObjectNode newPos0 = new ObjectNode(19, list);
//        list = newPos0;
//        System.out.println(list);

        // Sätta in ett värde i position n
//        int v = Integer.parseInt(JOptionPane.showInputDialog("Ange ett värde"));
//        int n = Integer.parseInt(JOptionPane.showInputDialog("Ange en position"));
//
//        ObjectNode newNode;
////        if( n==0 ) {
////            newNode = new ObjectNode( v, list );
////            list = newNode;
////        } else {
//            ObjectNode node = list;
//            for (int currentPos = 0; currentPos < n - 1; currentPos++) {
//                node = node.getNext();
//            }
//            newNode = new ObjectNode(v, node.getNext());
//            node.setNext(newNode);
////        }
//        System.out.println(list);
    }
}
