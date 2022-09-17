import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> arrayList = new ArrayList<>();
        String lowerSalaryLevel = "низких";
        String topSalaryLevel = "высоких";

        Company company = new Company(11_500_000);

        company.hireAll(hiring());
        System.out.println("Принято " + company.hashSetEmployees.size() + " сотрудников");
        System.out.println();

        arrayList.addAll(company.getTopSalaryStaff(10));
        printSalary(arrayList, topSalaryLevel);
        clear(arrayList);
        System.out.println();

        arrayList.addAll(company.getLowerSalaryStaff(30));
        printSalary(arrayList, lowerSalaryLevel);
        clear(arrayList);
        System.out.println();

        System.out.println("Колич.сотр." + company.hashSetEmployees.size());

        company.fire(50);
        System.out.println("Уволено " + (int)company.numberOfLayoffs + " сотрудников");

        System.out.println("Колич.сотр." + company.hashSetEmployees.size());
        System.out.println();

        arrayList.addAll(company.getTopSalaryStaff(10));
        printSalary(arrayList, topSalaryLevel);
        clear(arrayList);
        System.out.println();

        arrayList.addAll(company.getLowerSalaryStaff(30));
        printSalary(arrayList, lowerSalaryLevel);
        clear(arrayList);
        System.out.println();
    }

    public static void clear(List<Employee> arrayList) {
        arrayList.clear();
    }

    public static void printSalary(List<Employee> arrayList, String salaryLevel) {
        System.out.println("Список из " + arrayList.size() + " самых " + salaryLevel + " зарплат компании: ");
        for(Employee emp : arrayList) {
            System.out.println(emp.getMonthSalary() + " руб");
        }
    }

    public static Collection<Employee> hiring() {
        HashSet<Employee> hiredEmployees = new HashSet<>();
        for(int i = 0; i < 180; i++) {
            Operator operator = new Operator();
            hiredEmployees.add(operator);
        }
        for(int i = 0; i < 80; i++) {
            Manager manager = new Manager();
            hiredEmployees.add(manager);
        }
        for(int i = 0; i < 10; i++) {
            TopManager topManager = new TopManager();
            hiredEmployees.add(topManager);
        }
        return hiredEmployees;
    }
}


