
import java.util.*;

public class Company {
    private static int income;
    double numberOfLayoffs = 0.0;
    HashSet<Employee> hashSetEmployees = new HashSet<>();

    public Company(int income) {
        this.income = income;
    }

    public void hire(Employee employee) {
        hashSetEmployees.add(employee);
    }

    public void hireAll(Collection<Employee> employees) {
        hashSetEmployees.addAll(employees);
    }

    public void fire(Employee employee) {
        hashSetEmployees.remove(employee);
    }
    public void fire(int percentageOfEmployees) {
        numberOfLayoffs = (hashSetEmployees.size() / 100.0) * (double) percentageOfEmployees;

        for(int i = 0; i < numberOfLayoffs; i++) {
            //находим рандомный объект в hashSetEmployees:
            Random randomizer = new Random();
            Object[] asArray = hashSetEmployees.toArray();
            Object randomEmployee = asArray[randomizer.nextInt(asArray.length)];
            hashSetEmployees.remove(randomEmployee);
       }
    }

    public static int getIncome() {
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        TreeSet<Employee> topSalaryStaff1 = new TreeSet<>(new EmployeeComparator().reversed());
        topSalaryStaff1.addAll(hashSetEmployees);
        List<Employee> topSalaryStaff = new ArrayList<>(topSalaryStaff1);
        topSalaryStaff = topSalaryStaff.subList(0, count);
        return topSalaryStaff;
    }

    public List<Employee> getLowerSalaryStaff(int count) {
        TreeSet<Employee> lowerSalaryStaff1 = new TreeSet<>(new EmployeeComparator());
        lowerSalaryStaff1.addAll(hashSetEmployees);
        List<Employee> lowerSalaryStaff = new ArrayList<>(lowerSalaryStaff1);
        lowerSalaryStaff = lowerSalaryStaff.subList(0, count);
        return lowerSalaryStaff;
    }
}
