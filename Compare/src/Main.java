import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
        public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        Employee emp1 = new Employee(100, "Pavel", "Rybakov", 25000);
        Employee emp2 = new Employee(30, "Ivan", "Petrov", 6500);
        Employee emp3 = new Employee(174, "Ivan", "Sidorov", 5000);

        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

        System.out.println("Before sorting \n" + list);
        Collections.sort(list);
        System.out.println("After sorting \n" + list);

        Collections.sort(list, new NameComparator());
        System.out.println("After name sorting \n" + list);

        Collections.sort(list, new SalaryComparator());
        System.out.println("After salary sorting \n" + list);
        }
}
