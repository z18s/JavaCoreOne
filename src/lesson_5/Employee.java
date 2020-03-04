package lesson_5;

public class Employee {

    private String fullName;
    private String employment;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee (String fullName, String employment, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.employment = employment;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void info() {
        System.out.printf("%s is %s with salary %,d. Age: %d. Contacts: %s, tel. %s.\n",
                          fullName, employment, salary, age, email, phoneNumber);
    }
}