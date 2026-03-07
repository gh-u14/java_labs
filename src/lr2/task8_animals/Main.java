package lr2.task8_animals;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Бобик", 5, "овчарка");
        Cat cat = new Cat("Барсик", 6, "корм");
        Bird bird = new Bird("Кеша", 7, true);

        System.out.println("Собака: " + dog.getName() + ", " + dog.getAge() + " лет, порода: " + dog.getBreed());
        dog.makeSound();
        dog.fetch();

        System.out.println("\nКошка: " + cat.getName() + ", " + cat.getAge() + " лет, тип корма: " + cat.getFoodType());
        cat.makeSound();
        cat.purr();

        System.out.println("\nПтица: " + bird.getName() + ", " + bird.getAge() + " лет, летает: " + bird.isCanFly());
        bird.makeSound();
        bird.fly();
    }
}
