import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public void display() {
        System.out.println(name + " (" + age + ", " + salary + ")");
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bob", 25, 60000));
        employees.add(new Employee("Charlie", 35, 55000));
        employees.add(new Employee("Alex", 28, 45000));
        employees.add(new Employee("Alex", 32, 47000));
        employees.add(new Employee("Alex", 25, 46000));
        employees.add(new Employee("David", 29, 50000));
        employees.add(new Employee("Eve", 31, 50000));
        employees.add(new Employee("Frank", 27, 50000));

        // Sorting by Name
        System.out.println("Sorting by Name:");
        employees.stream()
                .sorted(Comparator.comparing(emp -> emp.name))
                .forEach(Employee::display);

        // Sorting by Age
        System.out.println("\nSorting by Age:");
        employees.stream()
                .sorted(Comparator.comparingInt(emp -> emp.age))
                .forEach(Employee::display);

        // Sorting by Salary (Descending)
        System.out.println("\nSorting by Salary:");
        employees.stream()
                .sorted(Comparator.comparingDouble(emp -> -emp.salary))
                .forEach(Employee::display);
    }
}
