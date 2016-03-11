package lab11;

import javax.swing.*;

import f7.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class Laboration11 {
    public void exercise1() {
        BTNode<Integer> n6 = new BTNode<Integer>(new Integer(108), null, null);
        BTNode<Integer> n5 = new BTNode<Integer>(new Integer(100), null, null);
        BTNode<Integer> n4 = new BTNode<Integer>(new Integer(63), null, null);
        BTNode<Integer> n3 = new BTNode<Integer>(new Integer(110), n6, null);
        BTNode<Integer> n2 = new BTNode<Integer>(new Integer(74), n4, n5);
        BTNode<Integer> tree = new BTNode<Integer>(new Integer(102), n2, n3);
        tree.showTree();
        BTNode<Integer> res = tree.search(new Integer(1));
        if (res != null) {
            System.out.println("Finns");
        } else {
            System.out.println("Finns ej");
        }
        System.out.println();
        collections.ArrayList<Integer> list = new collections.ArrayList<>();
        tree.collectPreorder(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println();
        collections.LinkedList<Integer> linkedList = new collections.LinkedList<>();
        tree.collectLevelOrder(linkedList);
        Iterator<Integer> it = linkedList.iterator();
        while (it.hasNext())
            System.out.print(it.next() + " ");
    }

    public void exercise2() {
        BTNode<Character> n1 = new BTNode<Character>(new Character('G'), null, null);
        BTNode<Character> n2 = new BTNode<Character>(new Character('S'), n1, null);
        BTNode<Character> n3 = new BTNode<Character>(new Character('X'), n2, null);
        BTNode<Character> n4 = new BTNode<Character>(new Character('N'), n3, null);
        BTNode<Character> tree = new BTNode<Character>(new Character('A'), n4, null);
        tree.showTree();
    }

    public void exercise3() {
        BTNode<String> n1 = new BTNode<String>("Anna", null, null);
        BTNode<String> n2 = new BTNode<String>("Anders", null, null);
        BTNode<String> n3 = new BTNode<String>("Emil", null, null);
        BTNode<String> n4 = new BTNode<String>("Admir", null, null);
        BTNode<String> n5 = new BTNode<String>("Lene", n1, n2);
        BTNode<String> n6 = new BTNode<String>("Robert", n3, n4);
        BTNode<String> tree = new BTNode<String>("Ahmed", n5, n6);
        tree.showTree();
    }

    public void exercise4() {
        BTNode<Integer> n1 = new BTNode<>(17, null, null);
        BTNode<Integer> n2 = new BTNode<>(44, null, null);
        BTNode<Integer> n3 = new BTNode<>(36, null, null);
        BTNode<Integer> n4 = new BTNode<>(45, n2, null);
        BTNode<Integer> n5 = new BTNode<>(38, n3, n4);
        BTNode<Integer> n6 = new BTNode<>(15, null, n1);
        BTNode<Integer> tree = new BTNode<>(27, n6, n5);
        tree.showTree();
    }

    public void exercise5() {
        BTNode<Character> n1 = new BTNode<>('D', null, null);
        BTNode<Character> n2 = new BTNode<>('C', null, n1);
        BTNode<Character> n3 = new BTNode<>('B', null, n2);
        BTNode<Character> tree = new BTNode<>('A', null, n3);
        tree.showTree();
    }

    public void exercise6() {
        BTNode<Character> n1 = new BTNode<>('F', null, null);
        BTNode<Character> n2 = new BTNode<>('G', null, null);
        BTNode<Character> n3 = new BTNode<>('E', null, null);
        BTNode<Character> n4 = new BTNode<>('C', null, null);
        BTNode<Character> n5 = new BTNode<>('D', n1, n2);
        BTNode<Character> n6 = new BTNode<>('B', n5, n3);
        BTNode<Character> tree = new BTNode<>('A', n6, n4);
        tree.showTree();
    }

    public void exercise7() {

    }

    public static void main(String[] args) {
        Laboration11 lab11 = new Laboration11();
        lab11.exercise1();
    }
}

