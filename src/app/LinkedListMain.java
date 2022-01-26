package app;

import java.util.Iterator;

public class LinkedListMain {
    public static void main(String[] args) {
        ListInterface<Integer> list = new RecursiveList<Integer>();
        list.insertLast(22);
        list.insertLast(23);
        list.insertLast(24);
        list.insertLast(25);
        list.insertLast(26);
        System.out.println(list.removeAt(0));
        System.out.println(printList(list));
        list.insertLast(22);
        list.insertLast(900);
        list.insertLast(143);
        list.insertLast(8);
        System.out.println(printList(list));
        list.removeFirst();
        System.out.println(printList(list));
        list.removeLast();
        System.out.println(printList(list));
        list.removeAt(1);
        System.out.println(printList(list));
        list.remove(100); // should throw an ItemNotFoundException*/
    }

    public static String printList(ListInterface<Integer> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> listIter = list.iterator();
        while (listIter.hasNext())
            sb.append(listIter.next()).append(" ");
        return sb.toString();
    }

}
