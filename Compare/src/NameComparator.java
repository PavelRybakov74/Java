import java.util.Comparator;

class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        int res = emp1.name.compareTo(emp2.name);
        if (res==0) res = emp1.surname.compareTo(emp2.surname);
        return res;
    }
}
