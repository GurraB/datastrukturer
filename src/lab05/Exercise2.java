package lab05;
import java.util.*;
import java.io.*;

public class Exercise2 {
    private ArrayList<Person> persons = new ArrayList<Person>();
    
    public void readPersons( String filnamn ) {
        try {
            BufferedReader br = new BufferedReader( new FileReader( filnamn ) );
            String[] parts;
            Person person;
            String txt = br.readLine();
            while( txt != null ) {
                parts = txt.split( "," );
                person = new Person( parts[ 0 ], parts[ 1 ], parts[ 2 ] );
                persons.add( person );
                txt = br.readLine();
            }
            br.close();
        } catch( IOException e ) {
            System.out.println( "readPersons: " + e );
        }
    }

    public String toString() {
        return "Lagrade personer: " + persons.toString();
    }
    
    public void printPersons() {
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }
    
    public int position( String socialSecurityNumber ) {
        for (int i = 0; i < persons.size(); i++) {
            if(persons.get(i).getSocialSecurityNumber().equals(socialSecurityNumber))
                return i;
        }
        return -1;
    }
    
    public void printName( String socialSecurityNumber ) {
        for (Person person : persons) {
            if(person.getSocialSecurityNumber().equals(socialSecurityNumber)) {
                System.out.println(person.getFirstName() + " " + person.getLastName());
                return;
            }
        }
        System.out.println(socialSecurityNumber + " okänd");
    }
    
    public boolean containsFirstName( String firstName ) {
        return false; // Ta bort och skriv kod
    }
    
    public boolean changeLastName( String socialSecurityNumber, String lastName ) {
        return false; // Ta bort och skriv kod
    }


    
    public static void main( String[] args ) {
        Exercise2 ex2 = new Exercise2();
        ex2.readPersons( "src/lab05/personer.txt" );
//        System.out.println( ex2.toString() );
        ex2.printPersons();
        System.out.println();
        System.out.println( ex2.position( "840102-4567" ) );
        System.out.println( ex2.position( "111111-2222" ) );
        ex2.printName( "840102-4567" );
        ex2.printName( "111111-2222" );
//        System.out.println( ex2.containsFirstName( "Edit" ) );
//        System.out.println( ex2.containsFirstName( "Anna" ) );
//        ex2.changeLastName( "660503-8901", "Tr�drot" );
//        System.out.println( ex2.toString() );
    }
}