import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {
    public Read() {
    }
    public static ArrayList<Person> read() throws FileNotFoundException {
        ArrayList<Person>persons = new ArrayList<>();
        Scanner sc = new Scanner(new File("us-500.csv"));
        for (int i = 0; sc.hasNext(); i++) {
            String line = sc.nextLine();
            String[]parts = line.split(",");
            String fullName =parts[0]+ " " +parts[1];
            String city = parts[0];
            String email = parts[10];
            Person p = new Person(fullName,city,email);
            persons.add(p);
        }
        return persons;
    }
}
