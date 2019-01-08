public class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s: %d$", name, salary);
    }

    public static void main(String[] args) {
        GenericArray<Employee> arr = new GenericArray<>();
        arr.addLast(new Employee("Bob", 1000));
        arr.addFirst(new Employee("Alice", 1200));
        arr.add(1, new Employee("Keith", 1500));
        System.out.println(arr);

        System.out.println(arr.get(0));
    }
}