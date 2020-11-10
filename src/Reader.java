import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    public static ArrayList<Person> persons = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Reader read = new Reader();
        read.read();
        System.out.println(read.persons.size());
        read.persons.sort(new ComparatorForLastNamesInAlphabeticalOrder());
        System.out.println(read.persons);
    }

    public static void read() throws FileNotFoundException {

        Scanner sc = new Scanner(new File("us-500.csv"));
        sc.nextLine();
        for (int i = 0; sc.hasNext(); i++) {
            String line = sc.nextLine();
            String[] parts = line.split(",");
            persons.add(new Person(parts[0], parts[1], parts[5], parts[10]));
        }
    }
}
