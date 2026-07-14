class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;
//
    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return employeeId + " " + name + " " + position + " " + salary;
    }
}

public class EmployeeManagementSystem {

    static Employee[] employees = new Employee[10];
    static int size = 0;

    public static void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
            System.out.println("Employee Added");
        } else {
            System.out.println("Array is Full");
        }
    }

    public static int searchEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void deleteEmployee(int id) {
        int index = searchEmployee(id);

        if (index == -1) {
            System.out.println("Employee Not Found");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[size - 1] = null;
        size--;

        System.out.println("Employee Deleted");
    }

    public static void main(String[] args) {

        addEmployee(new Employee(101, "Rahul", "Manager", 60000));
        addEmployee(new Employee(102, "Amit", "Developer", 50000));
        addEmployee(new Employee(103, "Neha", "Tester", 45000));
        addEmployee(new Employee(104, "Priya", "HR", 55000));

        System.out.println("\nEmployee Records:");
        traverseEmployees();

        int index = searchEmployee(103);
        if (index != -1) {
            System.out.println("\nEmployee Found: " + employees[index]);
        } else {
            System.out.println("\nEmployee Not Found");
        }

        System.out.println("\nDeleting Employee 102...");
        deleteEmployee(102);

        System.out.println("\nEmployee Records After Deletion:");
        traverseEmployees();
    }
}