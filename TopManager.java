public class TopManager implements Employee {

    private int bonus = 0;
    private int CompanyIncome;

    public TopManager() {
        this.CompanyIncome = Company.getIncome();
    }

    public int getBonus() {
       if(CompanyIncome > 10_000_000) {
           bonus =  fixedSalary / 100 * 150;
       }
       return bonus;
    }

    @Override
    public int getMonthSalary() {
        return fixedSalary + getBonus();
    }
}
