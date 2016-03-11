package lab08;
import java.util.Comparator;

public class Age implements Comparator<Person>{
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }
}
