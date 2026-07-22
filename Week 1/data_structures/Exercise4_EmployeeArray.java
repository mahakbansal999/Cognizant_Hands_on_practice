class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() { return employeeId; }

    @Override
    public String toString() {
        return String.format("Employee[id=%s, name=%s, position=%s, salary=%.2f]",
                employeeId, name, position, salary);
    }
}

public class Exercise4_EmployeeArray {
    private Employee[] employees;
    private int size;
    private int capacity;

    public Exercise4_EmployeeArray(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    public boolean add(Employee e) {
        if (size == capacity) {
            resize();
        }
        employees[size] = e;
        size++;
        return true;
    }

    private void resize() {
        capacity *= 2;
        Employee[] newArray = new Employee[capacity];
        System.arraycopy(employees, 0, newArray, 0, size);
        employees = newArray;
    }

    public Employee search(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean delete(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Exercise4_EmployeeArray manager = new Exercise4_EmployeeArray(5);
        manager.add(new Employee("E1", "Jamie Lee", "Engineer", 85000));
        manager.add(new Employee("E2", "Priya Nair", "Manager", 95000));

        manager.traverse();
        System.out.println(manager.search("E2"));

        manager.delete("E1");
        manager.traverse();
    }
}
