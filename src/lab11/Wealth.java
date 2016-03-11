package lab11;
import java.util.*;

public class Wealth implements Comparator<Person>{
    public int compare(Person p1, Person p2) {
        return p2.getWealth() - p1.getWealth();
    }
}
