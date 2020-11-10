import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    public static ArrayList<Person> persons = new ArrayList<>();
    static Reader read = new Reader();

    public static void main(String[] args) throws FileNotFoundException {
        read.read();
        read.persons.sort(new ComparatorForLastNamesInAlphabeticalOrder());
        for (Person chicago : Filter.cityFilter("Chicago", persons)) {
            System.out.println(chicago.getEmail());
        }
        System.out.println(citizensOf("Chicago"));
    }

    //  give him one cityname, he will tell you the citizens
    public static ArrayList<Person> citizensOf(String cityName) throws FileNotFoundException {

        ArrayList<Person> citizensOf = Filter.cityFilter(cityName, read.persons);
        if (citizensOf.isEmpty()) {
            System.out.println("a városban lakó emberről nincs adatunk");
        }

        return citizensOf;
    }

    public static void read() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Chicago/us-500.csv"));
        sc.nextLine();
        for (int i = 0; sc.hasNext(); i++) {
            String line = sc.nextLine();
            String[] parts = line.split(",");
            persons.add(new Person(parts[0], parts[1], parts[4], parts[10]));
        }
    }
}
