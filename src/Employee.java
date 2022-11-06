public class Employee {
    private String fullName;
    private int department;
    private double salary;
    private int id;
    private static int counter = 0;

    public Employee(String fullName, int department, double salary) {
        this.fullName = fullName;
        if (department < 1 || department > 5) throw new IllegalArgumentException("Отдел может быть от 1 до 5");
        else this.department = department;
        if (salary < 0) throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        else this.salary = salary;
        this.id = counter++;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getDepartment() {
        return this.department;
    }

    public double getSalary() {
        return this.salary;
    }

    public int getId() {
        return this.id;
    }

    public double setSalary(double salary) {
        return this.salary = salary;
    }

    public int setDepartment(int department) {
        return this.department = department;
    }

    @Override
    public String toString() {
        return "ФИО: "+fullName+"  Отдел: "+department+"  Зарплата: "+salary+" руб.  ID: "+id;
    }
}
