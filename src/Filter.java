import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Filter {
    public Filter() {
    }
    public static ArrayList<String> cityFilter(String city, List<Person>) throws FileNotFoundException {
        ArrayList<String> personsInTheCity = new ArrayList<>();
        for (Person person : Read.read()) {
            if (person.getCity().equals(city)){
                personsInTheCity.add(person.getFullName());
            }
        }
        return personsInTheCity;
    }
}
