package f7;
import javax.swing.*;

public class TestRemove {
    public static void main(String[] args) {
        ObjectNode pos4 = new ObjectNode(9, null);
        ObjectNode pos3 = new ObjectNode(-5, pos4);
        ObjectNode pos2 = new ObjectNode(20, pos3);
        ObjectNode pos1 = new ObjectNode(17, pos2);
        ObjectNode list = new ObjectNode(23, pos1);
        System.out.println(list);

        Integer value = (Integer)pos3.getData();
        pos2.setNext(pos4);
        System.out.println(list);
        System.out.println("Borttaget värde: " + value);

        value = (Integer)list.getData();
        list = pos1;
        System.out.println(list);
        System.out.println("Borttaget värde: " + value);

        int n = Integer.parseInt(JOptionPane.showInputDialog("Ange en position"));

        if (n == 0) {
            value = (Integer)list.getData();
            list = list.getNext();
        } else {
            ObjectNode node = list;
            int currentPos = 0;
            while (currentPos < n - 1) {
                currentPos++;
                node = node.getNext();
            }
            value = (Integer)node.getNext().getData();
            node.setNext(node.getNext().getNext());
        }
        System.out.println(list);
        System.out.println("Borttaget element: nr " + n + " med värdet " + value);
    }
}
