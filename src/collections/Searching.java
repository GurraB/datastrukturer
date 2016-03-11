package collections;

/**
 * Created by Gustaf on 05/02/2016.
 * Contains a method for binarysearch in an ArrayList and a method for linearsearch in a List
 */

public class Searching {

    /**
     * finds the position of element in list using binarysearch
     * @param list the list to search
     * @param element the element to be found
     * @param <E> type of the list
     * @return the position of the element, if it does not exist it returns -1
     */
    public static <E> int binearSearch(ArrayList<E> list, E element) {
        int res = -1, min = 0, max = list.size() - 1, pos;
        while( ( min <= max ) && ( res == -1 ) ) {
            pos = (min + max) / 2;
            if( ((Comparable) element).compareTo(list.get(pos)) == 0 )
                res = pos;
            else if( ((Comparable) element).compareTo(list.get(pos)) < 0)
                max = pos - 1;
            else
                min = pos + 1;
        }
        return res;
    }

    /**
     * finds the position of element in list using linearsearch
     * @param list the list to search
     * @param element the element to be found
     * @param <E> type of the list
     * @return the position of the element, if it does not exist it returns -1
     */
    public static <E> int linearSearch(List<E> list, E element) {
        for (int i = 0; i < list.size(); i++) {
            if(element.equals(list.get(i)))
                return i;
        }
        return -1;
    }
}
