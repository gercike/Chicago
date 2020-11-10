import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    public static ArrayList<Person> persons = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Reader read = new Reader();
        read.read();
        read.persons.sort(new ComparatorForLastNamesInAlphabeticalOrder());
        for (Person chicago : Filter.cityFilter("Chicago", persons)) {
            System.out.println(chicago.getEmail());
        }

    }

    public static void read() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("us-500.csv"));
        sc.nextLine();
        for (int i = 0; sc.hasNext(); i++) {
            String line = sc.nextLine();
            String[] parts = line.split(",");
            persons.add(new Person(parts[0], parts[1], parts[4], parts[10]));
        }
    }
}
