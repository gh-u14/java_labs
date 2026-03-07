package lr2.task8_animals;

public class Bird extends Animal {

    private boolean canFly;

    public Bird(String name, int age, boolean canFly) {
        super(name, age);
        this.canFly = canFly;
    }

    public boolean isCanFly() {
        return canFly;
    }

    @Override
    public void makeSound() {
        System.out.println("Чик-чирик!");
    }

    public void fly() {
        if (canFly) {
            System.out.println("Птица летит");
        } else {
            System.out.println("Птица не умеет летать");
        }
    }
}
