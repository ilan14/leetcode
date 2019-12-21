package base;

import java.util.List;
import java.util.ListIterator;

public class Lists {
    public static <E> void printList(List<E> list) {
        String str = toString(list);
        System.out.println(str);
    }

    public static <E> String toString(List<E> list) {
        if (list == null) {
            return "null";
        }

        if (list.isEmpty()) {
            return "[]";
        }

        StringBuilder s = new StringBuilder("[");
        ListIterator<E> it = list.listIterator();
        while (it.hasNext()) {
            s.append(it.next());
            if (it.hasNext()) {
               s.append(", ");
            }
        }
        s.append("]");

        return s.toString();
    }
}
