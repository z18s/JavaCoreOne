package lesson_5;

public class HomeworkFive {
    public static void main(String[] args) {

        Employee[] employeeArray = new Employee[5];

        employeeArray[0] = new Employee("Alexey Aladyin", "Admin Assistant", "aaladyin@zmail.ru", "+79651216756", 30000, 30);
        employeeArray[1] = new Employee("Viktor Chernov", "Scientist", "vchernov@zmail.ru", "+79579562152", 50000, 50);
        employeeArray[2] = new Employee("Alexander Guchkov", "Office Manager", "aguchkov@zmail.ru", "+79231256254", 25000, 24);
        employeeArray[3] = new Employee("Alexey Peshekhonov", "Programmer", "apeshekhonov@zmail.ru", "+79562034667", 48000, 42);
        employeeArray[4] = new Employee("Pavel Milyukov", "Engineer", "pmilyukov@zmail.ru", "+79532237549", 34000, 38);

        for (Employee employee : employeeArray) {
            if (employee.getAge() > 40) {
                employee.info();
            }
        }
    }
}