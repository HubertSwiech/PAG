import java.util.Objects;

/**
 * An animal with specified name, color, gender, age, number of legs, weight.
 * It can be specified if an animal is mammal or it can fly.
 * @author Jakub Modrzewski 297792
 * @author Hubert Świech 304527
 * @version 1.0.0
 */
public class Pet {
    private String name = "Edwin";
    private String color = "black";
    private String gender = "male";
    private int age = 0;
    private int legs = 0;
    private double weight = 0.0;
    private boolean isMammal = false;
    private boolean canFly = false;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public int getLegs() {
        return legs;
    }
    public void setLegs(int legs) {
        this.legs = legs;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isMammal() {
        return isMammal;
    }
    public void setIsMammal(boolean isMammal) {
        this.isMammal = isMammal;
    }

    public boolean canFly() {
        return canFly;
    }
    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public Pet() {
    }

    public Pet(String name, String color, String gender) {
        this.name = name;
        this.color = color;
        this.gender = gender;
    }

    public void eat() {
        System.out.printf("%s is eating...%n", getClass().getName());
        setWeight(getWeight() + 0.1);
    }

    public void sleep() {
        System.out.printf("%s is sleeping...%n", getClass().getName());
    }

    public void fly() {
        if (canFly) {
            System.out.printf("%s is flying...%n", getClass().getName());
        }
    }

    @Override
    public String toString() {
        return  getClass().getName() + ":[" +
                "name: " +  getName() + ", " +
                "color: " + getColor() + ", " +
                "gender: " + getGender() + ", " +
                "age: " + getAge() + ", " +
                "legs: " + getLegs() + ", " +
                "weight: " + getWeight() + ", " +
                "mammal: " + isMammal() + ", " +
                "can fly: " + canFly() + "]";
    }


    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;

        if (anObject instanceof Pet) {
            Pet other = (Pet) anObject;
            return getName().equals(other.getName()) && getColor().equals(other.getColor()) &&
                    getGender().equals(other.getGender()) && getAge() == other.getAge() &&
                    getLegs() == other.getLegs() && Double.compare(other.getWeight(), getWeight()) == 0 &&
                    isMammal() == other.isMammal() && canFly() == other.canFly();
        }

        return false;
    }

    @Override
    public int hashCode() {
       return Objects.hash(name, color, gender, age, legs, weight, isMammal, canFly);
    }

    /***
     * Test for the class.
     * @param args not used.
     */
    public static void main(String[] args) {

        Pet parrotAlice = new Pet();
        System.out.printf("%s%n", parrotAlice); // niejawne toString()

        parrotAlice.setName("Alice");
        System.out.printf("%s%n", parrotAlice);

        parrotAlice.setColor("red");
        System.out.printf("%s%n", parrotAlice);

        parrotAlice.setGender("female");
        System.out.printf("%s%n", parrotAlice);

        parrotAlice.setAge(2);
        System.out.printf("%s%n", parrotAlice);

        parrotAlice.setLegs(2);
        System.out.printf("%s%n", parrotAlice);

        parrotAlice.setWeight(1.25);
        System.out.printf("%s%n", parrotAlice);

        parrotAlice.setIsMammal(false);
        System.out.printf("%s%n", parrotAlice);

        parrotAlice.setCanFly(true);
        System.out.printf("%s%n", parrotAlice);

        // test operations
        parrotAlice.eat();
        parrotAlice.fly();
        parrotAlice.sleep();

        // test equals() method
        Pet p2 = new Pet();
        System.out.println(parrotAlice == p2);
        System.out.println(parrotAlice.equals(p2));
        System.out.println(p2.equals(parrotAlice));

        Pet p3 = new Pet("Alice", "blue", "female");
        System.out.println(parrotAlice == p3);
        System.out.println(parrotAlice.equals(p3));
        System.out.println(p3.equals(parrotAlice));

        // test hashCode() method
        System.out.printf("parrotAlice = %s, parrotAlice.hashCode() = %d%n", parrotAlice, parrotAlice.hashCode());
        System.out.printf("p2 = %s, p2.hashCode() = %d%n", p2, p2.hashCode()); // niejawne toString()

    }

}
