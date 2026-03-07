package lr2.task4_person;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("Ivan", 45, "M");
        System.out.println("Имя: " + person.getName());
        System.out.println("Возраст: " + person.getAge());
        System.out.println("Пол: " + person.getGender());

        person.setAge(46);
        System.out.println("Новый возраст: " + person.getAge());
    }
}
