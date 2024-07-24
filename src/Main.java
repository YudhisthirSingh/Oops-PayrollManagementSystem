import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name= " + name + ", id = " + id + ", salary = " + calculateSalary() + " ]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {

    private double hourlyRate;
    private int hoursWork;

    public PartTimeEmployee(String name, int id, int hoursWork, double hourlyRate) {
        super(name, id);
        this.hoursWork = hoursWork;
        this.hourlyRate = hourlyRate;

    }

    @Override
    public double calculateSalary() {
        return (hourlyRate) * (hoursWork);
    }
}

class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        employeeList.add(emp);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                employeeToRemove = emp;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee emp : employeeList) {
            System.out.print(emp);
        }
    }
}

public class Main {
    public static void main(String args[]) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee fullTime = new FullTimeEmployee("Vikas", 1, 50000);
        PartTimeEmployee partTime = new PartTimeEmployee("Kamlesh", 2, 5, 500);

        PayrollSystem system = new PayrollSystem();
        system.addEmployee(fullTime);
        system.addEmployee(partTime);
        //Display all employee details
        System.out.println("Display all employee details");
        system.displayEmployees();

        //remove part time employee
        System.out.println("Remove part time employee");
        system.removeEmployee(2);

        //Display all employee details after removal of part time employees
        System.out.println("Display all employee details after removal of part time employees");
        system.displayEmployees();
    }
}
