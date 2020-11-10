import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Filter {

    public static ArrayList<Person> cityFilter(String city, List<Person> persons) throws FileNotFoundException {
        ArrayList<Person> personsInTheCity = new ArrayList<>();
        for (Person person : persons) {
            if (person.getCity().equals(city)) {
                personsInTheCity.add(person);
            }
        }
        return personsInTheCity;
    }
}
