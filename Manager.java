public class Manager implements Employee {

    private final int incomeGeneratedByTheEmployee = (int) (Math.random() * ((141000 - 115000) + 1)) + 115000;

    @Override
    public int getMonthSalary() {
        int salary = Math.round(fixedSalary + (incomeGeneratedByTheEmployee / 100 * 5));
        return salary;
    }


}
