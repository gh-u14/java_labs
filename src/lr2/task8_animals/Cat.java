package lr2.task8_animals;

public class Cat extends Animal {

    private String foodType;

    public Cat(String name, int age, String foodType) {
        super(name, age);
        this.foodType = foodType;
    }

    public String getFoodType() {
        return foodType;
    }

    @Override
    public void makeSound() {
        System.out.println("Мяу!");
    }

    public void purr() {
        System.out.println("Кошка мурлычет");
    }
}
